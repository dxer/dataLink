package io.dxer.datalink.sql.execution

import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.sql.parser.ExecFunc
import io.dxer.datalink.sql.{ConnectionManager, DataLinkSession}

class ExecFuncCommand(execFunc: ExecFunc) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {

    lazy val connectionManager = dataLinkSession.connectionManager

    lazy val hadoopConf = dataLinkSession.hadoopConf

    execFunc.func.toLowerCase match {

      case ExecFuncCommand.FTP_TO_HDFS =>

      case ExecFuncCommand.FTP_TO_LOCAL =>

      case ExecFuncCommand.HDFS_TO_FTP =>

      case ExecFuncCommand.LOCAL_TO_FTP =>

      case ExecFuncCommand.LOCAL_TO_SFTP =>

      case ExecFuncCommand.HDFS_TO_SFTP =>

      case ExecFuncCommand.SFTP_TO_LOCAL =>

      case ExecFuncCommand.SFTP_TO_LOCAL =>

      case ExecFuncCommand.LOCAL_TO_HDFS =>

      case ExecFuncCommand.HDFS_TO_LOCAL =>

      case ExecFuncCommand.LOCAL_COMMAND =>

      case _ => throw new DataLinkException("Unsupported exec command")
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

object ExecFuncCommand {
  val FTP_TO_LOCAL = "ftp_to_local"
  val FTP_TO_HDFS = "ftp_to_hdfs"
  val LOCAL_TO_FTP = "local_to_ftp"
  val HDFS_TO_FTP = "hdfs_to_ftp"
  val LOCAL_COMMAND = ""

  val SFTP_TO_LOCAL = "sftp_to_local"
  val SFTP_TO_HDFS = "sftp_to_hdfs"
  val LOCAL_TO_SFTP = "local_to_sftp"
  val HDFS_TO_SFTP = "hdfs_to_sftp"


  val LOCAL_TO_HDFS = "local_to_hdfs"
  val HDFS_TO_LOCAL = "hdfs_to_local"


}
