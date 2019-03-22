package org.apache.spark.sql.hbase

import java.io.Serializable

import com.google.common.base.Strings
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.hbase.mapreduce.{HFileOutputFormat2, LoadIncrementalHFiles}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, KeyValue, TableName}
import org.apache.hadoop.mapred.JobConf
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.internal.Logging
import org.apache.spark.sql.{Constants, DataFrame, Row}
import org.apache.spark.util.{SerializableConfiguration, Utils}
import org.json4s.DefaultFormats

import scala.collection.immutable.HashMap


/**
  * write hbase
  *
  * @param data
  */
class DataFrameFunctions(data: DataFrame) extends Logging with Serializable {

  def insertIntoHBase(tableName: String, options: Map[String, String] = new HashMap[String, String]): Unit = {
    val wrappedConf = {
      implicit val formats = DefaultFormats
      val hc = HBaseConfiguration.create()
      hc.set("hbase.zookeeper.quorum", options.getOrElse("hbase.zookeeper.quorum", "127.0.0.1:2181"))
      hc.set("hbase.client.keyvalue.maxsize", "104857600")

      options.foreach(p => hc.set(p._1, p._2))
      data.sparkSession.sparkContext.getConf.getAll
        .filter(_._1.toLowerCase.contains("hbase"))
        .foreach(p => hc.set(p._1, p._2))
      new SerializableConfiguration(hc)
    }

    val hbaseConf = wrappedConf.value

    var rowKeyField = options.getOrElse(Constants.HBASE_ROWKEY_FIELD, "")
    if (Strings.isNullOrEmpty(rowKeyField)) {
      data.schema.fields.foreach(t => {
        if (t.name.equalsIgnoreCase("ROWKEY")) {
          rowKeyField = t.name
        }
      })
      require(!Strings.isNullOrEmpty(rowKeyField), "Not set RowKey field")
    } else {
      require(data.schema.fields.map(_.name).contains(rowKeyField), "No field named " + rowKeyField)
    }

    log.warn("The rowkey field name is " + rowKeyField)

    val bulkLoadEnable = options.getOrElse(Constants.HBASE_BULKLOAD_ENABLE, "true").toBoolean
    val autoSort = options.getOrElse(Constants.HBASE_BULKLOAD_AUTOSORT, "false").toBoolean

    val rdd = if (bulkLoadEnable && autoSort) {
      data.sortWithinPartitions(rowKeyField).sort(rowKeyField).rdd
    } else {
      data.rdd
    }

    // create hbase if not exists
    if (options.getOrElse(Constants.HBASE_CHECK_TABLE, "true").toBoolean) {
      logInfo("hbase.check.table mode is true, if hbase table is not exists, it will create it")
      SparkHBaseUtils.createHBaseTableIfNotExists(hbaseConf, tableName, options)
    } else {
      logInfo("hbase.check.table mode is false, if hbase table is not available, it will not create it")
    }

    val tempDir = Utils.createTempDir()
    if (!Strings.isNullOrEmpty(hbaseConf.get("mapreduce.output.fileoutputformat.outputdir"))) {
      hbaseConf.set("mapreduce.output.fileoutputformat.outputdir", tempDir + "/outputDataset")
    }

    val fields = data.schema.toArray
    val rowKeyIndex = fields.zipWithIndex.filter(f => f._1.name == rowKeyField).head._2
    val otherFields = fields.zipWithIndex.filter(f => f._1.name != rowKeyField)

    lazy val setters = otherFields.map(r => HBaseValueSetterAndGetter.setValue(r))
    lazy val bulkLoadSetters = otherFields.sortBy(_._1.name)
      .map(r => HBaseValueSetterAndGetter.setBulkLoadValue(r))

    val family = options.getOrElse(Constants.HBASE_TABLE_FAMILY, "info")
    val familyBytes = Bytes.toBytes(family)

    val jobConf = new JobConf(hbaseConf)
    jobConf.set(TableOutputFormat.OUTPUT_TABLE, tableName)

    val job = Job.getInstance(jobConf)

    bulkLoadEnable match {
      case true => // bulk load mode
        job.setJobName("Spark2HBaseBulkImport")
        job.setMapOutputKeyClass(classOf[ImmutableBytesWritable])

        val conn = ConnectionFactory.createConnection(hbaseConf)
        val clusterConnection = conn.asInstanceOf[ClusterConnection]
        val table: Table = clusterConnection.getTable(TableName.valueOf(tableName))
        val regionLocator = new HRegionLocator(TableName.valueOf(tableName), clusterConnection)

        val tmpPath = s"/tmp/bulkload/${tableName}_${System.currentTimeMillis()}"

        def convertToBulkLoadKeyValue(row: Row) = {
          val rk = Bytes.toBytes(row.getString(rowKeyIndex))
          bulkLoadSetters.map(_.apply(rk, row, familyBytes))
        }

        rdd.flatMap(convertToBulkLoadKeyValue)
          .saveAsNewAPIHadoopFile(tmpPath,
            classOf[ImmutableBytesWritable],
            classOf[KeyValue],
            classOf[HFileOutputFormat2],
            job.getConfiguration)

        HFileOutputFormat2.configureIncrementalLoad(job, table, regionLocator)
        val bulkLoader: LoadIncrementalHFiles = new LoadIncrementalHFiles(hbaseConf)
        bulkLoader.doBulkLoad(new Path(tmpPath), new HTable(hbaseConf, tableName))

      //        Utils.deleteRecursively(tmpPath)
      case false =>
        jobConf.set(TableOutputFormat.OUTPUT_TABLE, tableName)
        jobConf.setOutputFormat(classOf[TableOutputFormat])

        def convertToPut(row: Row) = {
          val put = new Put(Bytes.toBytes(row.getString(rowKeyIndex)))
          setters.foreach(_.apply(put, row, familyBytes))
          (new ImmutableBytesWritable, put)
        }

        rdd.map(convertToPut).saveAsNewAPIHadoopDataset(job.getConfiguration)
    }
  }

}


