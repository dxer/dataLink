// Generated from E:/work/SparkETL/src/main/antlr4/io/dxer/etl/sql/parser\SqlBase.g4 by ANTLR 4.7
package io.dxer.etl.sql.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlBaseParser}.
 */
public interface SqlBaseListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SqlBaseParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SqlBaseParser.StatementContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#fileOper}.
	 * @param ctx the parse tree
	 */
	void enterFileOper(SqlBaseParser.FileOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#fileOper}.
	 * @param ctx the parse tree
	 */
	void exitFileOper(SqlBaseParser.FileOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#connectStatement}.
	 * @param ctx the parse tree
	 */
	void enterConnectStatement(SqlBaseParser.ConnectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#connectStatement}.
	 * @param ctx the parse tree
	 */
	void exitConnectStatement(SqlBaseParser.ConnectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#loadTable}.
	 * @param ctx the parse tree
	 */
	void enterLoadTable(SqlBaseParser.LoadTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#loadTable}.
	 * @param ctx the parse tree
	 */
	void exitLoadTable(SqlBaseParser.LoadTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#save}.
	 * @param ctx the parse tree
	 */
	void enterSave(SqlBaseParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#save}.
	 * @param ctx the parse tree
	 */
	void exitSave(SqlBaseParser.SaveContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#queryAsTable}.
	 * @param ctx the parse tree
	 */
	void enterQueryAsTable(SqlBaseParser.QueryAsTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#queryAsTable}.
	 * @param ctx the parse tree
	 */
	void exitQueryAsTable(SqlBaseParser.QueryAsTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertInto(SqlBaseParser.InsertIntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertInto(SqlBaseParser.InsertIntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#insertIntoStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertIntoStatement(SqlBaseParser.InsertIntoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#insertIntoStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertIntoStatement(SqlBaseParser.InsertIntoStatementContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#execStatement}.
	 * @param ctx the parse tree
	 */
	void enterExecStatement(SqlBaseParser.ExecStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#execStatement}.
	 * @param ctx the parse tree
	 */
	void exitExecStatement(SqlBaseParser.ExecStatementContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 */
	void enterPartitionSpecLocation(SqlBaseParser.PartitionSpecLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 */
	void exitPartitionSpecLocation(SqlBaseParser.PartitionSpecLocationContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#locationSpec}.
	 * @param ctx the parse tree
	 */
	void enterLocationSpec(SqlBaseParser.LocationSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#locationSpec}.
	 * @param ctx the parse tree
	 */
	void exitLocationSpec(SqlBaseParser.LocationSpecContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#ender}.
	 * @param ctx the parse tree
	 */
	void enterEnder(SqlBaseParser.EnderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#ender}.
	 * @param ctx the parse tree
	 */
	void exitEnder(SqlBaseParser.EnderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicStringLiteral}
	 * labeled alternative in {@link SqlBaseParser#string}.
	 * @param ctx the parse tree
	 */
	void enterBasicStringLiteral(SqlBaseParser.BasicStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicStringLiteral}
	 * labeled alternative in {@link SqlBaseParser#string}.
	 * @param ctx the parse tree
	 */
	void exitBasicStringLiteral(SqlBaseParser.BasicStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unicodeStringLiteral}
	 * labeled alternative in {@link SqlBaseParser#string}.
	 * @param ctx the parse tree
	 */
	void enterUnicodeStringLiteral(SqlBaseParser.UnicodeStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unicodeStringLiteral}
	 * labeled alternative in {@link SqlBaseParser#string}.
	 * @param ctx the parse tree
	 */
	void exitUnicodeStringLiteral(SqlBaseParser.UnicodeStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(SqlBaseParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(SqlBaseParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(SqlBaseParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(SqlBaseParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code backQuotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterBackQuotedIdentifier(SqlBaseParser.BackQuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code backQuotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitBackQuotedIdentifier(SqlBaseParser.BackQuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code digitIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterDigitIdentifier(SqlBaseParser.DigitIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code digitIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitDigitIdentifier(SqlBaseParser.DigitIdentifierContext ctx);
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
	 * Enter a parse tree produced by {@link SqlBaseParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void enterNonReserved(SqlBaseParser.NonReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void exitNonReserved(SqlBaseParser.NonReservedContext ctx);
}