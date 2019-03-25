package io.dxer.datalink.spark

import io.dxer.datalink.spark.sql.execution.{InsertIntoCommand, LoadAsTableCommand, LoadIntoTableCommand, SparkSQLCommand}
import io.dxer.datalink.sql.DataLinkEngine
import io.dxer.datalink.sql.parser._

class SparkEngine(dataLinkSparkSession: DataLinkSparkSession) extends DataLinkEngine(dataLinkSparkSession) {

  override def originalSqlVerify(sqlText: String): Boolean = {
    dataLinkSparkSession.sqlVerify(sqlText)
  }

  override def executeStatement(statement: PreparedStatement): Unit = {
    println(s"==> ${statement.sql}")
    statement.statement match {
      case st: ConnectionStatement =>
        executeConnectionStatement(st)

      case st: LoadTable =>
        executeCommand(new LoadAsTableCommand(st))

      case st: InsertInto =>
        executeCommand(new InsertIntoCommand(st))

      case st: OriginSQL =>
        executeCommand(new SparkSQLCommand(st))

      case _ => throw new ParseException("Not Support")
    }
  }


}
