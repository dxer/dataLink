package io.dxer.etl.operator

import io.dxer.etl.sql.tree.FileOper
import io.dxer.etl.util.HDFSClient
import org.apache.hadoop.io.{LongWritable, Text}
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.spark.SparkException
import org.apache.spark.sql.SparkSession

class FileOperator(sparkSession: SparkSession, fileOper: FileOper) extends Operator {

  override def exec(): Unit = {
    val conf = sparkSession.sparkContext.hadoopConfiguration
    val hdfs = new HDFSClient(conf)
    hdfs.ls(fileOper.getSrc)

    //    sparkSession.sparkContext.hadoopFile[LongWritable, Text, TextInputFormat]("")


    fileOper.getOperType.toLowerCase() match {
      case "put" =>
      case "get" =>
      case "delete" =>
      case _ => throw new SparkException("Not Support operation")
    }
  }

  private def put(hdfs: HDFSClient, fileOper: FileOper): Unit = {
    hdfs.upload(fileOper.getSrc, fileOper.getDst)
  }

  private def delete(hdfs: HDFSClient, fileOper: FileOper): Unit = {
    hdfs.rm(fileOper.getSrc, true)
  }

  private def get(hdfs: HDFSClient, fileOper: FileOper): Unit = {
    hdfs.download(fileOper.getSrc, fileOper.getDst)
  }
}
