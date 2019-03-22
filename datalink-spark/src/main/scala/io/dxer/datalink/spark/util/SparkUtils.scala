package io.dxer.datalink.spark.util

import java.sql.{Date, Timestamp}

import io.dxer.datalink.spark.output.ConsolePrinter
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row}
import org.joda.time.DateTime

object SparkUtils {


  def getFromRow(row: Row, dataType: DataType, index: Int): Any = {
    dataType match {
      case StringType =>
        if (row.isNullAt(index)) "" else row.getString(index)
      case LongType =>
        row.getLong(index)
      case FloatType =>
        row.getFloat(index)
      case DoubleType =>
        row.getDouble(index)
      case IntegerType =>
        row.getInt(index)
      case BooleanType =>
        row.getBoolean(index)
      case DateType =>
        new DateTime(row.getDate(index)).getMillis
      case TimestampType =>
        new DateTime(row.getTimestamp(index)).getMillis
      case BinaryType =>
        row.getAs[Array[Byte]](index)
      case _ =>
        row.getString(index)
    }
  }

  def getFromRow(row: Row, dataType: DataType, fieldName: String): Any = {
    dataType match {
      case StringType =>
        if (row.getAs[String](fieldName) == null) "" else row.getAs[String](fieldName)
      case LongType =>
        row.getAs[Long](fieldName)
      case FloatType =>
        row.getAs[Float](fieldName)
      case DoubleType =>
        row.getAs[Double](fieldName)
      case IntegerType =>
        row.getAs[Int](fieldName)
      case BooleanType =>
        row.getAs[Boolean](fieldName)
      case DateType =>
        new DateTime(row.getAs[Date](fieldName)).getMillis
      case TimestampType =>
        new DateTime(row.getAs[Timestamp](fieldName)).getMillis
      case BinaryType =>
        row.getAs[Array[Byte]](fieldName)
      case _ =>
        row.getAs[String](fieldName)
    }
  }


  def toResult(df: DataFrame): Unit = {
    val fieldNames = df.schema.map(f => f.name).toList

    val result = if (df.collect().size > 1000) {
      df.collect().take(1000)
    } else {
      df.collect()
    }

    val data = result.map(row => {
      df.schema.map(f => {
        SparkUtils.getFromRow(row, f.dataType, f.name)
      }).toList
    }).toList

    ConsolePrinter(fieldNames, true, System.out).printRows(data)
  }


  def toResult(fieldNames: List[String], data: List[List[_ <: Any]], headerOutput: Boolean = true): Unit = {
    ConsolePrinter(fieldNames, true, System.out).printRows(data)
  }

}
