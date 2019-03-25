package io.dxer.datalink.sql.parser

import io.dxer.datalink.sql.parser.SqlBaseParser._
import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.{ParserRuleContext, Token}

import scala.collection.JavaConverters._

class AstBuilder extends SqlBaseBaseVisitor[Node] {

  import ParserUtils._


  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitStatements(ctx: StatementsContext): Node = {
    val statementList = ctx.singleStatement().asScala.map(stmtContext => {
      visitSingleStatement(stmtContext).asInstanceOf[Statement]
    }).toList
    new Statements(statementList)
  }

  override def visitSingleStatement(ctx: SqlBaseParser.SingleStatementContext): Node = {
    visit(ctx.statement())
  }

  override def visitSingleExpression(ctx: SqlBaseParser.SingleExpressionContext): Node = {
    visit(ctx.expression())
  }


  override def visitCreateConnection(ctx: CreateConnectionContext): Node = {
    new CreateConnection(getLocation(ctx),
      ctx.TEMPORARY() != null,
      ctx.connectionType.getText.toUpperCase,
      string(ctx.name),
      getProperties(ctx.properties()))
  }


  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitDropConnection(ctx: DropConnectionContext): Node = {
    new DropConnection(getLocation(ctx),
      ctx.TEMPORARY() != null,
      ctx.connectionType.getText.toUpperCase,
      string(ctx.name))
  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitShowCreateConnection(ctx: ShowCreateConnectionContext): Node = {
    new ShowCreateConnection(getLocation(ctx),
      ctx.connectionType.getText.toUpperCase,
      string(ctx.name))
  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitShowConnections(ctx: ShowConnectionsContext): Node = {
    val connectionType = if (ctx.identifier() != null)
      ctx.identifier().getText else ""

    new ShowConnections(getLocation(ctx),
      connectionType,
      unQuote(string(ctx.pattern)))
  }


  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitLoadTable(ctx: LoadTableContext): Node = {
    new LoadTable(getLocation(ctx),
      ctx.LOCAL() != null,
      ctx.format().getText,
      ctx.path().getText,
      getProperties(ctx.properties()),
      ctx.AS() != null,
      ctx.OVERWRITE() != null,
      getTableIdentifier(ctx.tableIdentifier()),
      getPartitionSpec(ctx.partitionSpec()))
  }


  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitInsertInto(ctx: InsertIntoContext): Node = {
    new InsertInto(getLocation(ctx),
      ctx.OVERWRITE() != null,
      ctx.LOCAL() != null,
      ctx.format().getText,
      ctx.path().getText,
      getProperties(ctx.properties()),
      ctx.tableName.getText,
      getOriginalText(ctx.query())
    )
  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitTest(ctx: TestContext): Node = {
    new OriginSQL(getOriginalText(ctx))
  }


  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitQueryStatement(ctx: QueryStatementContext): Node = {
    new OriginSQL(getOriginalText(ctx))
  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitQueryAsTable(ctx: QueryAsTableContext): Node = {
    new QueryAsTable(getLocation(ctx), ctx.query().getText, ctx.tableName.getText)
  }


  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitExecFunc(ctx: ExecFuncContext): Node = {
    val paramsContext = ctx.funcParams().params()
    val params: Seq[Any] = if (paramsContext != null) {
      paramsContext.asScala.map(p => {
        convert(p.getText)
      })
    } else Seq[Any]()

    new ExecFunc(getLocation(ctx),
      ctx.func.getText,
      params)

  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  def getPartitionSpec(ctx: SqlBaseParser.PartitionSpecContext): Map[String, String] = {
    if (ctx == null || ctx.partitionVal() == null) {
      return Map[String, String]()
    }
    val parts = ctx.partitionVal().asScala.map {
      pVal =>
        val name = pVal.identifier().getText
        val value = visitStringConstant(pVal.constant())
        name -> value
    }
    checkDuplicateKeys(parts, ctx)
    parts.toMap
  }

  private def createString(ctx: StringLiteralContext): String = {
    ctx.STRING().asScala.map(c => c.getText).mkString
  }


  private def visitStringConstant(ctx: ConstantContext): String = {
    ctx match {
      case s: StringLiteralContext => createString(s)
      case o => o.getText
    }
  }


  def getLocation(terminalNode: TerminalNode): NodeLocation = {
    require(terminalNode != null, "terminalNode is null")
    getLocation(terminalNode.getSymbol)
  }

  def getLocation(parserRuleContext: ParserRuleContext): NodeLocation = {
    require(parserRuleContext != null, "parserRuleContext is null")
    getLocation(parserRuleContext.getStart)
  }

  def getLocation(token: Token): NodeLocation = {
    require(token != null, "token is null")
    new NodeLocation(token.getLine(), token.getCharPositionInLine())
  }

}
