package io.dxer.datalink.sql.parser

import org.antlr.v4.runtime.ParserRuleContext
import org.scalatest.FunSuite

class SqlParserSuite extends FunSuite {

  private val parser = new SqlParser()


  test("buildAst") {
    val sql = "load data csv.`/home/hadoop/test.txt` as test;\n select count(1) from test;"

    val statements = parser.buildAst(sql)
    assert(statements.size === 2)
  }


  test("create connection") {
    val sql = "create connection JDBC.oracle_db (driver='oracle.jdbc.driver.OracleDriver', url='jdbc:oracle:thin:@127.0.0.1:1521:dcdb', user='test', password='test');"
    val createConnection = parser.buildSingleAst(sql).asInstanceOf[CreateConnection]

    assert(createConnection != null)
    assert(createConnection.connectionType.equals("JDBC"))
    assert(createConnection.name.equals("oracle_db"))
    assert(createConnection.properties.size() === 4)
    assert(createConnection.properties.getProperty("driver").equals("oracle.jdbc.driver.OracleDriver"))
  }

  test("show create connection") {
    val sql = "show create connection jdbc.oracle_db;"
    val showConnection = parser.buildSingleAst(sql).asInstanceOf[ShowCreateConnection]
    assert(showConnection.connectionType.equals("JDBC"))
    assert(showConnection.name.equals("oracle_db"))
  }

  test("show connections") {
    var sql = "show connections;"
    var conns = parser.buildSingleAst(sql).asInstanceOf[ShowConnections]
    assert(conns != null)

    sql = "show connections in JDBC like 'test*';"
    conns = parser.buildSingleAst(sql).asInstanceOf[ShowConnections]
    assert(conns != null)
    assert(conns.connectionType.equals("JDBC"))
    assert(conns.pattern.equals("test*"))
  }


  test("load as table") {
    val sql = "load data oracle_db.`mk.t_province_code` as ttt;"
    val table: LoadTable = parser.buildSingleAst(sql).asInstanceOf[LoadTable]
    assert(table != null)
    assert(table.format.equals("oracle_db"))
    assert(table.path.equals("mk.t_province_code"))
  }

  test("exec func") {
    val sql = "exec ftp_upload('/home/hadoop/test.txt', '/test/');"
    val execFunc = parser.buildSingleAst(sql).asInstanceOf[ExecFunc]

    assert(execFunc != null)
    assert(execFunc.func.equals("ftp_upload"))
    assert(execFunc.params.size === 2)
    execFunc.params.foreach(println)
  }

  test("select") {
    val sql = "select * from zhuangtai limit 10;"
    val v = parser.buildSingleAst(sql).asInstanceOf[OriginSQL]
    println(v.sql)
  }

  test("insert into from table") {
    val sql = "insert overwrite parquet.`/tmp/test` from test;"
    val v = parser.buildSingleAst(sql).asInstanceOf[InsertInto]
    assert(v != null)
    assert(v.isInstanceOf[InsertInto])
    assert(v.tableName.equals("test"))
  }

  test("insert into from sql") {
    val sql = "insert overwrite parquet.`/tmp/test` from select * from test;"
    val v = parser.buildSingleAst(sql).asInstanceOf[InsertInto]
    assert(v != null)
    assert(v.isInstanceOf[InsertInto])
    println(v.query)
  }

  test("Spark sql cache") {
    val sql = "show tables;"
    val v = parser.buildSingleAst(sql)
    println(v)
  }

  test("txt_grok_test") {
    val sql = "load data txt.`/data/test1.txt` \noptions(grok.compile.pattern='%{test:a};%{test1:b}', grok.add.pattern.test='.*', grok.add.pattern.test1='\\d+') as test;"
    println(sql)
    val table = parser.buildSingleAst(sql).asInstanceOf[LoadTable]
    println(table.properties)
  }

  test("get sql") {
    val sql = "insert overwrite parquet.`/tmp/test` from select * from test;"
    val v = parser.buildSingleAst(sql).asInstanceOf[ParserRuleContext]
    println(ParserUtils.getOriginalText(v))
  }

}
