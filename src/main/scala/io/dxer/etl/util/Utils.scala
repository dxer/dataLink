package io.dxer.etl.util

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

}
