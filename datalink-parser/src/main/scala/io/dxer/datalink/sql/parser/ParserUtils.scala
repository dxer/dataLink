package io.dxer.datalink.sql.parser

import java.util.Properties

import io.dxer.datalink.sql.parser.SqlBaseParser.TableIdentifierContext
import org.antlr.v4.runtime.misc.Interval
import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.{ParserRuleContext, Token}

import scala.collection.mutable.StringBuilder
import scala.collection.JavaConverters._


object ParserUtils {

  val CHAR_PATTERN = "[^0-9]"
  val INT_PATTERN = "^-?[1-9]\\d*$"
  val DOUBLE_PATTERN = "^[-]?[1-9]\\d*\\.\\d*|-0\\.\\d*[1-9]\\d*$"

  def command(ctx: ParserRuleContext): String = {
    val stream = ctx.getStart.getInputStream
    stream.getText(Interval.of(0, stream.size() - 1))
  }

  def string(token: Token): String = if (token != null) token.getText else null

  def string(node: TerminalNode): String = if (node != null) unescapeSQLString(node.getText) else null

  def stringWithoutUnescape(node: TerminalNode): String = {
    // STRING parser rule forces that the input always has quotes at the starting and ending.
    node.getText.slice(1, node.getText.size - 1)
  }

  def getOriginalText(ctx: ParserRuleContext): String = {
    if (ctx == null) {
      return null
    }
    val start = ctx.start.getStartIndex
    val stop = ctx.stop.getStopIndex
    val interval = new Interval(start, stop)
    ctx.start.getTokenSource.asInstanceOf[SqlBaseLexer]._input.getText(interval)
  }

  def getProperties(ctx: SqlBaseParser.PropertiesContext): Properties = {
    val props = new Properties()
    if (ctx != null && ctx.property() != null) {
      val properties = ctx.property().asScala
      properties.foreach(p => {
        val key = p.key.getText
        val value = unQuote(p.value.getText)
        props.setProperty(key, value)
      })
    }
    props
  }

  def convert(item: String): Any = {
    if (item == null) {
      return item
    }

    val itemTrimed = item.trim
    item match {
      case _ if "true".equalsIgnoreCase(itemTrimed) || "false".equalsIgnoreCase(itemTrimed) => itemTrimed.toBoolean
      case _ if itemTrimed.matches(INT_PATTERN) => itemTrimed.toInt
      case _ if itemTrimed.matches(DOUBLE_PATTERN) => itemTrimed.toDouble
      case _ => unQuote(item)
    }

  }

  def unQuote(value: String): String = {
    var ret = value
    if (value != null && value.length > 0) {
      if (value.startsWith("'") && value.endsWith("'")) {
        ret = value.substring(1, value.length - 1)
      } else if (value.startsWith("\"") && value.endsWith("\"")) {
        ret = value.substring(1, value.length - 1)
      }
    }
    ret
  }

  def getTableIdentifier(ctx: TableIdentifierContext): TableIdentifier = {
    TableIdentifier(ctx.table.getText, Option(ctx.db).map(_.getText))
  }

  def checkDuplicateKeys[T](keyPairs: Seq[(String, T)], ctx: ParserRuleContext): Unit = {
    keyPairs.groupBy(_._1).filter(_._2.size > 1).foreach { case (key, _) =>
      throw new ParseException(s"Found duplicate keys '$key'.", ctx)
    }
  }

  /** Unescape baskslash-escaped string enclosed by quotes. */
  def unescapeSQLString(b: String): String = {
    var enclosure: Character = null
    val sb = new StringBuilder(b.length())

    def appendEscapedChar(n: Char) {
      n match {
        case '0' => sb.append('\u0000')
        case '\'' => sb.append('\'')
        case '"' => sb.append('\"')
        case 'b' => sb.append('\b')
        case 'n' => sb.append('\n')
        case 'r' => sb.append('\r')
        case 't' => sb.append('\t')
        case 'Z' => sb.append('\u001A')
        case '\\' => sb.append('\\')
        // The following 2 lines are exactly what MySQL does TODO: why do we do this?
        case '%' => sb.append("\\%")
        case '_' => sb.append("\\_")
        case _ => sb.append(n)
      }
    }

    var i = 0
    val strLength = b.length
    while (i < strLength) {
      val currentChar = b.charAt(i)
      if (enclosure == null) {
        if (currentChar == '\'' || currentChar == '\"') {
          enclosure = currentChar
        }
      } else if (enclosure == currentChar) {
        enclosure = null
      } else if (currentChar == '\\') {

        if ((i + 6 < strLength) && b.charAt(i + 1) == 'u') {
          // \u0000 style character literals.

          val base = i + 2
          val code = (0 until 4).foldLeft(0) { (mid, j) =>
            val digit = Character.digit(b.charAt(j + base), 16)
            (mid << 4) + digit
          }
          sb.append(code.asInstanceOf[Char])
          i += 5
        } else if (i + 4 < strLength) {

          val i1 = b.charAt(i + 1)
          val i2 = b.charAt(i + 2)
          val i3 = b.charAt(i + 3)

          if ((i1 >= '0' && i1 <= '1') && (i2 >= '0' && i2 <= '7') && (i3 >= '0' && i3 <= '7')) {
            val tmp = ((i3 - '0') + ((i2 - '0') << 3) + ((i1 - '0') << 6)).asInstanceOf[Char]
            sb.append(tmp)
            i += 3
          } else {
            appendEscapedChar(i1)
            i += 1
          }
        } else if (i + 2 < strLength) {
          // escaped character literals.
          val n = b.charAt(i + 1)
          appendEscapedChar(n)
          i += 1
        }
      } else {
        // non-escaped character literals.
        sb.append(currentChar)
      }
      i += 1
    }
    sb.toString()
  }

}
