package io.dxer.datalink

import io.dxer.datalink.sql.ConnectionManager
import io.dxer.datalink.sql.parser.{CreateConnection, ListConnections, ShowConnection, SqlParser}
import org.scalatest.FunSuite

class ConnectionSuite extends FunSuite {

  private val parser = new SqlParser()


  test("create connection") {
    val manager = ConnectionManager.apply
    val sql = "create connection JDBC.oracle_db (driver='oracle.jdbc.driver.OracleDriver', url='jdbc:oracle:thin:@127.0.0.1:1521:dcdb', user='test', password='test');"

    val createConnection = parser.buildSingleAst(sql).asInstanceOf[CreateConnection]
    manager.createConnection(createConnection)

    assert(manager.exist(createConnection.name))
    assert(manager.getConnectionType(createConnection.name).equals("JDBC"))
//    assert(manager.getJDBCConnection("oracle_db").isInstanceOf[Connection])
    assert(manager.getConnectionDescription("oracle_db") != null)
    assert(manager.listConnections("JDBC", "oracle_db").size === 1)
  }

  test("test"){
    val sql="show connections;"
    parser.buildSingleAst(sql).asInstanceOf[ListConnections]
  }


}
