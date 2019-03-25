package io.dxer.datalink.spark

import io.dxer.datalink.sql.DataLinkEngine

class SparkEngine(dataLinkSparkSession: DataLinkSparkSession) extends DataLinkEngine(dataLinkSparkSession) {

  override def originalSqlVerify(sqlText: String): Boolean = {
    dataLinkSparkSession.sqlVerify(sqlText)
  }

}
