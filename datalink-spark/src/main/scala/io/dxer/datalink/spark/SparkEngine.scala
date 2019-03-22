package io.dxer.datalink.spark

import io.dxer.datalink.spark.sql.execution.{InsertIntoCommand, LoadAsTableCommand, LoadIntoTableCommand, SparkSQLCommand}
import io.dxer.datalink.sql.DataLinkEngine
import io.dxer.datalink.sql.parser._

class SparkEngine(dataLinkSparkSession: DataLinkSparkSession) extends DataLinkEngine(dataLinkSparkSession) {

  override def originalSqlVerify(sqlText: String): Boolean = {
    dataLinkSparkSession.sqlVerify(sqlText)
  }

  override def executeStatement(statement: Statement): Unit = {
    statement match {
      case st: ConnectionStatement =>
        executeConnectionStatement(st)

      case st: LoadAsTable =>
        executeCommand(new LoadAsTableCommand(st))

      case st: LoadIntoTable =>
        executeCommand(new LoadIntoTableCommand(st))

      case st: InsertInto =>
        executeCommand(new InsertIntoCommand(st))

      case st: OriginSQL =>
        executeCommand(new SparkSQLCommand(st))

      case _ => throw new ParseException("Not Support")
    }
  }


}
