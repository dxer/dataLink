package io.dxer.etl.operator

import com.google.common.base.Strings
import io.dxer.etl.ConnectionManager
import io.dxer.etl.sql.tree.Connection

import scala.collection.JavaConversions._


/**
  *
  * @param connect
  */
class ConnectOperator(connect: Connection) extends Operator {

  override def exec(): Unit = {
    connect.getOperType match {
      case Connection.OperType.CREATE =>
        createConnect(connect)

      case Connection.OperType.DROP =>
        dropConnect(connect)

      case Connection.OperType.SHOW =>
        showConnect(connect)

      case Connection.OperType.SHOW_CONNECTIONS =>
        showAllConnect()
    }

  }

  private def createConnect(connect: Connection): Unit = {
    if (ConnectionManager.getConnectByName(connect.getName) != null) {
      setResultMsg(s"FAILED, Connection ${connect.getName} already exists")
    } else {
      ConnectionManager.addConnect(connect)
      setResultMsg("OK")
    }
  }

  private def dropConnect(connect: Connection): Unit = {
    ConnectionManager.removeConnect(connect.getName)
    setResultMsg("OK")
  }

  private def showConnect(connect: Connection): Unit = {
    val curConnect = ConnectionManager.getConnectByName(connect.getName)
    if (curConnect == null) {
      setResultMsg(s"FAILED, Connection not found ${curConnect.name}")
      return
    }
    val props = curConnect.properties

    val sb = new StringBuilder()
    val iter = props.entrySet().iterator()
    while (iter.hasNext) {
      val entry = iter.next()
      if (!Strings.isNullOrEmpty(sb.toString())) sb.append(",\n")
      sb.append(entry.getKey).append("=").append(entry.getValue)
    }

    val result =
      s"""
         | CREATE ${curConnect.connectionType} CONNECT ${curConnect.name} (
         | ${sb.toString}
         | );""".stripMargin

    operResult.content = result
    operResult.data = curConnect
    setResultMsg("OK")
  }

  private def showAllConnect(): Unit = {
    val connections = ConnectionManager.getAllConections()

    val sb = new StringBuilder()
    sb.append("Type").append("\t").append("Name").append("\t").append("Temporary").append("\n")
    connections.foreach(c => {
      sb.append(c.connectionType).append("\t").append(c.name).append("\t").append(c.isTemp).append("\n")
    })

    operResult.content = sb.toString
    operResult.data = connections

    setResultMsg("OK")
  }
}