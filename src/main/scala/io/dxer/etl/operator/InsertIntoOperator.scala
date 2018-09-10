package io.dxer.etl.operator

import java.util.Properties

import com.google.common.base.Strings
import io.dxer.etl.ConnectionManager
import io.dxer.etl.operator.output.OutputFormat
import io.dxer.etl.sql.tree.InsertInto
import io.dxer.etl.util.{PropertiesUtils, Utils}
import org.apache.spark.SparkException
import org.apache.spark.sql._

/**
  * insert into
  *
  * @param sparkSession
  * @param insertInto
  */
class InsertIntoOperator(sparkSession: SparkSession, insertInto: InsertInto) extends Operator {

  override def exec(): Unit = {
    val format = insertInto.getFormat
    var path = insertInto.getPath
    val isLocal = insertInto.isLocal
    val isQuery = insertInto.isQuery
    val properties = insertInto.getProperties
    val partitionMap = insertInto.getPartitionMap

    if (isLocal && !path.startsWith("file:///")) { // 确保将结果写入到本地的时候是file:///前缀
      path = "file:///" + path
    }

    var df: DataFrame = null

    if (isQuery) {
      df = sparkSession.sql(insertInto.getQuery)
      require(df != null, "query error")
    } else {
      df = sparkSession.table(insertInto.getTableName)
      require(df != null, s"${insertInto.getTableName} is not exists")
    }

    if (properties != null && !properties.isEmpty) {
      if (properties.containsKey("partitionNum")) {
        val originPartitionNum = df.rdd.getNumPartitions
        val partitionNum = properties.getProperty("partitionNum").toInt
        // 设置的新的分区数大于0并且小于之前的分区数
        if (partitionNum > 0 && originPartitionNum > partitionNum) df.repartition(partitionNum)
      }
    }

    val write = df.write

    // 设置保存模式
    val mode = insertInto.getSaveMode
    if (!Strings.isNullOrEmpty(mode)) {
      val saveMode: SaveMode = mode.toLowerCase match {
        case "overwrite" => SaveMode.Overwrite
        case "append" => SaveMode.Append
        case "ignore" => SaveMode.Ignore
        case "error_if_exists" => SaveMode.ErrorIfExists
        case _ => null
      }
      if (saveMode != null) {
        write.mode(saveMode)
      }
    }

    val outputFormatClass = PropertiesUtils.getString(properties, "outputFormatClass")
    val outputFormat: OutputFormat = if (!Strings.isNullOrEmpty(outputFormatClass)) {
      try {
        Class.forName(outputFormatClass).newInstance().asInstanceOf[OutputFormat]
      } catch {
        case e: Exception =>
          throw new SparkException(s"Cannot load class ${outputFormatClass}")
      }
    } else null

    format.toLowerCase match {
      case _ if outputFormat != null =>
        outputFormat.run(insertInto)

      case "json" =>
        write.json(path)

      case "parquet" =>
        write.parquet(path)

      case "hive" =>
        write.saveAsTable(path)

      case "hbase" =>
        saveAsHBaseTable(write, path, properties)

      case _ if Utils.isSimpleText(format) =>
        write.options(Utils.convertPropToMap(properties)).csv(path)

      case _ if ConnectionManager.contains(format) => { //
        val connection = ConnectionManager.getConnectByName(format)
        require(connection != null, s"${connection.connectionType} Connection ${connection.name} is not exist")

        val driver = connection.properties.getProperty("driver")
        val url = connection.properties.getProperty("url")
        Class.forName(driver)

        //   Method 1:
        //        val props = conn.getProperties
        //        val options = Map[String, String](
        //          "driver" -> props.getProperty("driver"),
        //          "url" -> props.getProperty("url"),
        //          "user" -> props.getProperty("user"),
        //          "password" -> props.getProperty("password"),
        //          "dbtable" -> props.getProperty("dbtable")
        //        )
        //
        //        write.format("jdbc").options(options).save(path)

        // Method 2:
        write.jdbc(url, path, connection.properties)
      }
      case _ => throw new SparkException("Not support InsertIntoOperator")
    }
    setResultMsg("OK", msg = null)
  }

  private def saveAsHBaseTable(writer: DataFrameWriter[Row], path: String, properties: Properties): Unit = {
    var options = Utils.convertPropToMap(properties)
    options += ("hbase.table.name" -> path)
    writer.format("org.apache.spark.sql.execution.datasources.hbase")
      .options(options).save()
  }

  def partition(write: DataFrameWriter[Any], colNames: Array[String]) {
    write.partitionBy(colNames: _*)
  }
}
