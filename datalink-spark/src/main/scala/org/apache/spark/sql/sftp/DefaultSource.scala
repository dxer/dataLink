package org.apache.spark.sql.sftp

import io.dxer.datalink.file.SFTPClient
import org.apache.spark.internal.Logging
import org.apache.spark.sql.sources.{BaseRelation, CreatableRelationProvider, DataSourceRegister, RelationProvider}
import org.apache.spark.sql.{DataFrame, SQLContext, SaveMode}


class DefaultSource extends CreatableRelationProvider with RelationProvider with DataSourceRegister with Logging {

  val SupportedFileTypes = List("csv", "json", "avro", "parquet", "txt", "orc")

  override def createRelation(sqlContext: SQLContext,
                              mode: SaveMode,
                              params: Map[String, String],
                              data: DataFrame): BaseRelation = {
    val host = params.getOrElse("host", sys.error("SFTP Host is null"))
    val username = params.getOrElse("username", sys.error("SFTP Username is null"))
    val password = params.getOrElse("password", "")
    val port = params.getOrElse("port", "22").toInt
    val fileType = params.getOrElse("file.type", "")

    if (!SupportedFileTypes.contains(fileType)) {
      sys.error(s"${fileType} fileType not supported. Only supported ${SupportedFileTypes.mkString(",")}")
    }

    val sftp = SFTPClient(host, port, username, password)

    null
  }

  override def createRelation(sqlContext: SQLContext,
                              parameters: Map[String, String]): BaseRelation = ???

  override def shortName(): String = "sftp"
}
