package io.dxer.datalink.sql.execution

import io.dxer.datalink.file.FtpClient
import io.dxer.datalink.sql.{ConnectionManager, DataLinkSession}
import io.dxer.datalink.sql.parser.ExecFunc

class ExecFuncCommand(execFunc: ExecFunc) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {

    lazy val connectionManager = dataLinkSession.connectionManager

    lazy val hadoopConf = dataLinkSession.hadoopConf

    execFunc.func.toUpperCase match {
      case "FTP_LOCAL_UPLOAD" =>

      case "FTP_HDFS_UPLOAD" =>

      case "FTP_DOWNLOAD_LOCAL" =>

      case "FTP_DOWNLOAD_HDFS" =>

      case "SFTP_UPLOAD" =>

      case "SFTP_DOWNLOAD" =>

      case "HDFS_UPLOAD" =>

      case "HDFS_DOWNLOAD" =>

      case _ => println("Not supported")
    }
  }


  def ftpLocalUpload(connectionManager: ConnectionManager, params: Seq[Any]): Unit = {
//    params match {
//      case Seq(String, String) =>
//        val connectionDescription = connectionManager.getConnectionDescription(params(0).toString)
//
//        val host = connectionDescription.properties.getProperty("host")
//        val port = connectionDescription.properties.getProperty("port").toInt
//        val username = connectionDescription.properties.getProperty("username")
//        val password = connectionDescription.properties.getProperty("password")
//
//        val ftpClient = new FtpClient(host, port, username, password)
//
//        ftpClient.upload("", "")
//
//      case Seq(String, String, String) =>
  //  }
  }

  def ftpDownload(params: Seq[Any]): Unit = {
//    params match {
//      case Seq(String, String) =>
//      case Seq(String, String, String) =>
//    }
  }
}
