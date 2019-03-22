package io.dxer.datalink.file

import com.jcraft.jsch.SftpProgressMonitor

class ProgressMonitor extends SftpProgressMonitor {

  var transfered: Long = 0l

  override def init(op: Int, src: String, dest: String, max: Long): Unit = {

  }

  override def count(count: Long): Boolean = {
    transfered = transfered + count
    true
  }

  override def end(): Unit = {

  }
}
