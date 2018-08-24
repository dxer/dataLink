package io.dxer.etl.util

import com.google.common.base.Strings

object SQLUtils {

  private val SQL_SPLIT = "(;\\s*\\r\\n)|(;\\s*\\n)"

  private val LINE_SPLIT = "(\\s*\\r\\n)|(\\s*\\n)"

  // 注释
  private val HEAD_COMMAND = "--"

  /**
    * 将内容解析成sql语句
    *
    * @param str
    * @return
    */
  def parseSqls(str: String): Array[String] = {

    if (!Strings.isNullOrEmpty(str)) {
      val lines = str.split(LINE_SPLIT)
      lines.foreach(println(_))
      if (lines != null) {
        val newSqlString = lines.filter(!_.startsWith(HEAD_COMMAND)).mkString("\n") // 过滤注释行
        return newSqlString.split(SQL_SPLIT).map(sql => {
          var r: String = null
          if (sql.endsWith(";")) {
            r = sql.substring(0, sql.length - 1)
          } else {
            r = sql.replaceAll(SQL_SPLIT, "")
          }
          r
        }).toArray
      }
    }
    Array[String]()
  }

  def main(args: Array[String]): Unit = {
    val sql = "select * from tttt;\r\nselect * from tt"
    val x = sql.split(LINE_SPLIT).foreach(println(_))
  }
}
