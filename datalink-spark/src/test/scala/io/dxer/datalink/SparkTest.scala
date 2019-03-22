package io.dxer.datalink

import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("test")
    conf.setMaster("local")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("file:///D:/1234.txt")

    println(lines.count())

    sc.stop()
  }
}
