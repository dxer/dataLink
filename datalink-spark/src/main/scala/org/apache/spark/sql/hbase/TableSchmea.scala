package org.apache.spark.sql.hbase

import org.apache.spark.sql.types.DataType

/**
  *
  * @param fieldName
  * @param fieldType
  */
case class SparkTableSchema(fieldName: String, fieldType: DataType)

/**
  *
  * @param family
  * @param qualifier
  * @param isRowkey
  */
case class HBaseTableSchema(family: String, qualifier: String, isRowkey: Boolean = false)
