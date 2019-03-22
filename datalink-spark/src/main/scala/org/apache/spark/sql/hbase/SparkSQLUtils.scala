package org.apache.spark.sql.hbase

import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.{DataFrame, Dataset}

object SparkSQLUtils {

  def execute(logicalPlan: LogicalPlan): DataFrame = {
    Dataset.ofRows(null, logicalPlan)
  }

}
