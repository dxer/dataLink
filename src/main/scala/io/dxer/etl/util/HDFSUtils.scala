package io.dxer.etl.util

import java.io._
import java.util.Properties

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.permission.FsPermission
import org.apache.hadoop.fs.{FSDataInputStream, FileSystem, FileUtil, Path}
import org.apache.hadoop.hdfs.DistributedFileSystem
import org.apache.hadoop.io.IOUtils
import org.apache.hadoop.security.UserGroupInformation
import org.apache.log4j.Logger

import scala.collection.mutable.ArrayBuffer

/**
  * HDFS操作
  */
object HDFSUtils {

  val logger = Logger.getLogger(HDFSUtils.getClass.getName)

  val USER_PRINCIPAL = ""
  val KEYTAB_PATH = ""

  val props = new Properties()
  val user = props.getProperty(USER_PRINCIPAL)
  val keytabPath = props.getProperty(KEYTAB_PATH)

  var fileSystem: FileSystem = null

  def getFileSystem(): FileSystem = {
    if (fileSystem != null) {
      return fileSystem
    }
    val conf = new Configuration()

    conf.set("fs.hdfs.impl", classOf[DistributedFileSystem].getName)
    conf.set("fs.permissions.umask-mode", "002")

    if (keytabPath != null && keytabPath.length > 0) {
      System.setProperty("java.security.krb5.conf", "/etc/krb5.conf")
      conf.set("hadoop.security.authentication", "kerberos")
      UserGroupInformation.setConfiguration(conf)
      try
        UserGroupInformation.loginUserFromKeytab(user, keytabPath)
      catch {
        case e: Exception =>
          logger.error("hdfs login error", e)
          e.printStackTrace()
      }
    }

    conf.set("mapred.remote.os", "Linux")
    fileSystem = FileSystem.get(conf)
    require(fileSystem != null, "FileSystem must not null")
    fileSystem
  }

  /**
    *
    * @param path
    */
  def ls(path: String): Unit = {
    val fileSystem = getFileSystem()
    val fs = fileSystem.listStatus(new Path(path))

    val listPath = FileUtil.stat2Paths(fs)
    for (p <- listPath) {
      println(p)
    }
  }

  def getFileList(path: String): Array[Path] = {
    var files = ArrayBuffer[Path]()
    val fileSystem = getFileSystem()
    val fs = fileSystem.listStatus(new Path(path))

    val listPath = FileUtil.stat2Paths(fs)
    for (p <- listPath) {
      files += p
    }
    files.toArray
  }

  /**
    * 创建目录
    *
    * @param filePath
    * @return
    */
  @throws(classOf[IOException])
  def mkdirs(filePath: String): Boolean = {
    val fileSystem = getFileSystem()

    if (!fileSystem.exists(new Path(filePath))) {
      fileSystem.mkdirs(new Path(filePath))
    } else {
      logger.info(s"${filePath} is exist")
      true
    }
  }

  /**
    *
    * @param filePath
    * @param permission
    * @throws java.io.IOException
    * @return
    */
  def mkdirs(filePath: String, permission: String): Boolean = {
    val fileSystem = getFileSystem()
    if (!fileSystem.exists(new Path(filePath))) {
      fileSystem.mkdirs(new Path(filePath), new FsPermission(permission))
    } else {
      logger.info(s"${filePath} is exists")
      true
    }
  }

  /**
    * 删除文件
    *
    * @param filePath
    * @param recusive ， 是否递归删除
    * @return
    */
  @throws(classOf[IOException])
  def rm(filePath: String, recusive: Boolean): Boolean = {
    val fileSystem = getFileSystem()
    val path = new Path(filePath)

    if (fileSystem.exists(path)) {
      return fileSystem.delete(path, recusive)
    } else {
      logger.info(s"${filePath} is not exists")
      true
    }
  }

  /**
    *
    * @param srcFilePath
    * @param dstPath
    */
  def uploadFile(srcFilePath: String, dstPath: String): Unit = {
    val srcFile = new File(srcFilePath)

    if (!srcFile.exists() || !srcFile.isFile) {
      throw new FileNotFoundException(srcFilePath + " file is not exist.")
    }

    val fileSystem = getFileSystem()

    val fileNamePosi = srcFilePath.lastIndexOf("/")
    val fileName = srcFilePath.substring(fileNamePosi + 1)

    val dst = new Path(dstPath)

    if (!fileSystem.exists(dst)) {
      val parentPathPosi = dstPath.lastIndexOf("/")
      val parentPath = dstPath.substring(0, parentPathPosi)
      if (fileSystem.exists(new Path(parentPath))) {
        upload(srcFilePath, dstPath)
      } else {
        throw new Exception(parentPath + " dir is not exist")
      }
    } else {
      if (fileSystem.isDirectory(dst)) {
        upload(srcFilePath, dst + "/" + fileName)
      } else {
        throw new Exception(dstPath + " is exist")
      }
    }
  }


  def uploadFolder(srcPath: String, dstPath: String): Unit = {
    val srcDir = new File(srcPath)
    if (!srcDir.exists() || !srcDir.isDirectory) {
      throw new FileNotFoundException(srcPath + " dir is not exist.")
    }

    val fileSystem = getFileSystem()
    val dst = new Path(dstPath)

    if (!fileSystem.exists(dst) || (fileSystem.exists(dst) && fileSystem.isDirectory(dst))) {
      if (fileSystem.isDirectory(dst)) {
        val files = srcDir.listFiles()
        for (i <- 0 until files.length) {
          val file = files(i)
          if (file.isFile) {
            upload(file.getAbsolutePath, dstPath)
          } else { // 递归调用
            uploadFolder(file.getAbsolutePath, dstPath)
          }
        }
      } else {
        throw new Exception("")
      }
    } else {

    }
  }

  /**
    * 上传文件
    *
    * @param srcFilePath
    * @param dstFilePath
    * @return
    */
  def upload(srcFilePath: String, dstFilePath: String): Unit = {
    val srcFile = new File(srcFilePath)
    val inStream = new FileInputStream(srcFile)

    val fileSystem = getFileSystem()
    val dest = new Path(dstFilePath)
    val outStream = fileSystem.create(dest)

    try {
      IOUtils.copyBytes(inStream, outStream, 4096, false)
    } catch {
      case e: Exception => throw e
    } finally {
      IOUtils.closeStream(inStream)
      IOUtils.closeStream(outStream)
    }
  }


  def upload(in: InputStream, dstFilePath: String): Unit = {
    val fileSystem = getFileSystem()
    val dst = new Path(dstFilePath)
    if (fileSystem.exists(dst)) {
      throw new Exception(dstFilePath + " file is exist.")
    }
    val outStream = fileSystem.create(dst)

    try {
      IOUtils.copyBytes(in, outStream, 4096, false)
    } catch {
      case e: IOException => e.printStackTrace()
    } finally {
      IOUtils.closeStream(in)
      IOUtils.closeStream(outStream)
    }
  }

  /**
    * 下载文件
    *
    * @param srcPath
    * @param dstPath
    * @return
    */
  def download(srcPath: String, dstPath: String): Unit = {
    val fileSystem = getFileSystem()
    val path = new Path(srcPath)

    if (fileSystem.exists(path)) {
      if (fileSystem.isFile(path)) {
        downloadFile(srcPath, dstPath)
      } else {
        downloadFolder(srcPath, dstPath)
      }
    } else {
      if (srcPath.endsWith("/*")) {
        val parentPathPosi = srcPath.lastIndexOf("/")
        val parentPath = srcPath.substring(0, parentPathPosi)
        downloadFolder(parentPath, dstPath)
      }
    }
  }

  def downloadFile(srcPath: String, dstPath: String): Unit = {
    var in: FSDataInputStream = null
    var out: FileOutputStream = null

    try {
      val fileSystem = getFileSystem()
      in = fileSystem.open(new Path(srcPath))
      out = new FileOutputStream(dstPath)
      IOUtils.copyBytes(in, out, 4096, false)
    } catch {
      case e: Exception => throw e
    } finally {
      IOUtils.closeStream(in)
      IOUtils.closeStream(out)
    }
  }

  /**
    * 下载文件夹
    *
    * @param srcPath
    * @param dstPath
    */
  def downloadFolder(srcPath: String, dstPath: String): Unit = {
    val dstDir = new File(dstPath)
    if (!dstDir.exists()) {
      // 目的路径不存在，则创建
      dstDir.mkdirs()
    }
    val fileSystem = getFileSystem()
    val srcFileStatus = fileSystem.listStatus(new Path(srcPath))
    val srcFilePaths = FileUtil.stat2Paths(srcFileStatus)
    for (i <- 0 until srcFilePaths.length) {
      val srcFile = srcFilePaths(i).toString
      val fileNamePosi = srcFile.lastIndexOf("/")
      val fileName = srcFile.substring(fileNamePosi + 1)
      download(srcPath + "/" + fileName, dstPath + "/" + fileName)
    }
  }

  /**
    * 读取hdfs文件
    *
    * @param file
    * @return
    */
  def getInputStream(file: String): InputStream = {
    val fileSystem = getFileSystem()
    val path = new Path(file)
    try {
      val in = fileSystem.open(path)
      return in
    } catch {
      case e: Exception => e.printStackTrace()
    }

    return null
  }

  /**
    * 读取hdfs文件
    *
    * @param file
    * @return
    */
  def readFile(file: String): String = {
    val out = new ByteArrayOutputStream()
    var in: InputStream = null
    try {
      in = getInputStream(file)
      if (in != null) {
        IOUtils.copyBytes(in, out, 4096, true)
        return out.toString()
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      IOUtils.closeStream(in)
      IOUtils.closeStream(out)
    }
    null
  }

  /**
    * close file system
    *
    * @param fileSystem
    */
  def close(fileSystem: FileSystem): Unit = {
    if (fileSystem != null) {
      try {
        fileSystem.close()
      } catch {
        case e: IOException => e.printStackTrace()
          logger.error("close hdfs file system error", e)
      }
    }
  }


  def main(args: Array[String]): Unit = {
    println(readFile("/user/analysis/haifeng_20171120172916154/conf/wo.json"))
  }


}
