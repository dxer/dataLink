package io.dxer.etl.operator.output

import io.dxer.etl.sql.tree.InsertInto
import org.apache.spark.sql.DataFrame

abstract class OutputFormat {

  def run(insertInto: InsertInto): DataFrame

}
