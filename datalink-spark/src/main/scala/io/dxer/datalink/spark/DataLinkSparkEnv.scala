package io.dxer.datalink.spark

import java.util.concurrent.ConcurrentHashMap

import io.dxer.datalink.DataLinkEnv
import org.apache.spark.sql.SparkSession

class DataLinkSparkEnv extends DataLinkEnv {

  def init(sparkSession: SparkSession): Unit = {

  }

}

object DataLinkSparkEnv {
  val dataLinkEnvMap = new ConcurrentHashMap[SparkSession, DataLinkSparkEnv]

  def apply(sparkSession: SparkSession): DataLinkSparkEnv = {
    var dataLinkEnv = dataLinkEnvMap.get(sparkSession)
    if (dataLinkEnv == null) {
      dataLinkEnv = new DataLinkSparkEnv
      dataLinkEnv.init(sparkSession)
      dataLinkEnvMap.put(sparkSession, dataLinkEnv)
    }
    dataLinkEnv
  }

}
