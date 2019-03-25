// Generated from io\dxer\datalink\sql\parser\SqlBase.g4 by ANTLR 4.7
package io.dxer.datalink.sql.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlBaseParser}.
 */
public interface SqlBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(SqlBaseParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(SqlBaseParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(SqlBaseParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(SqlBaseParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleExpression(SqlBaseParser.SingleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleExpression(SqlBaseParser.SingleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryStatement}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterQueryStatement(SqlBaseParser.QueryStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryStatement}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitQueryStatement(SqlBaseParser.QueryStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createConnection}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateConnection(SqlBaseParser.CreateConnectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createConnection}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateConnection(SqlBaseParser.CreateConnectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropConnection}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropConnection(SqlBaseParser.DropConnectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropConnection}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropConnection(SqlBaseParser.DropConnectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showCreateConnection}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowCreateConnection(SqlBaseParser.ShowCreateConnectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showCreateConnection}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowCreateConnection(SqlBaseParser.ShowCreateConnectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showConnections}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowConnections(SqlBaseParser.ShowConnectionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showConnections}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowConnections(SqlBaseParser.ShowConnectionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadTable}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoadTable(SqlBaseParser.LoadTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadTable}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoadTable(SqlBaseParser.LoadTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertInto}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterInsertInto(SqlBaseParser.InsertIntoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertInto}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitInsertInto(SqlBaseParser.InsertIntoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryAsTable}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterQueryAsTable(SqlBaseParser.QueryAsTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryAsTable}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitQueryAsTable(SqlBaseParser.QueryAsTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code execFunc}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExecFunc(SqlBaseParser.ExecFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code execFunc}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExecFunc(SqlBaseParser.ExecFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code test}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTest(SqlBaseParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code test}
	 * labeled alternative in {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTest(SqlBaseParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SqlBaseParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SqlBaseParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(SqlBaseParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(SqlBaseParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#connectionType}.
	 * @param ctx the parse tree
	 */
	void enterConnectionType(SqlBaseParser.ConnectionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#connectionType}.
	 * @param ctx the parse tree
	 */
	void exitConnectionType(SqlBaseParser.ConnectionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(SqlBaseParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(SqlBaseParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(SqlBaseParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(SqlBaseParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTableIdentifier(SqlBaseParser.TableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTableIdentifier(SqlBaseParser.TableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#partitionSpec}.
	 * @param ctx the parse tree
	 */
	void enterPartitionSpec(SqlBaseParser.PartitionSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#partitionSpec}.
	 * @param ctx the parse tree
	 */
	void exitPartitionSpec(SqlBaseParser.PartitionSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#partitionVal}.
	 * @param ctx the parse tree
	 */
	void enterPartitionVal(SqlBaseParser.PartitionValContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#partitionVal}.
	 * @param ctx the parse tree
	 */
	void exitPartitionVal(SqlBaseParser.PartitionValContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(SqlBaseParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(SqlBaseParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(SqlBaseParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(SqlBaseParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#propertyKey}.
	 * @param ctx the parse tree
	 */
	void enterPropertyKey(SqlBaseParser.PropertyKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#propertyKey}.
	 * @param ctx the parse tree
	 */
	void exitPropertyKey(SqlBaseParser.PropertyKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#propertyValue}.
	 * @param ctx the parse tree
	 */
	void enterPropertyValue(SqlBaseParser.PropertyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#propertyValue}.
	 * @param ctx the parse tree
	 */
	void exitPropertyValue(SqlBaseParser.PropertyValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#funcParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncParams(SqlBaseParser.FuncParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#funcParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncParams(SqlBaseParser.FuncParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(SqlBaseParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(SqlBaseParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(SqlBaseParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(SqlBaseParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(SqlBaseParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(SqlBaseParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntervalLiteral(SqlBaseParser.IntervalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntervalLiteral(SqlBaseParser.IntervalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstructor(SqlBaseParser.TypeConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstructor(SqlBaseParser.TypeConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(SqlBaseParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(SqlBaseParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(SqlBaseParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(SqlBaseParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SqlBaseParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SqlBaseParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterInterval(SqlBaseParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitInterval(SqlBaseParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void enterIntervalField(SqlBaseParser.IntervalFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void exitIntervalField(SqlBaseParser.IntervalFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void enterIntervalValue(SqlBaseParser.IntervalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void exitIntervalValue(SqlBaseParser.IntervalValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(SqlBaseParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(SqlBaseParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(SqlBaseParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(SqlBaseParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigIntLiteral(SqlBaseParser.BigIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigIntLiteral(SqlBaseParser.BigIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterSmallIntLiteral(SqlBaseParser.SmallIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitSmallIntLiteral(SqlBaseParser.SmallIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterTinyIntLiteral(SqlBaseParser.TinyIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitTinyIntLiteral(SqlBaseParser.TinyIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(SqlBaseParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(SqlBaseParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigDecimalLiteral(SqlBaseParser.BigDecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigDecimalLiteral(SqlBaseParser.BigDecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SqlBaseParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SqlBaseParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link SqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifierAlternative(SqlBaseParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link SqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifierAlternative(SqlBaseParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(SqlBaseParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(SqlBaseParser.QuotedIdentifierContext ctx);
}