package io.dxer.datalink.file

import org.scalatest.FunSuite

class SFTPTest extends FunSuite {

  val host = "192.168.56.10"
  val port = 22
  val username = "sftp"
  val passwd = "sftp"

  val sftp = SFTPClient(host, port, username, passwd)


  test("copyFromFtp") {
    sftp.copyFromFtp("/upload", "e:/sftp")
  }

  test("copyToFTP") {
    sftp.copyToFtp("e:/sftp", "/upload")
  }
}
