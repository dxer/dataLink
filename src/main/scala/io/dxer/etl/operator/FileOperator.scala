package io.dxer.etl.operator

import io.dxer.etl.sql.tree.FileOper
import org.apache.hadoop.io.{LongWritable, Text}
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.spark.SparkException
import org.apache.spark.sql.SparkSession

class FileOperator(sparkSession: SparkSession, fileOper: FileOper) extends Operator {

  override def exec(): Unit = {
    val conf = sparkSession.sparkContext.hadoopConfiguration
    //    sparkSession.sparkContext.hadoopFile[LongWritable, Text, TextInputFormat]("")


    fileOper.getOperType.toLowerCase() match {
      case "put" =>
      case "get" =>
      case "delete" =>
      case _ => throw new SparkException("Not Support operation")
    }
  }


}
