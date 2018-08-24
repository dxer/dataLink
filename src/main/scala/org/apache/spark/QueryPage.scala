package org.apache.spark

import javax.servlet.http.HttpServletRequest
import org.apache.spark.internal.Logging
import org.apache.spark.ui.{WebUIPage, UIUtils => SparkUIUtils}

import scala.xml.Node

private[spark] class QueryPage(parent: QueryTab)
  extends WebUIPage("") with Logging {

  override def render(request: HttpServletRequest): Seq[Node] = {
    val content = <p>TTPAGE</p>
    SparkUIUtils.headerSparkPage("Query", content, parent, Some(5000))
  }

}
