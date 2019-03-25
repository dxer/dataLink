package io.dxer.datalink.spark

import io.dxer.datalink.sql.DataLinkEngine

class SparkEngine(dataLinkSparkSession: DataLinkSparkSession) extends DataLinkEngine(dataLinkSparkSession) {

  /**
    * 对spark原生支持的sql进行验证
    *
    * @param sqlText
    * @return
    */
  override def originalSqlVerify(sqlText: String): Boolean = {
    dataLinkSparkSession.sqlVerify(sqlText)
  }

}
