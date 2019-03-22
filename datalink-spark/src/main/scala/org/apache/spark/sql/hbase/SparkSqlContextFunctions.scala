package org.apache.spark.sql.hbase

import java.sql.Timestamp

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{Result, Scan}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.protobuf.ProtobufUtil
import org.apache.hadoop.hbase.util.{Base64, Bytes}
import org.apache.spark.internal.Logging
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Constants, DataFrame, Row, SparkSession}
import org.apache.spark.util.SerializableConfiguration
import org.json4s.NoTypeHints
import org.json4s.jackson.Serialization

import scala.collection.JavaConversions._
import scala.collection.immutable.HashMap
import scala.collection.mutable.ArrayBuffer

/**
  * read hbase as dataframe
  *
  * @param spark
  */
class SparkSqlContextFunctions(@transient val spark: SparkSession) extends Serializable with Logging {


  def convertScanToString(scan: Scan): String = {
    val proto = ProtobufUtil.toScan(scan)
    Base64.encodeBytes(proto.toByteArray())
  }

  def hbaseTableAsDataFrame(tableName: String,
                            options: Map[String, String] = new HashMap[String, String]): DataFrame = {
    val wrappedConf = {
      val hc = HBaseConfiguration.create()
      hc.set("hbase.zookeeper.quorum", options.getOrElse("hbase.zookeeper.quorum", "127.0.0.1:2181"))
      hc.set(TableInputFormat.INPUT_TABLE, tableName)
      options.foreach(p => hc.set(p._1, p._2))
      spark.sparkContext.getConf.getAll
        .filter(_._1.toLowerCase.contains("hbase"))
        .foreach(p => hc.set(p._1, p._2))

      // hbase table schema
      if (options.contains(Constants.HBASE_TABLE_SCHEMA)) {
        var str = ArrayBuffer[String]()
        options(Constants.HBASE_TABLE_SCHEMA)
          .split(",", -1).map(field =>
          if (!field.startsWith(":")) {
            str += field
          }
        )
        if (str.length > 1) hc.set(TableInputFormat.SCAN_COLUMNS, str.mkString(" "))
      }

      val scan = new Scan()


      if (options.contains(TableInputFormat.SCAN_ROW_START)) scan.setStartRow(Bytes.toBytes(options(TableInputFormat.SCAN_ROW_START)))
      if (options.contains(TableInputFormat.SCAN_ROW_STOP)) scan.setStopRow(Bytes.toBytes(options(TableInputFormat.SCAN_ROW_STOP)))

      scan.setCaching(options.getOrElse(TableInputFormat.SCAN_BATCHSIZE, "10000").toInt)
      scan.setCacheBlocks(options.getOrElse(TableInputFormat.SCAN_CACHEBLOCKS, "false").toBoolean)


      Array(Constants.SPARK_TABLE_SCHEMA, Constants.HBASE_TABLE_SCHEMA)
        .foldLeft((hc, options)) {
          case ((_hc, _options), pram) => if (_options.contains(pram)) _hc.set(pram, _options(pram))
            (_hc, _options)
        }

      hc.set(TableInputFormat.SCAN, convertScanToString(scan))
      new SerializableConfiguration(hc)
    }

    val hbaseConf = wrappedConf.value

    def schema: StructType = {
      import org.apache.spark.sql.types._
      Option(hbaseConf.get(Constants.SPARK_TABLE_SCHEMA)) match {
        case Some(schema) => SparkHBaseUtils.registerSparkTableSchema(schema)
        case None => StructType(
          Array(
            StructField("rowkey", StringType, nullable = false),
            StructField("content", StringType)
          )
        )
      }
    }

    Option(hbaseConf.get(Constants.SPARK_TABLE_SCHEMA)) match {
      case Some(s) =>
        require(hbaseConf.get(Constants.HBASE_TABLE_SCHEMA).nonEmpty,
          "Because the parameter spark.table.schema has been set, hbase.table.schema also needs to be set.")

        val sparkTableSchemas = schema.fields.map(f => SparkTableSchema(f.name, f.dataType))
        val hBaseTableSchemas = SparkHBaseUtils.registerHBaseTableSchema(hbaseConf.get(Constants.HBASE_TABLE_SCHEMA))

        require(sparkTableSchemas.length == hBaseTableSchemas.length,
          "The length of the parameter spark.table.schema must be the same as the parameter hbase.table.schema.")

        val schemas = sparkTableSchemas.zip(hBaseTableSchemas)
        val setters = schemas.map(schema => HBaseValueSetterAndGetter.getResultValue(schema))

        val hbaseRDD = spark.sparkContext.newAPIHadoopRDD(
          hbaseConf,
          classOf[TableInputFormat],
          classOf[ImmutableBytesWritable],
          classOf[Result])
          .map { case (_, result) => Row.fromSeq(setters.map(r => r.apply(result)).toSeq) }

        spark.sqlContext.createDataFrame(hbaseRDD, schema)

      case None =>
        val hbaseRDD = spark.sparkContext.newAPIHadoopRDD(
          hbaseConf,
          classOf[TableInputFormat],
          classOf[ImmutableBytesWritable],
          classOf[Result])
          .map { line =>
            val rowKey = Bytes.toString(line._2.getRow)

            implicit val formats = Serialization.formats(NoTypeHints)

            val content = line._2.getMap.navigableKeySet().flatMap { f =>
              line._2.getFamilyMap(f).map { c =>
                val columnName = Bytes.toString(f) + ":" + Bytes.toString(c._1)
                options.get("field.type." + columnName) match {
                  case Some(i) =>
                    val value = i match {
                      case "LongType" => Bytes.toLong(c._2)
                      case "FloatType" => Bytes.toFloat(c._2)
                      case "DoubleType" => Bytes.toDouble(c._2)
                      case "IntegerType" => Bytes.toInt(c._2)
                      case "BooleanType" => Bytes.toBoolean(c._2)
                      case "BinaryType" => c._2
                      case "TimestampType" => new Timestamp(Bytes.toLong(c._2))
                      case "DateType" => new java.sql.Date(Bytes.toLong(c._2))
                      case _ => Bytes.toString(c._2)
                    }
                    (columnName, value)
                  case None => (columnName, Bytes.toString(c._2))
                }
              }
            }.toMap
            val contentString = Serialization.write(content)
            Row.fromSeq((Seq(rowKey, contentString)))
          }
        spark.sqlContext.createDataFrame(hbaseRDD, schema)
    }
  }

}
