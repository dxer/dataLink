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
        setResultMsg(s"${getClass.getSimpleName} error, ${e.getMessage}")
      }
    }
    operResult.end = System.currentTimeMillis()
    operResult
  }

  def exec(): Unit

  def setResultMsg(msg: String): Unit = {
    operResult.message = msg
  }
}
