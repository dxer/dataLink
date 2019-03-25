package io.dxer.datalink.sql

import io.dxer.datalink.sql.parser.{CreateConnection, ShowConnections, SqlParser}
import org.scalatest.FunSuite

class ConnectionSuite extends FunSuite {

  private val parser = new SqlParser()


  test("create connection") {
    val manager = ConnectionManager.apply
    val sql = "create connection JDBC.oracle_db (driver='oracle.jdbc.driver.OracleDriver', url='jdbc:oracle:thin:@127.0.0.1:1521:dcdb', user='test', password='test');"

    val statement = parser.getStatement(sql)
    val createConnection = statement.asInstanceOf[CreateConnection]
    manager.createConnection(createConnection)

    assert(manager.exist(createConnection.name))
    assert(manager.getConnectionType(createConnection.name).equals("JDBC"))
    //    assert(manager.getJDBCConnection("oracle_db").isInstanceOf[Connection])
    assert(manager.getConnectionDescription("oracle_db") != null)
    assert(manager.listConnections("JDBC", "oracle_db").size === 1)
  }

  test("test") {
    val sql = "show connections;"
    parser.getStatement(sql).asInstanceOf[ShowConnections]
  }

  test("show connections in test") {
    val sql = "show connections in test;"
    val connections = parser.getStatement(sql).asInstanceOf[ShowConnections]
    assert(connections != null)
    assert(connections.connectionType.equals("test"))
  }

  test("show connections in test like 'test'") {
    val sql = "show connections in test like 'test';"
    val connections = parser.getStatement(sql).asInstanceOf[ShowConnections]
    assert(connections != null)
    assert(connections.connectionType.equals("test"))
    println(connections.pattern.equals("test"))
  }

}
