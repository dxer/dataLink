package io.dxer.etl.operator

import com.google.common.base.Strings
import io.dxer.etl.ConnectionManager
import io.dxer.etl.sql.tree.Save
import org.apache.spark.SparkException
import org.apache.spark.sql.{DataFrameWriter, SaveMode, SparkSession}

class SaveOperator(sparkSession: SparkSession, save: Save) extends Operator {

  override def exec(): Unit = {
    val format = save.getFormat
    val df = sparkSession.table(save.getTableName)

    val properties = save.getProperties
    if (properties != null && !properties.isEmpty) {
      if (properties.containsKey("partition")) {
        val originPartitionNum = df.rdd.getNumPartitions
        val partitionNum = properties.getProperty("partition").toInt
        // 设置的新的分区数大于0并且小于之前的分区数
        if (partitionNum > 0 && originPartitionNum > partitionNum) df.repartition(partitionNum)
      }
    }

    val write = df.write

    // 设置保存模式
    val mode = save.getSaveMode
    if (!Strings.isNullOrEmpty(mode)) {
      val saveMode = mode.toLowerCase match {
        case "overwrite" => SaveMode.Overwrite
        case "append" => SaveMode.Append
        case "ignore" => SaveMode.Ignore
        case "error_if_exists" => SaveMode.ErrorIfExists
      }
      write.mode(saveMode)
    }

    format.toLowerCase match {
      case "hive" => { // 导入到hive表
        write.saveAsTable(save.getPath)
      }
      case "jdbc" => {
        val conn = ConnectionManager.getConnectByName(format)
        if (conn != null)
          throw new SparkException("")

        val props = conn.getProperties
        val options = Map[String, String](
          "url" -> props.getProperty("url"),
          "user" -> props.getProperty("user"),
          "password" -> props.getProperty("password")
        )

        write.format("jdbc").options(options).save(save.getPath)
      }
      case "csv" => write.csv(save.getPath)
      case "json" => write.json(save.getPath)
      case "parquet" =>
        write.parquet(save.getPath)
    }
  }

  def partition(write: DataFrameWriter[Any], colNames: Array[String]) {
    write.partitionBy(colNames: _*)
  }
}
