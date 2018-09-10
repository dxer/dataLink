// Generated from E:/work/github/SparkETL/src/main/antlr4/io/dxer/etl/sql/parser\SqlBase.g4 by ANTLR 4.7
package io.dxer.etl.sql.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlBaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlBaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#singleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(SqlBaseParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExpression(SqlBaseParser.SingleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SqlBaseParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SqlBaseParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#fileOper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileOper(SqlBaseParser.FileOperContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#connectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectStatement(SqlBaseParser.ConnectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#loadTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadTable(SqlBaseParser.LoadTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#save}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave(SqlBaseParser.SaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(SqlBaseParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#queryAsTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryAsTable(SqlBaseParser.QueryAsTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertInto(SqlBaseParser.InsertIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#insertIntoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertIntoStatement(SqlBaseParser.InsertIntoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(SqlBaseParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(SqlBaseParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#execStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecStatement(SqlBaseParser.ExecStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(SqlBaseParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(SqlBaseParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#propertyKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyKey(SqlBaseParser.PropertyKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#propertyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyValue(SqlBaseParser.PropertyValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionSpecLocation(SqlBaseParser.PartitionSpecLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#partitionSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionSpec(SqlBaseParser.PartitionSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#partitionVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionVal(SqlBaseParser.PartitionValContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#locationSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationSpec(SqlBaseParser.LocationSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(SqlBaseParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(SqlBaseParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstructor(SqlBaseParser.TypeConstructorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(SqlBaseParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(SqlBaseParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SqlBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SqlBaseParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval(SqlBaseParser.IntervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#intervalField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalField(SqlBaseParser.IntervalFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#intervalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalValue(SqlBaseParser.IntervalValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(SqlBaseParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#ender}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnder(SqlBaseParser.EnderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicStringLiteral}
	 * labeled alternative in {@link SqlBaseParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicStringLiteral(SqlBaseParser.BasicStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unicodeStringLiteral}
	 * labeled alternative in {@link SqlBaseParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnicodeStringLiteral(SqlBaseParser.UnicodeStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(SqlBaseParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedIdentifier(SqlBaseParser.QuotedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code backQuotedIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackQuotedIdentifier(SqlBaseParser.BackQuotedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code digitIdentifier}
	 * labeled alternative in {@link SqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigitIdentifier(SqlBaseParser.DigitIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(SqlBaseParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteral(SqlBaseParser.DoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SqlBaseParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(SqlBaseParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#nonReserved}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonReserved(SqlBaseParser.NonReservedContext ctx);
}