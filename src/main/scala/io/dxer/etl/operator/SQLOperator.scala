package io.dxer.etl.operator

import org.apache.spark.sql.SparkSession

/**
  * sparksql执行操作
  *
  * @param sparkSession
  * @param sqlText
  */
class SQLOperator(sparkSession: SparkSession, sqlText: String) extends Operator {

  override def exec(): Unit = {
    val df = sparkSession.sql(sqlText)
    df.show(10)
    setResultMsg("OK")
  }
}
