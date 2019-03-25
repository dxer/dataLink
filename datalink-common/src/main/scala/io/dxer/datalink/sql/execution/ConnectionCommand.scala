package io.dxer.datalink.sql.execution

import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.parser.{CreateConnection, DropConnection, ShowConnections, ShowCreateConnection}


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

class ShowCreateConnectionCommand(showConnection: ShowCreateConnection) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    dataLinkSession.connectionManager.getConnectionDescription(showConnection.name)
  }
}

class ShowConnectionsCommand(showConnections: ShowConnections) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    val results = dataLinkSession
      .connectionManager
      .listConnections(showConnections.connectionType, showConnections.pattern)

    results.foreach(println)
  }
}

