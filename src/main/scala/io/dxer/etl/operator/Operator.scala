package io.dxer.etl.operator

abstract class Operator {

  val operResult = new OperResult()

  def tryExec(): OperResult = {
    try {
      exec()
    } catch {
      case e: Exception => {
        e.printStackTrace()
        setResultMsg(s"Error, ${getClass.getSimpleName} error, ${e.getMessage}")
      }
    }
    operResult
  }

  def exec(): Unit

  def setResultMsg(result: String): Unit = operResult.msg = result

  def setData(data: Any): Unit = operResult.data = data

}
