package org.apache.spark.sql.sftp

import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources.{BaseRelation, TableScan}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{DataFrame, Row, SQLContext}


class DatasetRelation(fileType: String, path: String, params: Map[String, String])(@transient val sqlContext: SQLContext)
  extends BaseRelation with TableScan with Logging {

  val df = read()

  override def schema: StructType = df.schema

  override def buildScan(): RDD[Row] = df.rdd

  private def read(): DataFrame = {
    val reader = sqlContext.read

    fileType match {
      case "avro" => reader.format("avro").load(path)
      case "txt" => reader.format("text").load(path)
      case "csv" =>
        val options = scala.collection.mutable.HashMap[String, String]()
        if (params.contains("header")) options += ("header" -> params("header")) // 头部
        if (params.contains("delimiter")) options += ("delimiter" -> params("delimiter")) // 分隔符
        if (params.contains("quote")) options += ("quote" -> params("quote")) //
        if (params.contains("escape")) options += ("escape" -> params("escape")) //
        if (params.contains("multiLine")) options += ("multiLine" -> params("multiLine")) //
        if (params.contains("inferSchema")) options += ("inferSchema" -> params("inferSchema")) // 推断数据类型

        reader.options(options).csv(path)
      case _ => reader.format(fileType).options(params).load(path)
    }

  }
}
