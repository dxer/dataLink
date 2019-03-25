package io.dxer.datalink.sql

import org.scalatest.FunSuite

class DataLinkEngineSuite extends FunSuite {

  class TestDataLinkEngine extends DataLinkEngine(null) {

  }

  test("getPreparedStatements") {
    val sql = "show connections;"

    val statements = new TestDataLinkEngine().getPreparedStatements(sql)
    assert(statements != null)
    assert(statements.size == 1)
  }

}
