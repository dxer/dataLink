package io.dxer.datalink.spark.sql.execution

import com.google.common.base.Strings
import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.spark.{Constants, DataLinkSparkSession}
import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.execution.InsertIntoCommand
import io.dxer.datalink.sql.parser.InsertInto
import io.dxer.datalink.util.Utils
import org.apache.spark.SparkException
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.hbase.spark._

import scala.collection.JavaConversions._

class SparkInsertIntoCommand(insertInto: InsertInto) extends InsertIntoCommand(insertInto) {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    assert(!Strings.isNullOrEmpty(insertInto.query) || !Strings.isNullOrEmpty(insertInto.tableName), "")

    val dataLinkSparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession]
    val sparkSession = dataLinkSparkSession.sparkSession

    if (!Strings.isNullOrEmpty(insertInto.tableName) ||
      (!Strings.isNullOrEmpty(insertInto.query) && dataLinkSparkSession.sqlVerify(insertInto.query))) {
    } else {
      throw new SparkException(s"table or query is not null")
    }

    val df = insertInto.query match {
      case _ if !Strings.isNullOrEmpty(insertInto.query) =>
        sparkSession.sql(insertInto.query)

      case _ if dataLinkSparkSession.checkTableExists(sparkSession, insertInto.tableName) =>
        sparkSession.table(insertInto.tableName)

      case _ => throw new SparkException(s"${insertInto.tableName} is not exist")
    }

    val saveMode = if (insertInto.isOverWrite) SaveMode.Overwrite else SaveMode.Append

    val write = if (saveMode != null) { // 设置savemode
      df.write.mode(saveMode)
    } else {
      df.write
    }

    val path = insertInto.path
    val format = insertInto.format

    format.toLowerCase match {
      case Constants.HIVE =>
        write.saveAsTable(path)

      case Constants.CSV | Constants.TSV =>
        write.options(Utils.convertPropToMap(insertInto.properties)).csv(path)

      case Constants.PARQUET | Constants.AVRO | Constants.JSON =>
        write.format(format).save(path)

      case Constants.HBASE =>
        df.insertIntoHBase(insertInto.path, insertInto.properties.toMap)

      case Constants.JDBC =>
      //        write.jdbc()
      case _ => throw new DataLinkException(s"InsertInto Not support format: ${format}")
    }

  }
}
