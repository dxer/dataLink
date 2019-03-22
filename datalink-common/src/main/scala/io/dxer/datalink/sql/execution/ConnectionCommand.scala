package io.dxer.datalink.sql.execution

import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.parser.{CreateConnection, DropConnection, ListConnections, ShowConnection}


class CreateConnectionCommand(createConnection: CreateConnection) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    dataLinkSession.connectionManager.createConnection(createConnection)
  }
}

class DropConnectionCommand(dropConnection: DropConnection) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    dataLinkSession.connectionManager.remove(dropConnection.name)
  }
}

class ShowConnectionCommand(showConnection: ShowConnection) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    dataLinkSession.connectionManager.getConnectionDescription(showConnection.name)
  }
}

class ListConnectionsCommand(listConnections: ListConnections) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    val results = dataLinkSession
      .connectionManager
      .listConnections(listConnections.connectionType, listConnections.pattern)

    results.foreach(println)
  }
}

