package org.apache.spark.sql.execution.hbase

import com.google.common.base.Strings
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types.{StructType, _}
import org.apache.spark.sql.{DataFrame, Row, SQLContext, SaveMode}

/**
  *
  */
class DefaultSource extends CreatableRelationProvider with RelationProvider with DataSourceRegister {

  override def createRelation(sqlContext: SQLContext, params: Map[String, String]): BaseRelation =
    HBaseRelation(params)(sqlContext)

  override def shortName(): String = "hbase"

  override def createRelation(sqlContext: SQLContext, mode: SaveMode,
                              parameters: Map[String, String], data: DataFrame): BaseRelation = {
    val relation = InsertHBaseRelation(data, parameters)(sqlContext)
    relation.insert(data, false)
    relation
  }
}


/**
  *
  * @param dataFrame
  * @param params
  * @param sqlContext
  */
case class InsertHBaseRelation(dataFrame: DataFrame,
                               params: Map[String, String])(@transient val sqlContext: SQLContext)
  extends BaseRelation with InsertableRelation with Logging {

  override def insert(data: DataFrame, overwrite: Boolean): Unit = {
    val tableName = params.getOrElse("hbase.table.name", sys.error("You must specify parameter hbase.table.name..."))

    data.insertIntoHBase(tableName, params)
  }

  override def schema: StructType = dataFrame.schema

}

/**
  *
  *
  * @param params
  * @param sqlContext
  */
case class HBaseRelation(params: Map[String, String])(@transient val sqlContext: SQLContext)
  extends BaseRelation with TableScan with Logging {

  def getInputTableName = params.getOrElse("hbase.table.name", sys.error("You must specify parameter hbase.table.name..."))

  override def buildScan(): RDD[Row] = {
    require(!Strings.isNullOrEmpty(params.getOrElse("hbase.table.schema", "")), "You must specify parameter hbase.table.schema...")
    sqlContext.sparkSession.hbaseTableAsDataFrame(getInputTableName, params).rdd
  }

  override def schema: StructType = {
    sqlContext.sparkSession.hbaseTableAsDataFrame(getInputTableName, params).schema
  }
}