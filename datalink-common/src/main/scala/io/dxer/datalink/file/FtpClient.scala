package io.dxer.datalink.file

import java.io.{File, FileOutputStream, InputStream, OutputStream}

import com.google.common.base.Strings
import io.dxer.datalink.util.Logging
import org.apache.commons.net.ftp.{FTP, FTPClient, FTPReply}

class FtpClient(host: String, port: Int, user: String, password: String) extends Logging {

  private var ftp: FTPClient = _

  private def init(): Unit = {
    if (ftp != null) {
      ftp = new FTPClient
      ftp.connect(host, port)
      ftp.login(user, password)
    }
  }


  def upload1(local: String, remote: String, close: Boolean = true): Unit = {

  }

  def upload2(input: InputStream, ftpPath: String, fileName: String, close: Boolean = true): Unit = {
    if (!FTPReply.isPositiveCompletion(ftp.getReply)) {
      ftp.disconnect()
      return
    }

    try {
      if (!ftp.changeWorkingDirectory(ftpPath)) {
        // 如果目录不存在则创建目录
        val dirs = ftpPath.split("/")
        var tmpPath: String = ""
        dirs.filter(!Strings.isNullOrEmpty(_)).foreach(dir => {
          tmpPath += "/" + dir
          if (!ftp.changeWorkingDirectory(tmpPath)) {
            if (!ftp.makeDirectory(tmpPath)) {
              throw new Exception(s"create dir ${tmpPath} error")
            } else {
              ftp.changeWorkingDirectory(tmpPath)
            }
          }
        })
      }

      ftp.setFileType(FTP.BINARY_FILE_TYPE)
      ftp.storeFile(fileName, input)
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      if (close) {
        if (input != null) input.close()
        this.close()
      }
    }
  }

  def download(remote: String, local: String, close: Boolean = true, encoding: String = "UTF-8"): Unit = {
    var output: OutputStream = null
    try {
      ftp.setControlEncoding(encoding)
      ftp.setFileType(FTP.BINARY_FILE_TYPE)
      ftp.enterLocalPassiveMode()
      ftp.changeWorkingDirectory(remote)

      val localFile = new File(local)
      output = new FileOutputStream(localFile)
      val fileName = ""
      ftp.retrieveFile(fileName, output)
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      if (close) {
        output.close()
        ftp.disconnect()
      }
    }

  }

  def downFile(basePath: String, fileName: String, output: OutputStream, close: Boolean = true): Unit = {
    if (!FTPReply.isPositiveCompletion(ftp.getReply)) {
      ftp.disconnect()
      return
    }
    ftp.changeWorkingDirectory(basePath)
    val ftpFiles = ftp.listFiles()
    ftpFiles.filter(_.getName.equals(fileName))
      .map(file => ftp.retrieveFile(file.getName, output))

    if (close) {
      if (output != null) output.close()
      this.close()
    }
  }

  def close(): Unit = {
    if (ftp != null) {
      ftp.logout()
      if (ftp.isConnected) ftp.disconnect()
    }
  }

  init()
}
