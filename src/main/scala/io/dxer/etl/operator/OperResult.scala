package io.dxer.etl.operator

import java.text.DecimalFormat

class OperResult(var message: String, var result: String, var start: Long, var end: Long) {

  def this() {
    this(null, null, 0, 0)
  }

  def this(message: String) {
    this(message, null, 0, 0)
  }

  def getCost(): Long = {
    end - start
  }

  def print(): String = {
    val df = new DecimalFormat("0.00");
    val content =
      s"""
         | ${result}
         | ${message}
         | Time taken: ${df.format(getCost() / 1000)} seconds
      """.stripMargin
    content
  }

  override def toString(): String = {
    return s"${message}, cost: ${end - start}"
  }
}
