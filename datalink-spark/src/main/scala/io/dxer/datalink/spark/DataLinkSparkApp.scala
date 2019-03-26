package io.dxer.datalink.spark

import com.google.common.base.Strings
import io.dxer.datalink.DataLink
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

import scala.collection.JavaConverters._

class DataLinkSparkApp extends DataLink {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val AppName = "DataLink on Spark"

  override def run(args: Array[String]): Unit = {
    init(args)

    val sqlText: String = if (processor.hasOption('e')) {
      getText('e')
    } else if (processor.hasOption('f')) {
      getTextFromFile('f')
    } else {
      ""
    }

    if (Strings.isNullOrEmpty(sqlText)) {
      return
    }

    val sparkConf = new SparkConf()
    if (settings != null && !settings.isEmpty) {
      sparkConf.setAll(settings.asScala)
    }

    sparkConf
      .setAppName(sparkConf.get("spark.app.name", AppName))
      .setMaster(sparkConf.get("spark.master", "local[*]"))

    val sparkSession = SparkSession.builder()
      .config(sparkConf)
      .getOrCreate()

    //  val env = DataLinkSparkEnv(sparkSession)

    val dataLinkEngine = new SparkEngine(new DataLinkSparkSession(sparkSession))
    dataLinkEngine.execute(sqlText)

    sparkSession.stop()
  }
}

object DataLinkSparkApp {
  def main(args: Array[String]): Unit = {
    new DataLinkSparkApp().run(args)
  }
}