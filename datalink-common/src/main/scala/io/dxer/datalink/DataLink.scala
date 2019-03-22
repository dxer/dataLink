package io.dxer.datalink

import java.io.FileInputStream
import java.util.Properties
import java.util.concurrent.ConcurrentHashMap

import io.dxer.datalink.sql.ConnectionManager

import scala.collection.JavaConverters._
import scala.io.Source


class DataLinkEnv {

}


class DataLink {

  protected val connectionManager = new ConnectionManager

  protected val settings = new ConcurrentHashMap[String, String]()

  protected val processor = new ParamProcessor

  def init(args: Array[String]): Unit = {
    processor.process(args)

    val props = new Properties()
    if (processor.hasOption('c')) { //
      val configPath = processor.getValue('c')
      try {
        props.load(new FileInputStream(configPath))
        loadFromProps(props)
      } catch {
        case e: Exception => e.printStackTrace()
          System.exit(-1)
      }
    }
  }

  def loadFromProps(props: Properties): Unit = {
    if (props != null) {
      props.stringPropertyNames.asScala.
        foreach(key => settings.put(key, props.getProperty(key)))
    }
  }

  protected def getText(opt: Char): String = {
    processor.getValue(opt)
  }

  protected def getTextFromFile(opt: Char): String = {
    val filepath = processor.getValue(opt)
    Source.fromFile(filepath, "UTF-8").getLines().mkString("\n")
  }

  def run(args: Array[String]): Unit = {

  }

}

object DataLink {

  val dataLink = new DataLink

  def main(args: Array[String]): Unit = {
    dataLink.init(args)
    //    val clazz = Class.forName("io.dxer.datalink.spark.SparkEngine")
    //    val constructor = clazz.getConstructor(classOf[DataLinkEnv])
    //    val engine = constructor.newInstance(dataLink.env)
    //    engine.asInstanceOf[DataLink].run(args)
  }
}