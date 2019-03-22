package io.dxer.datalink.spark.output

import java.io.PrintStream

import com.google.common.base.{Joiner, Splitter}
import com.google.common.io.BaseEncoding.base16


class ConsolePrinter(fieldNames: List[String], headerOutput: Boolean, out: PrintStream) extends OutputPrinter {

  val HEX_BYTE_JOINER = Joiner.on(' ')
  private val HEX_SPLITTER = Splitter.fixedLength(2)

  override def printRows(rows: List[List[_ <: Any]]): Unit = {
    val columns = fieldNames.size
    val maxWidth = new Array[Int](columns)
    val fieldNamesWithIndex = fieldNames.zipWithIndex
    for ((column, i) <- fieldNamesWithIndex) {
      maxWidth(i) = math.max(1, column.length + 2)
    }

    rows.foreach(row => {
      for ((_, i) <- fieldNamesWithIndex) {
        maxWidth(i) = math.max(maxWidth(i), format(row(i)).length + 2)
      }
    })

    if (headerOutput) {
      for ((column, i) <- fieldNamesWithIndex) {
        if (i > 0) {
          out.append('|')
        }
        out.append(column).append(repeat(" ", maxWidth(i) - column.length))
      }
      out.append('\n')
      for ((_, i) <- fieldNamesWithIndex) {
        if (i > 0) {
          out.append('+')
        }
        out.append(repeat("-", maxWidth(i)))
      }
      out.append('\n')
    }

    rows.foreach(row => {
      for ((_, i) <- fieldNamesWithIndex) {
        if (i > 0) {
          out.append('|')
        }
        val str = format(row(i))
        out.append(str).append(repeat(" ", maxWidth(i) - str.length))
      }
      out.append('\n')
    })
  }

  override def finish(): Unit = ???

  private def repeat(string: String, count: Int): String = {
    if (count <= 0) {
      return ""
    }
    val sb = new StringBuilder
    for (i <- 0 until count) {
      sb.append(string)
    }
    sb.toString()
  }

  private def toStrings(values: List[_ <: AnyRef]): Array[String] = {
    values.map(v => format(v)).toArray
  }


  private def formatRow(values: List[_ <: AnyRef]): String = {
    val sb = new StringBuilder

    val length = values.size
    for ((v, i) <- values.zipWithIndex) {
      sb.append(format(v))
      if (i < length - 1) {
        sb.append('\t')
      }
    }

    values.foreach(v => {

    })
    sb.append('\n')
    sb.toString()
  }

  private def format(o: Any): String = {
    if (o == null) {
      return "NULL"
    }

    if (o.isInstanceOf[Array[Byte]]) {
      return formatHexDump(o.asInstanceOf[Array[Byte]])
    }
    return o.toString
  }


  private def createHexPairs(bytes: Array[Byte]) = {
    val hexDump = base16.lowerCase.encode(bytes)
    HEX_SPLITTER.split(hexDump)
  }

  def formatHexDump(bytes: Array[Byte]): String = HEX_BYTE_JOINER.join(createHexPairs(bytes))

  private def fieldWidth(s: String): Int = {
    s.length
  }

}

object ConsolePrinter {

  def apply(fieldNames: List[String], headerOutput: Boolean, out: PrintStream): ConsolePrinter =
    new ConsolePrinter(fieldNames, headerOutput, out)

}