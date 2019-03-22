package io.dxer.datalink.file

import java.io.{File, InputStream}
import java.util
import java.util.Properties
import java.util.regex.Pattern

import com.google.common.base.Strings
import com.jcraft.jsch.ChannelSftp.LsEntrySelector
import com.jcraft.jsch.{ChannelSftp, JSch, SftpATTRS, SftpException}
import io.dxer.datalink.util.Logging
import org.apache.commons.io.FileUtils

import scala.collection.JavaConversions._

/**
  *
  * @param username
  * @param password
  * @param host
  * @param port
  */
class SFTPClient(host: String, port: Int, username: String, password: String) extends Logging {


  private val STR_STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking"
  private val STR_SFTP: String = "sftp"
  private val STR_NO: String = "no"

  private var useIdentify: Boolean = _
  private var prvkey: String = _
  private var passphrase: String = _

  def this(host: String, port: Int, username: String, prvkey: String, passphrase: String) {
    this(host, port, username, "")
    this.prvkey = prvkey
    this.passphrase = passphrase
    this.useIdentify = true
  }


  /**
    * create sftp client
    *
    * @return
    */
  def createSFTPChannel(): ChannelSftp = {
    val jsch = new JSch()

    if (useIdentify) {
      if (!Strings.isNullOrEmpty(prvkey))
        jsch.addIdentity(prvkey, passphrase)
      else
        jsch.addIdentity(prvkey)
    }

    val session = jsch.getSession(username, host, port)
    if (!useIdentify) {
      session.setPassword(password)
    }
    val props = new Properties()
    props.put(STR_STRICT_HOST_KEY_CHECKING, STR_NO)
    session.setConfig(props)
    session.connect()

    val channel = session.openChannel(STR_SFTP)
    channel.connect()
    channel.asInstanceOf[ChannelSftp]
  }


  /**
    *
    * @param src
    * @param dst
    * @param mode OVERWRITE=0,RESUME=1,APPEND=2
    * @param encoding
    */
  def copyInputStreamToFtp(src: InputStream, dst: String, mode: Int = 0, encoding: String = "UTF-8"): Unit = {
    val channel = createSFTPChannel()
    channel.setFilenameEncoding(encoding)

    val basePath = dst.substring(0, dst.lastIndexOf("/")) // get file parent dir
    val attrs = channel.stat(basePath)

    if (attrs == null) {
      channel.mkdir(basePath) // create parent dir
    }

    channel.put(src, dst, mode)
    close(channel)
  }

  def copyToFtp(src: String, dst: String, mode: Int = 0, encoding: String = "UTF-8", pattern: String = ""): Unit = {
    val channel = createSFTPChannel()
    channel.setFilenameEncoding(encoding)
    try {
      val file = new File(src)
      if (file.isDirectory) { // is a directory
        copyDirToFtp(channel, src, dst, mode, pattern)
      } else {
        copyFileToFtp(channel, src, dst, mode, pattern)
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      close(channel)
    }
  }

  def copyFileToFtp(channel: ChannelSftp, srcFile: String, dst: String, mode: Int = SFTPClient.OVERWRITE, filePattern: String = ""): Unit = {
    try {
      val file = FileUtils.getFile(srcFile)

      // file filter
      val fileMatcher: Pattern = if (!Strings.isNullOrEmpty(filePattern)) Pattern.compile(filePattern) else null
      if (fileMatcher != null) {
        val matcher = fileMatcher.matcher(file.getName)
        if (!matcher.find()) {
          return
        }
      }

      val attrs = channel.stat(dst)
      if (attrs.isDir) {
        channel.cd(dst)
        channel.put(srcFile, file.getName, mode)
      } else {
        channel.put(srcFile, dst, mode)
      }
    } catch {
      case e: SftpException => e.printStackTrace()
    }
  }

  def copyDirToFtp(channel: ChannelSftp, srcDir: String, dstDir: String, mode: Int = SFTPClient.OVERWRITE, filePattern: String = ""): Unit = {
    val files = new File(srcDir).listFiles()

    val fileMatcher: Pattern = if (!Strings.isNullOrEmpty(filePattern)) Pattern.compile(filePattern) else null

    files.foreach(file => {
      val entryName = file.getName

      var isMatch = false
      if (fileMatcher != null) {
        val matcher = fileMatcher.matcher(entryName)
        isMatch = matcher.find()
      }

      if ((fileMatcher != null && isMatch) || (fileMatcher == null))
        if (file.isDirectory) {
          channel.cd(dstDir)
          channel.mkdir(entryName)
          copyDirToFtp(channel, file.getPath, dstDir + "/" + entryName, mode)
        } else {
          copyFileToFtp(channel, file.getPath, dstDir, mode)
        }
    })
  }

  def copyFromFtp(src: String, dst: String, mode: Int = SFTPClient.OVERWRITE): Unit = {
    val channel = createSFTPChannel()
    var attrs: SftpATTRS = null
    try {
      attrs = channel.stat(src)
      if (attrs.isDir) {
        copyDirFromFtp(channel, src, dst, mode) // dir
      } else {
        copyFileFromFtp(channel, src, dst, mode) // file
      }
    } catch {
      case e: SftpException => e.printStackTrace()
    } finally {
      close(channel)
    }
  }

  def copyDirFromFtp(channel: ChannelSftp, srcDir: String, dstDir: String, mode: Int = SFTPClient.OVERWRITE, filePattern: String = null): Unit = {
    val files = new util.ArrayList[ChannelSftp#LsEntry]()

    val fileMatcher: Pattern = if (!Strings.isNullOrEmpty(filePattern)) Pattern.compile(filePattern) else null
    val selector = new LsEntrySelector() {
      override def select(entry: ChannelSftp#LsEntry): Int = {
        if (fileMatcher != null) {
          val matcher = fileMatcher.matcher(entry.getFilename)
          val attrs = entry.getAttrs
          val isMatch = matcher.find() && !attrs.isDir && !attrs.isLink
          if (isMatch) {
            files.add(entry)
          }
        } else {
          files.add(entry)
        }
        LsEntrySelector.CONTINUE
      }
    }

    val pwd = channel.pwd()
    channel.cd(srcDir)
    channel.ls(".", selector)

    files.foreach(f => {
      val entryName = f.getFilename
      println(entryName)
      if (!entryName.equals(".") && !entryName.equals("..")) {
        if (f.getAttrs.isDir) {
          val path = dstDir + File.separator + entryName
          val file = new File(path)
          if (!file.exists()) {
            file.mkdirs()
          }
          copyDirFromFtp(channel, entryName, path)
        } else {
          copyFileFromFtp(channel, entryName, dstDir + File.separator + entryName)
        }
      }
    })
    channel.cd(pwd)
  }

  def copyFileFromFtp(channel: ChannelSftp, srcFile: String, dstFile: String, mode: Int = SFTPClient.OVERWRITE): Unit = {
    println(dstFile)
    val file = FileUtils.getFile(dstFile)

    if (file.exists()) {
      if (file.isDirectory) {
        val srcFileName = srcFile.substring(srcFile.lastIndexOf("/") + 1)
        channel.get(srcFile, dstFile + File.separator + srcFileName)
      } else {
        mode match {
          case SFTPClient.OVERWRITE => channel.get(srcFile, dstFile, null, mode)
          case _ => throw new Exception("target file is exists")
        }
      }
    } else {
      channel.get(srcFile, dstFile, null, mode)
    }
  }

  def close(channel: ChannelSftp): Unit = {
    if (channel != null && channel.isConnected) {
      val session = channel.getSession
      channel.disconnect()
      channel.exit()
      if (session != null && session.isConnected) {
        session.disconnect()
      }
    }
  }
}

object SFTPClient {
  val OVERWRITE = 0
  val RESUME = 1
  val APPEND = 2

  def apply(host: String, port: Int, username: String, password: String): SFTPClient =
    new SFTPClient(host, port, username, password)

  def apply(host: String, port: Int, username: String, prvkey: String, passphrase: String): SFTPClient =
    new SFTPClient(host, port, username, prvkey, passphrase)
}
