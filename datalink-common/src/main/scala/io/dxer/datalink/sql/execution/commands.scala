package io.dxer.datalink.sql.execution

import io.dxer.datalink.sql.DataLinkSession

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
