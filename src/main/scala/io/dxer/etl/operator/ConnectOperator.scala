package io.dxer.etl.operator

import io.dxer.etl.ConnectionManager
import io.dxer.etl.sql.tree.Connection

class ConnectOperator(connect: Connection) extends Operator {

  override def exec(): Unit = {
    connect.getOperType match {
      case Connection.OperType.CREATE => createConnect(connect)
      case Connection.OperType.DROP => dropConnect(connect)
      case Connection.OperType.SHOW => val curConnect = showConnect(connect)
    }

  }

  private def createConnect(connect: Connection): Unit = {
    if (ConnectionManager.getConnectByName(connect.getName) != null) {
      setResultMsg(s"${connect.getName} connect exists")
    } else {
      ConnectionManager.addConnect(connect)
      setResultMsg("create connect success")
    }
  }

  private def dropConnect(connect: Connection): Unit = {
    ConnectionManager.removeConnect(connect.getName)
  }

  private def showConnect(connect: Connection): Connection = {
    ConnectionManager.getConnectByName(connect.getName)
  }
}