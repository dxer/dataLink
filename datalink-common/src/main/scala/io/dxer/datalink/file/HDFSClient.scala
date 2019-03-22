package io.dxer.datalink.file

import java.io.{DataInputStream, DataOutputStream, File}

import com.google.common.base.Strings
import io.dxer.datalink.util.Logging
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs._
import org.apache.hadoop.fs.permission.FsPermission
import org.apache.hadoop.io.IOUtils

import scala.collection.mutable.ArrayBuffer


class HDFSClient(conf: Configuration) extends Logging{

  val fileSystem: FileSystem = getFileSystem(conf)

  def getFileSystem(conf: Configuration): FileSystem = {
    FileSystem.get(conf)
  }

  def close(): Unit = {
    if (fileSystem != null) {
      try {
        fileSystem.close()
      } catch {
        case e: Exception => logger.error("close error", e)
      }
    }
  }

  def getFiles(path: String, recursive: Boolean = false): Array[LocatedFileStatus] = {
    val fileBuffer = ArrayBuffer[LocatedFileStatus]()

    try {
      val files = fileSystem.listFiles(new Path(path), recursive)
      if (files != null) {
        while (files.hasNext) {
          fileBuffer += files.next()
        }
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }
    fileBuffer.toArray
  }

  def mkdirs(path: String, mode: String = null): Boolean = {
    val filePath = new Path(path)
    if (!fileSystem.exists(filePath)) {
      val permission = if (Strings.isNullOrEmpty(mode)) {
        FsPermission.getDirDefault
      } else {
        new FsPermission(mode)
      }

      return fileSystem.mkdirs(filePath, permission)
    } else {
      logger.info("dir is exists")
      return true
    }
  }

  def delete(path: String, recursive: Boolean = true): Boolean = {
    val filePath = new Path(path)
    if (fileSystem.exists(filePath)) {
      fileSystem.delete(filePath, recursive)
    } else {
      logger.info(s"${path} is not exists")
      true
    }
  }

  def copyFileFromLocal(src: String, dst: String): Unit = {
    val localFile = new File(src)
    require(localFile != null && localFile.exists(), "src is not exist")
    fileSystem.copyFromLocalFile(new Path(src), new Path(dst))
  }

  def copyToLocalFile(src: String, dst: String): Unit = {
    val srcPath = new Path(src)
    require(fileSystem.exists(srcPath), "src is not exists")
    fileSystem.copyToLocalFile(srcPath, new Path(dst))
  }

  def writeToOutputStream(path: String, output: DataOutputStream, close: Boolean = false): Unit = {
    val filePath = new Path(path)
    val inputStream = fileSystem.open(filePath)
    if (inputStream != null) {
      IOUtils.copyBytes(inputStream, output, 4096, close)
    }
  }

  def readFromInputStream(input: DataInputStream, path: String, close: Boolean = false): Unit = {
    val filePath = new Path(path)
    val outputStream = fileSystem.create(filePath)
    if (outputStream != null) {
      IOUtils.copyBytes(input, outputStream, 4096, close)
    }
  }

}
