package io.dxer.datalink.spark

import com.google.common.base.Strings
import io.dxer.datalink.sql.{ConnectionManager, DataLinkSession}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.parser.ParserInterface

class DataLinkSparkSession(val sparkSession: SparkSession,
                           connectionManager: ConnectionManager
                          ) extends DataLinkSession(connectionManager) {

  def this(sparkSession: SparkSession) {
    this(sparkSession, ConnectionManager.apply)
  }

  implicit def reflector(ref: AnyRef) = new {
    def getFieldObject(name: String) = ref.getClass.getDeclaredField(name).get(ref)

    def getFields() = ref.getClass.getDeclaredFields
  }

  def sqlVerify(sql: String): Boolean = {
    !Strings.isNullOrEmpty(sql) &&
      sparkSession
        .sessionState
        .catalog
        .getFieldObject("org$apache$spark$sql$catalyst$catalog$SessionCatalog$$parser")
        .asInstanceOf[ParserInterface]
        .parsePlan(sql) != null
  }

  /* check table exists */
  def checkTableExists(sparkSession: SparkSession, tableName: String): Boolean = {
    !Strings.isNullOrEmpty(tableName) && sparkSession.catalog.tableExists(tableName)
  }

}
