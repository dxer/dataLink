package io.dxer.datalink.spark.output

trait OutputPrinter {

  def printRows(rows: List[List[_ <: Any]]): Unit

  def finish(): Unit

}
