package io.dxer.etl.util

import java.util.Properties

import scala.collection.JavaConversions.propertiesAsScalaMap


object Utils {

  /**
    * 是否是简单文本
    *
    * @param format
    * @return
    */
  def isSimpleText(format: String): Boolean = {
    if ("text".equalsIgnoreCase(format) || "csv".equalsIgnoreCase(format) || "tsv".equals(format)) {
      true
    } else false
  }

  def convertPropToMap(props: Properties): Map[String, String] = {
    if (props != null) props.toMap
    else Map[String, String]()
  }
}
