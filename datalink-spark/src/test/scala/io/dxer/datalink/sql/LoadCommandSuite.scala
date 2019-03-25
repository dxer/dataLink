package io.dxer.datalink.sql

import java.util.Properties

import io.dxer.datalink.grok.Grok
import io.dxer.datalink.spark.Constants
import io.dxer.datalink.spark.sql.execution.SparkLoadTableCommand
import org.scalatest.FunSuite

class LoadCommandSuite extends FunSuite {

  class LoadCommandTest extends SparkLoadTableCommand(null) {
    override def run(dataLinkSession: DataLinkSession): Unit = {}
  }

  test("addGrokPattern") {
    val grok = new Grok()

    val properties = new Properties
    properties.setProperty("grok.add.pattern.test", ".*")
    properties.setProperty("grok.add.pattern.test1", "\\d+")

    new LoadCommandTest().addGrokPattern(grok, properties)

    assert(grok.getPattern("test").equals(".*"))
    assert(grok.getPattern("test1").equals("\\d+"))

    val str = "zhangsan;12"
    grok.compile("%{test:a};%{test1:b}")

    val result = grok.`match`(str)
    assert(result.capture.get("a").equals("zhangsan"))
    assert(result.capture.get("b").equals("12"))
  }

  test("prop") {
    val props = new Properties()
    props.setProperty("grok.compile.pattern", "%{test:a};%{test1:b}")
    props.setProperty("test", "111")
    println(props.containsKey(Constants.GROK_COMPILE_PATTERN))
    println(props.containsKey("test"))
  }

}
