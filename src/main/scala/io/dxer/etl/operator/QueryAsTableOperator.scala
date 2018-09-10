package io.dxer.etl.operator

import io.dxer.etl.sql.tree.QueryAsTable
import org.apache.spark.sql.SparkSession

class QueryAsTableOperator(sparkSession: SparkSession, queryAsTable: QueryAsTable) extends Operator {


  override def exec(): Unit = {
    val df = sparkSession.sql(queryAsTable.getQuery)
    df.createOrReplaceTempView(queryAsTable.getTableName)
    df.printSchema()
    setResultMsg("OK")
  }
}
