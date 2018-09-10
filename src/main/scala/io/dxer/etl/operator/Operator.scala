package io.dxer.etl.operator

abstract class Operator {

  val operResult = new OperResult()

  def tryExec(): OperResult = {
    operResult.start = System.currentTimeMillis()
    try {
      exec()
    } catch {
      case e: Exception => {
        e.printStackTrace()
        setResultMsg("Error", s"${getClass.getSimpleName} error, ${e.getMessage}")
      }
    }
    operResult.end = System.currentTimeMillis()
    operResult
  }

  def exec(): Unit

  def setResult(result: String): Unit = {
    operResult.result = result
  }

  def setResultMsg(result: String, msg: String = null): Unit = {
    if (result != null)
      operResult.result = result
    if (msg != null)
      operResult.message = msg
  }
}
