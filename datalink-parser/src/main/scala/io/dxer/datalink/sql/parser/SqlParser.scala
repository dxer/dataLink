package io.dxer.datalink.sql.parser

import io.dxer.datalink.sql.parser.SqlBaseParser.{SingleStatementContext, StatementsContext}
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.misc.{Interval, ParseCancellationException}
import org.antlr.v4.runtime.tree.TerminalNodeImpl

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

class SqlParser {

  val astBuilder: AstBuilder = new AstBuilder

  def getStatement(sqlTest: String): Statement = {
    buildSingleAst(sqlTest).statement
  }

  def buildSingleAst(sqlText: String): PreparedStatement = {
    try {
      val tree = getParseTree(sqlText)
      val statementsContext = tree.asInstanceOf[StatementsContext]
      Option(statementsContext.singleStatement.asScala(0))
        .map(st => PreparedStatement(astBuilder.visitSingleStatement(st).asInstanceOf[Statement], getStatementText(st)))
        .get
    } catch {
      case e: Exception =>
        e.printStackTrace()
        throw new ParseException(e.getMessage, e)
    }
  }

  def buildAst(sqlText: String): List[PreparedStatement] = {
    val preparedStatement = ListBuffer[PreparedStatement]()

    try {
      val tree = getParseTree(sqlText)
      val statementsContext = tree.asInstanceOf[StatementsContext]
      statementsContext.singleStatement.asScala.foreach(statementContext => {
        var statement = astBuilder.visitSingleStatement(statementContext).asInstanceOf[Statement]
        var sql = getStatementText(statementContext)
        if (statement == null) {
          if (sql.endsWith(";")) {
            sql = sql.substring(0, sql.length - 1)
          }
          statement = new OriginSQL(sql)
        }
        preparedStatement += PreparedStatement(statement, sql)
      })
    } catch {
      case e: Exception =>
        e.printStackTrace()
        throw new ParseException(e.getMessage, e)
    }

    preparedStatement.toList
  }

  def getStatementText(singleStatementContext: SingleStatementContext): String = {
    val charStream = singleStatementContext.start.getInputStream
    charStream.getText(Interval.of(
      singleStatementContext.start.getStartIndex,
      singleStatementContext.stop.getStopIndex))
  }

  def getStatements(sqlText: String): List[SingleStatementContext] = {
    try {
      val tree = getParseTree(sqlText)
      val statementsContext = tree.asInstanceOf[StatementsContext]
      return statementsContext.singleStatement().asScala.toList
    } catch {
      case e: Exception => throw new ParseException(e.getMessage, e)
    }
  }

  def getParseTree(sqlText: String): ParserRuleContext = parse(sqlText) { parse =>
    parse.statements.asInstanceOf[ParserRuleContext]
  }

  protected def parse[T](sqlText: String)(toResult: SqlBaseParser => T): T = {
    val lexer = new SqlBaseLexer(new UpperCaseCharStream(CharStreams.fromString(sqlText)))
    lexer.removeErrorListeners()
    lexer.addErrorListener(ParseErrorListener)

    val tokenStream = new CommonTokenStream(lexer)
    val parser = new SqlBaseParser(tokenStream)
    parser.addParseListener(new PostProcessor)
    parser.addErrorListener(ParseErrorListener)
    try {
      try {
        // first, try parsing with potentially faster SLL mode
        parser.getInterpreter.setPredictionMode(PredictionMode.SLL)
        toResult(parser)
      } catch {
        case e: ParseCancellationException =>
          // if we fail, parse with LL mode
          tokenStream.seek(0) // rewind input stream
          parser.reset()

          // Try Again.
          parser.getInterpreter.setPredictionMode(PredictionMode.LL)
          toResult(parser)
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
        throw new ParseException(Option(sqlText), e.getMessage)
    }
  }
}


class UpperCaseCharStream(wrapped: CodePointCharStream) extends CharStream {
  override def consume(): Unit = wrapped.consume

  override def getSourceName(): String = wrapped.getSourceName

  override def index(): Int = wrapped.index

  override def mark(): Int = wrapped.mark

  override def release(marker: Int): Unit = wrapped.release(marker)

  override def seek(where: Int): Unit = wrapped.seek(where)

  override def size(): Int = wrapped.size

  override def getText(interval: Interval): String = {
    // ANTLR 4.7's CodePointCharStream implementations have bugs when
    // getText() is called with an empty stream, or intervals where
    // the start > end. See
    // https://github.com/antlr/antlr4/commit/ac9f7530 for one fix
    // that is not yet in a released ANTLR artifact.
    if (size() > 0 && (interval.b - interval.a >= 0)) {
      wrapped.getText(interval)
    } else {
      ""
    }
  }

  override def LA(i: Int): Int = {
    val la = wrapped.LA(i)
    if (la == 0 || la == IntStream.EOF) la
    else Character.toUpperCase(la)
  }
}

case object ParseErrorListener extends BaseErrorListener {
  override def syntaxError(
                            recognizer: Recognizer[_, _],
                            offendingSymbol: scala.Any,
                            line: Int,
                            charPositionInLine: Int,
                            msg: String,
                            e: RecognitionException): Unit = {
    throw new ParseException(None, msg)
  }
}


class ParseException(val command: Option[String],
                     message: String, throwable: Throwable) extends Exception(message, throwable) {

  def this(command: Option[String], message: String) {
    this(command, message, null)
  }

  def this(message: String, ctx: ParserRuleContext) {
    this(Option(ParserUtils.command(ctx)), message, null)
  }

  def this(message: String, throwable: Throwable) {
    this(None, message, throwable)
  }

  def this(message: String) {
    this(message, throwable = null)
  }

}


class PostProcessor extends SqlBaseBaseListener {

  /** Remove the back ticks from an Identifier. */
  override def exitQuotedIdentifier(ctx: SqlBaseParser.QuotedIdentifierContext): Unit = {
    replaceTokenByIdentifier(ctx, 1) {
      token =>
        // Remove the double back ticks in the string.
        token.setText(token.getText.replace("``", "`"))
        token
    }
  }

  /** Treat non-reserved keywords as Identifiers. */
  //  override def exitNonReserved(ctx: SqlBaseParser.NonReservedContext): Unit = {
  //    replaceTokenByIdentifier(ctx, 0)(identity)
  //  }

  private def replaceTokenByIdentifier(
                                        ctx: ParserRuleContext,
                                        stripMargins: Int)(
                                        f: CommonToken => CommonToken = identity): Unit = {
    val parent = ctx.getParent
    parent.removeLastChild()
    val token = ctx.getChild(0).getPayload.asInstanceOf[Token]
    val newToken = new CommonToken(
      new org.antlr.v4.runtime.misc.Pair(token.getTokenSource, token.getInputStream),
      SqlBaseParser.IDENTIFIER,
      token.getChannel,
      token.getStartIndex + stripMargins,
      token.getStopIndex - stripMargins)
    parent.addChild(new TerminalNodeImpl(f(newToken)))
  }
}


case class PreparedStatement(statement: Statement, sql: String)