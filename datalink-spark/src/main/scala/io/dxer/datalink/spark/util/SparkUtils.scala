package io.dxer.datalink.spark.util

import java.sql.{Date, Timestamp}

import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.joda.time.DateTime

object SparkUtils {


  def getFromRow(row: Row, dataType: DataType, index: Int): Any = {
    dataType match {
      case StringType =>
        if (row.isNullAt(index) == null) "" else row.getString(index)
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


}
