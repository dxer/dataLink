package io.dxer.etl

import org.apache.spark.sql.SparkSession

object SparkSessionHolder {

  private var _sparkSession: SparkSession = null

  def build(): SparkSession = {
    _sparkSession = SparkSession.builder.master("local[*]").appName("ETLApp").getOrCreate()
    _sparkSession
  }

  def sparkSession: SparkSession = {
    if (_sparkSession == null) {
      build()
    } else _sparkSession
  }


}
