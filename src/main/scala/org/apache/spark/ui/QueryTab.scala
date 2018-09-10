package org.apache.spark.ui

import org.apache.spark.SparkException
import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession

private[spark] class QueryTab(val sparkSession: SparkSession)
  extends SparkUITab(QueryTab.getSparkUI(sparkSession), "ETL") with Logging {

  private val STATIC_RESOURCE_DIR = "org/apache/spark/streaming/ui/static"
  attachPage(new QueryPage(this))

  def attach() {
    QueryTab.getSparkUI(sparkSession).attachTab(this)
    QueryTab.getSparkUI(sparkSession).addStaticHandler(STATIC_RESOURCE_DIR, "/static/streaming")
  }

  def detach() {
    QueryTab.getSparkUI(sparkSession).detachTab(this)
    QueryTab.getSparkUI(sparkSession).removeStaticHandler("/static/streaming")
  }

}

private[spark] object QueryTab {

  def getSparkUI(sparkSession: SparkSession): SparkUI = {
    sparkSession.sparkContext.ui.getOrElse {
      throw new SparkException("Parent SparkUI to attach this tab to not found!")
    }
  }
}
