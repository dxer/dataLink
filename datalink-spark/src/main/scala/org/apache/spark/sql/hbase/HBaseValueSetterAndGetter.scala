package org.apache.spark.sql.hbase

import java.sql.Timestamp

import org.apache.hadoop.hbase.KeyValue
import org.apache.hadoop.hbase.client.{Put, Result}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.joda.time.DateTime

object HBaseValueSetterAndGetter {

  type HBaseValueGetter = (Result) => Any

  def getResultValue[T](dataType: (SparkTableSchema, HBaseTableSchema)): HBaseValueGetter = {
    val (sparkSchema, hbaseSchema) = dataType

    val family = Bytes.toBytes(hbaseSchema.family)
    val qualifier = Bytes.toBytes(hbaseSchema.qualifier)

    sparkSchema.fieldType match {
      case LongType =>
        (result: Result) =>
          try {
            Bytes.toLong(result.getValue(family, qualifier))
          } catch {
            case e: Exception => 0L
          }
      case FloatType =>
        (result: Result) => Bytes.toFloat(result.getValue(family, qualifier))
      case DoubleType =>
        (result: Result) => Bytes.toDouble(result.getValue(family, qualifier))
      case IntegerType =>
        (result: Result) =>
          Bytes.toInt(result.getValue(family, qualifier))
      case BooleanType =>
        (result: Result) =>
          Bytes.toBoolean(result.getValue(family, qualifier))
      case BinaryType =>
        (result: Result) =>
          result.getValue(family, qualifier)
      case TimestampType =>
        (result: Result) =>
          new Timestamp(Bytes.toLong(result.getValue(family, qualifier)))
      case DateType =>
        (result: Result) =>
          new java.sql.Date(Bytes.toLong(result.getValue(family, qualifier)))
      case _ =>
        (result: Result) =>
          if (hbaseSchema.isRowkey) {
            Bytes.toString(result.getRow)
          } else {
            Bytes.toString(result.getValue(family, qualifier))
          }
    }
  }

  type HBaseValueSetter = (Put, Row, Array[Byte]) => Unit

  def setValue(dataType: (StructField, Int)): HBaseValueSetter = {
    val (structField, index) = dataType

    (put: Put, row: Row, family: Array[Byte]) => {
      val value: Array[Byte] = getValueFromRow(row, structField.dataType, index)
      put.addColumn(family, Bytes.toBytes(structField.name), value)
    }
  }

  type HBaseRowkeySetter = (Row) => Array[Byte]

  def setRowKey(dataType: (StructField, Int)): HBaseRowkeySetter = {
    val (structField, index) = dataType
    (row: Row) => getValueFromRow(row, structField.dataType, index)
  }

  private def getValueFromRow(row: Row, dataType: DataType, index: Int): Array[Byte] = {
    dataType match {
      case StringType =>
        if (row.getString(index) == null) Bytes.toBytes("")
        else Bytes.toBytes(row.getString(index))
      case LongType =>
        Bytes.toBytes(row.getLong(index))
      case FloatType =>
        Bytes.toBytes(row.getFloat(index))
      case DoubleType =>
        Bytes.toBytes(row.getDouble(index))
      case IntegerType =>
        Bytes.toBytes(row.getInt(index))
      case BooleanType =>
        Bytes.toBytes(row.getBoolean(index))
      case DateType =>
        Bytes.toBytes(new DateTime(row.getDate(index)).getMillis)
      case TimestampType =>
        Bytes.toBytes(new DateTime(row.getTimestamp(index)).getMillis)
      case BinaryType =>
        row.getAs[Array[Byte]](index)
      case _ =>
        Bytes.toBytes(row.getString(index))
    }
  }

  type HBaseValueBulkLoadSetter = (Array[Byte], Row, Array[Byte]) => (ImmutableBytesWritable, KeyValue)

  def setBulkLoadValue(dataType: (StructField, Int)): HBaseValueBulkLoadSetter = {
    val (structField, index) = dataType

    (rowKey: Array[Byte], row: Row, family: Array[Byte]) => {
      val value = getValueFromRow(row, structField.dataType, index)
      (new ImmutableBytesWritable(rowKey), new KeyValue(rowKey, family, Bytes.toBytes(structField.name), value))
    }
  }

}



