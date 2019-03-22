package org.apache.spark.sql

object Constants {
  val HBASE_TABLE_NAME = "hbase.table.name"
  val SPARK_TABLE_SCHEMA: String = "spark.table.schema"
  val HBASE_TABLE_SCHEMA: String = "hbase.table.schema"
  val HBASE_SCAN_START_KEY: String = "hbase.scan.startKey"
  val HBASE_SCAN_STOP_KEY: String = "hbase.scan.stopKey"

  val HBASE_ROWKEY_FIELD = "hbase.table.rowkey.field"

  val HBASE_BULKLOAD_ENABLE = "hbase.bulkload.enable"
  val HBASE_BULKLOAD_AUTOSORT = "hbase.bulkload.autosort"
  val HBASE_CHECK_TABLE = "hbase.check.table"
  val HBASE_TABLE_FAMILY = "hbase.table.family"
}