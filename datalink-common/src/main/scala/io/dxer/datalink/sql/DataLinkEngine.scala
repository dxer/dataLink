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

  def getStatements(sqlText: String): List[Statement] = {
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
      return List[Statement]()
    }

    parser.buildAst(sb.toString)
  }

  def execute(sqlText: String): Unit = {
    val statements = getStatements(sqlText)
    statements.foreach(st => {
      if (!st.isInstanceOf[OriginSQL] ||
        (st.isInstanceOf[OriginSQL] && originalSqlVerify(st.asInstanceOf[OriginSQL].sql))) {
        executeStatement(st)
      } else {
        throw new DataLinkException(s"${st.asInstanceOf[OriginSQL].sql} is not supported")
      }
    })
  }

  def originalSqlVerify(sqlText: String): Boolean = true

  def executeStatement(statement: Statement): Unit

  def executeCommand(command: RunnableCommand): Unit = {
    runner.tryExecute(command, dataLinkSession)
  }

  protected def executeConnectionStatement(statement: Statement): Unit = {
    statement match {
      case st: CreateConnection =>
        executeCommand(new CreateConnectionCommand(st))

      case st: DropConnection =>
        executeCommand(new DropConnectionCommand(st))

      case st: ShowConnection =>
        executeCommand(new ShowConnectionCommand(st))

      case st: ListConnections =>
        executeCommand(new ListConnectionsCommand(st))
    }
  }

}
