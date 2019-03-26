package io.dxer.datalink.util

import java.io.{BufferedReader, InputStream, InputStreamReader, PrintStream}


class ShellExecutor(cmd: String, out: PrintStream, err: PrintStream) {

  def execute(): Int = {
    try {
      val process = Runtime.getRuntime.exec(cmd)
      val outPrinter = new StreamPrinter(process.getInputStream, null, out)
      val errPrinter = new StreamPrinter(process.getErrorStream, null, err)

      outPrinter.start()
      errPrinter.start()

      val ret = process.waitFor()
      outPrinter.join()
      errPrinter.join()
      return ret
    } catch {
      case e: Exception => throw new Exception("Failed to execute " + cmd, e);
    }
  }

}

class StreamPrinter(is: InputStream, s: String, outputStreams: PrintStream*) extends Thread {

  override def run(): Unit = {
    var br: BufferedReader = null
    try {
      val isr = new InputStreamReader(is)
      br = new BufferedReader(isr)
      var line: String = null
      while ((line = br.readLine()) != null) {
        for (os <- outputStreams) {
          if (s != null) {
            os.println(s + ">" + line)
          } else {
            os.println(line)
          }
        }
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      if (br != null) {
        br.close()
        br = null
      }
    }
  }

}
