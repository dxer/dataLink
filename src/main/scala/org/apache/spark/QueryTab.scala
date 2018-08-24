package org.apache.spark

import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession
import org.apache.spark.ui.{SparkUI, SparkUITab}
import org.apache.spark.QueryTab._

private[spark] class QueryTab(val sparkSession: SparkSession)
  extends SparkUITab(getSparkUI(sparkSession), "ETL") with Logging {

  private val STATIC_RESOURCE_DIR = "org/apache/spark/streaming/ui/static"
  attachPage(new QueryPage(this))

  def attach() {
    getSparkUI(sparkSession).attachTab(this)
    getSparkUI(sparkSession).addStaticHandler(STATIC_RESOURCE_DIR, "/static/streaming")
  }

  def detach() {
    getSparkUI(sparkSession).detachTab(this)
    getSparkUI(sparkSession).removeStaticHandler("/static/streaming")
  }

}

private[spark] object QueryTab {

  def getSparkUI(sparkSession: SparkSession): SparkUI = {
    sparkSession.sparkContext.ui.getOrElse {
      throw new SparkException("Parent SparkUI to attach this tab to not found!")
    }
  }
}
