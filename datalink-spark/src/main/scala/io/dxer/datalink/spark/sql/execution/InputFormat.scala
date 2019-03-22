package io.dxer.datalink.spark.sql.execution

import io.dxer.datalink.sql.parser.LoadTable
import org.apache.spark.sql.DataFrame

trait InputFormat {

  def run(loadTable: LoadTable): DataFrame

}
