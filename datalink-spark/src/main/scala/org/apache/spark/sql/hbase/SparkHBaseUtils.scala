package org.apache.spark.sql.hbase

import com.google.common.base.Strings
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.client.ConnectionFactory
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HColumnDescriptor, HTableDescriptor, TableName}
import org.apache.spark.internal.Logging
import org.apache.spark.sql.types._

/**
  * SparkHBaseUtils
  */
object SparkHBaseUtils extends Logging {

  def registerSparkTableSchema(schema: String): StructType = {
    StructType(schema.split(",", -1).map(x => {
      x.split(":") match {
        case Array(fieldName, dataType) =>
          val fieldType = dataType.trim.toLowerCase() match {
            case "long" => LongType
            case "float" => FloatType
            case "double" => DoubleType
            case "integer" => IntegerType
            case "int" => IntegerType
            case "boolean" => BooleanType
            case "binary" => BinaryType
            case "timestamp" => TimestampType
            case "datetype" => DateType
            case _ => StringType
          }
          StructField(fieldName.trim, fieldType)
      }
    }))
  }

  def registerHBaseTableSchema(schema: String): Array[HBaseTableSchema] = {
    schema.split(".", -1).map(x => {
      if (x.equalsIgnoreCase(":rowkey")) {
        HBaseTableSchema("", "", true)
      } else {
        val strs = x.split(":")
        HBaseTableSchema(strs(0), strs(1), false)
      }
    })
  }

  def registerSparkHBaseColumnMapping(s: String): Unit = {

  }

  /**
    * create hbase table is not exists
    *
    * @param hbaseConf
    * @param tableName
    * @param options
    */
  def createHBaseTableIfNotExists(hbaseConf: Configuration, tableName: String, options: Map[String, String]): Unit = {
    val table = TableName.valueOf(tableName)
    val connection = ConnectionFactory.createConnection(hbaseConf)
    val admin = connection.getAdmin
    if (admin.tableExists(table)) {
      logInfo(s"${tableName} is available")
    } else {
      val startKey = options.getOrElse("hbase.table.startkey", "")
      val endKey = options.getOrElse("hbase.table.endkey", "")
      val regionNum = options.getOrElse("hbase.table.region.num", "1").toInt

      val family = options.getOrElse("hbase.table.family", "info")

      if (regionNum > 1 && !Strings.isNullOrEmpty(startKey) && !Strings.isNullOrEmpty(endKey)) {
        val tableDesc = new HTableDescriptor(table)

        val cf = new HColumnDescriptor(Bytes.toBytes(family))
        tableDesc.addFamily(cf)

        val startKeyBytes = Bytes.toBytes(startKey)
        val endKeyBytes = Bytes.toBytes(endKey)
        val splitKeys = Bytes.split(startKeyBytes, endKeyBytes, regionNum - 3)
        admin.createTable(tableDesc, splitKeys)
        val regionLocations = connection.getRegionLocator(table).getAllRegionLocations
        while (regionLocations == null || regionLocations.size() == 0) {
          logDebug(s"region not allocated")
          Thread.sleep(1000)
        }
        logInfo(s"region allocated ${regionLocations}")
      } else {
        val tableDesc = new HTableDescriptor(table)

        val cf = new HColumnDescriptor(Bytes.toBytes(family))
        tableDesc.addFamily(cf)
        admin.createTable(tableDesc)
      }
    }
    admin.close()
    connection.close()
    logInfo(s"${tableName} table create success")
  }


}
