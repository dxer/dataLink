package io.dxer.datalink.sql

import com.google.common.base.Strings
import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.sql.execution._
import io.dxer.datalink.sql.parser.{OriginSQL, _}


abstract class DataLinkEngine(dataLinkSession: DataLinkSession) {

  val parser = new SqlParser

  val runner: CommandRunner = new CommandRunner

  def connectionManager = dataLinkSession.connectionManager

  private val LINE_SPLIT = "(\\s*\\r\\n)|(\\s*\\n)"

  def getPreparedStatements(sqlText: String): List[PreparedStatement] = {
    val lines = sqlText.split(LINE_SPLIT, -1)
    val sb = new StringBuffer()
    lines.foreach(sql => {
      val sqlTrimmed = sql.trim
      //  去掉注释行
      if (!sqlTrimmed.startsWith("#") && !sqlTrimmed.startsWith("--") && !Strings.isNullOrEmpty(sqlTrimmed)) {
        sb.append(sqlTrimmed)
      }
    })

    if (Strings.isNullOrEmpty(sb.toString)) {
      return List[PreparedStatement]()
    }

    parser.buildAst(sb.toString)
  }

  def execute(sqlText: String): Unit = {
    val statements = getPreparedStatements(sqlText)
    statements.foreach(st => {
      if (!st.isInstanceOf[OriginSQL] ||
        (st.isInstanceOf[OriginSQL] && originalSqlVerify(st.asInstanceOf[OriginSQL].sql))) {
        executeStatement(st)
      } else {
        throw new DataLinkException(s"Unsupported SQL statement, ${st.asInstanceOf[OriginSQL].sql}")
      }
    })
  }

  /**
    *
    * @param sqlText
    * @return
    */
  def originalSqlVerify(sqlText: String): Boolean = true

  def executeStatement(statement: PreparedStatement): Unit = {
    println(s"==> ${statement.sql}")
    statement.statement match {
      case st: ConnectionStatement =>
        executeConnectionStatement(st)

      case st: LoadTable =>
        executeCommand(new LoadTableCommand(st))

      case st: InsertInto =>
        executeCommand(new InsertIntoCommand(st))

      case st: OriginSQL =>
        executeCommand(new OriginSQLCommand(st))

      case _ => throw new ParseException(Option(statement.sql), "Unsupported SQL statement")
    }
  }


  def executeCommand(command: RunnableCommand): Unit = {
    runner.tryExecute(command, dataLinkSession)
  }

  protected def executeConnectionStatement(statement: Statement): Unit = {
    statement match {
      case st: CreateConnection =>
        executeCommand(new CreateConnectionCommand(st))

      case st: DropConnection =>
        executeCommand(new DropConnectionCommand(st))

      case st: ShowCreateConnection =>
        executeCommand(new ShowCreateConnectionCommand(st))

      case st: ShowConnections =>
        executeCommand(new ShowConnectionsCommand(st))
    }
  }

}
