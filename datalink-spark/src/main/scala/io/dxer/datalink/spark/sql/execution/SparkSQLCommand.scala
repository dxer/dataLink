package io.dxer.datalink.spark.sql.execution

import io.dxer.datalink.spark.DataLinkSparkSession
import io.dxer.datalink.spark.util.SparkUtils
import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.execution.OriginSQLCommand
import io.dxer.datalink.sql.parser.OriginSQL

class SparkSQLCommand(originSQL: OriginSQL) extends OriginSQLCommand(originSQL) {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    val sparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession].sparkSession
    val df = sparkSession.sql(originSQL.sql)
    SparkUtils.toResult(df)
  }
}
