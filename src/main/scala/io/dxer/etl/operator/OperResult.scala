package io.dxer.etl.operator

class OperResult(var message: String, var start: Long, var end: Long) {

  def this() {
    this(null, 0, 0)
  }

  def this(message: String) {
    this(message, 0, 0)
  }

  def getCost(): Long = {
    end - start
  }

  override def toString(): String = {
    return s"${message}, cost: ${end - start}"
  }
}
