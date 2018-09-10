package io.dxer.etl.operator

class OperResult(var msg: String, var data: Any, var content: String) {

  def this() {
    this(null, null, null)
  }

}
