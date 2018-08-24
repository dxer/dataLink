package io.dxer.etl.operator.input

import io.dxer.etl.sql.tree.Load
import org.apache.spark.sql.DataFrame

abstract class InputFormat {

  def run(load:Load): DataFrame

}
