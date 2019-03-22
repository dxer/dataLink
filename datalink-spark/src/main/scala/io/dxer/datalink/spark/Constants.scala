package io.dxer.datalink.spark

object Constants {

  val HIVE = "hive"
  val JDBC = "jdbc"
  val HBASE = "hbase"
  val CSV = "csv"
  val TSV = "tsv"
  val TXT = "txt"
  val JSON = "json"
  val PARQUET = "parquet"
  val ORC = "orc"
  val AVRO = "avro"


  val JDBC_URL = "jdbc.url"
  val JDBC_USER = "jdbc.user"
  val JDBC_PASSWORD = "jdbc.password"
  val JDBC_DRIVER = "jdbc.driver"


  val GROK_COMPILE_PATTERN = "grok.compile.pattern"
  val GROK_ADD_PATTERN = "grok\\.add\\.pattern\\.(\\b\\w+\\b)"
}
