package io.dxer.datalink.sql.execution

import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.parser.{InsertInto, LoadTable, OriginSQL}

trait RunnableCommand {
  def run(dataLinkSession: DataLinkSession): Unit
}

class CommandRunner {
  def tryExecute(command: RunnableCommand, dataLinkSession: DataLinkSession): Unit = {
    val start = System.currentTimeMillis()
    command.run(dataLinkSession)
    val cost = System.currentTimeMillis() - start
  }
}

/**
  * LoadTable
  *
  * @param loadTable
  */
class LoadTableCommand(loadTable: LoadTable) extends RunnableCommand {
  override def run(dataLinkSession: DataLinkSession): Unit = {
    loadTable.isIntoTable match {
      case true => loadIntoTable(dataLinkSession, loadTable)
      case _ => loadAsTable(dataLinkSession, loadTable)
    }
  }

  protected def loadAsTable(dataLinkSession: DataLinkSession, loadTable: LoadTable): Unit = {
    println("load as table")
  }

  protected def loadIntoTable(dataLinkSession: DataLinkSession, loadTable: LoadTable): Unit = {
    println("load into table")
  }
}

/**
  * InsertInto
  *
  * @param insertInto
  */
class InsertIntoCommand(insertInto: InsertInto) extends RunnableCommand {
  override def run(dataLinkSession: DataLinkSession): Unit = {
    println("insert into")
  }
}

/**
  * OriginSQL
  *
  * @param originSQL
  */
class OriginSQLCommand(originSQL: OriginSQL) extends RunnableCommand {
  override def run(dataLinkSession: DataLinkSession): Unit = {
    println("origin sql")
  }
}