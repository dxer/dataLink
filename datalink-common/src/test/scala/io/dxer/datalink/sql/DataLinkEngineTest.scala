package io.dxer.datalink.sql

import io.dxer.datalink.sql.parser.Statement
import org.scalatest.FunSuite

class DataLinkEngineTest extends FunSuite {

  class DataLinkEngineExt extends DataLinkEngine(null){
    override def executeStatement(statement: Statement): Unit = ???
  }

  test("test") {
    val sql = "show connections;"

    val statements = new DataLinkEngineExt().getStatements(sql)
    println(statements.length)
    statements.foreach(println)
  }

}
