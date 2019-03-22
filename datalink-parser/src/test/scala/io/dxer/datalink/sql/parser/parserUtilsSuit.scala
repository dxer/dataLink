package io.dxer.datalink.sql.parser

import org.scalatest.FunSuite

class parserUtilsSuit extends FunSuite {

  test("convert") {
    assert(ParserUtils.convert("1")==1)
    assert(ParserUtils.convert("1.1")==1.1)
    assert(ParserUtils.convert("test").equals("test"))
    assert(ParserUtils.convert("'test'").equals("test"))
    assert(ParserUtils.convert("\"test\"").equals("test"))
    assert(ParserUtils.convert("true").isInstanceOf[Boolean])
    assert(ParserUtils.convert("false").isInstanceOf[Boolean])
  }

}
