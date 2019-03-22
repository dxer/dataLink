package io.dxer.datalink

import org.scalatest.FunSuite

import scala.io.Source


class Test extends FunSuite {

  test("test") {
    val sql = "show connections;"
  }

  test("file") {
    val filepath = "d:/22.txt"
    val value = Source.fromFile(filepath, "UTF-8").getLines().mkString("\n")
    println(value)
  }


  test("match") {
    val t = "1"
    t match {
      case "1" | "2" | "3" => println("ok")
      case _ => println("error")
    }
  }

  test("array mkstring"){
    val array = Array("1,2,3")
    val str = array.mkString("[", ", ", "]")
    println(str)
  }

}
