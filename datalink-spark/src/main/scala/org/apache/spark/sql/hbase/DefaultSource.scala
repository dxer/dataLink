
package org.apache.spark.sql.hbase

import com.google.common.base.Strings
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql._
import org.apache.spark.sql.hbase.spark._
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types.StructType

object spark {

  implicit def toSparkSqlContextFunctions(spark: SparkSession): SparkSqlContextFunctions = {
    new SparkSqlContextFunctions(spark)
  }

  implicit def toDataFrameFunctions(data: DataFrame): DataFrameFunctions = {
    new DataFrameFunctions(data)
  }

}

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
    val tableName = params.getOrElse(Constants.HBASE_TABLE_NAME,
      sys.error("You must specify parameter hbase.table.name..."))
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

  // hbase table name
  def getInputTableName = params.getOrElse(Constants.HBASE_TABLE_NAME,
    sys.error("You must specify parameter hbase.table.name"))

  override def buildScan(): RDD[Row] = {
    require(!Strings.isNullOrEmpty(params.getOrElse(Constants.HBASE_TABLE_SCHEMA, "")),
      "You must specify parameter hbase.table.schema")
    sqlContext.sparkSession.hbaseTableAsDataFrame(getInputTableName, params).rdd
  }

  override def schema: StructType = {
    sqlContext.sparkSession.hbaseTableAsDataFrame(getInputTableName, params).schema
  }
}