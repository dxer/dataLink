// Generated from E:/work/github/spark-etl/src/main/antlr4/io/dxer/etl/sql/parser\SqlBase.g4 by ANTLR 4.7
package io.dxer.etl.sql.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, PUT=6, GET=7, OVERWRITE=8, LOAD=9, 
		SAVE=10, CONNECT=11, LOCATION=12, APPEND=13, ERROR_IF_EXISTS=14, IGNORE=15, 
		LOCAL=16, EXEC=17, ADD=18, ALL=19, ALTER=20, ANALYZE=21, AND=22, ANY=23, 
		ARRAY=24, AS=25, ASC=26, AT=27, BERNOULLI=28, BETWEEN=29, BY=30, CALL=31, 
		CASCADE=32, CASE=33, CAST=34, CATALOGS=35, COALESCE=36, COLUMN=37, COLUMNS=38, 
		COMMENT=39, COMMIT=40, COMMITTED=41, CONSTRAINT=42, CREATE=43, CROSS=44, 
		CUBE=45, CURRENT=46, CURRENT_DATE=47, CURRENT_TIME=48, CURRENT_TIMESTAMP=49, 
		DATA=50, DATE=51, DAY=52, DEALLOCATE=53, DELETE=54, DESC=55, DESCRIBE=56, 
		DISTINCT=57, DISTRIBUTED=58, DROP=59, ELSE=60, END=61, ESCAPE=62, EXCEPT=63, 
		EXCLUDING=64, EXECUTE=65, EXISTS=66, EXPLAIN=67, EXTRACT=68, FALSE=69, 
		FILTER=70, FIRST=71, FOLLOWING=72, FOR=73, FORMAT=74, FROM=75, FULL=76, 
		FUNCTIONS=77, GRANT=78, GRANTS=79, GRAPHVIZ=80, GROUP=81, GROUPING=82, 
		HAVING=83, HOUR=84, IF=85, IN=86, INCLUDING=87, INNER=88, INPUT=89, INSERT=90, 
		INTEGER=91, INTERSECT=92, INTERVAL=93, INTO=94, IS=95, ISOLATION=96, JOIN=97, 
		LAST=98, LATERAL=99, LEFT=100, LEVEL=101, LIKE=102, LIMIT=103, LOCALTIME=104, 
		LOCALTIMESTAMP=105, LOGICAL=106, MAP=107, MINUTE=108, MONTH=109, NATURAL=110, 
		NFC=111, NFD=112, NFKC=113, NFKD=114, NO=115, NORMALIZE=116, NOT=117, 
		NULL=118, NULLIF=119, NULLS=120, ON=121, ONLY=122, OPTION=123, OR=124, 
		ORDER=125, ORDINALITY=126, OUTER=127, OUTPUT=128, OVER=129, PARTITION=130, 
		PARTITIONS=131, POSITION=132, PRECEDING=133, PREPARE=134, PRIVILEGES=135, 
		PROPERTIES=136, PUBLIC=137, RANGE=138, READ=139, RECURSIVE=140, RENAME=141, 
		REPEATABLE=142, REPLACE=143, RESET=144, RESTRICT=145, REVOKE=146, RIGHT=147, 
		ROLLBACK=148, ROLLUP=149, ROW=150, ROWS=151, SCHEMA=152, SCHEMAS=153, 
		SECOND=154, SELECT=155, SERIALIZABLE=156, SESSION=157, SET=158, SETS=159, 
		SHOW=160, SMALLINT=161, SOME=162, START=163, STATS=164, SUBSTRING=165, 
		SYSTEM=166, TABLE=167, TABLES=168, TABLESAMPLE=169, TEXT=170, THEN=171, 
		TIME=172, TIMESTAMP=173, TINYINT=174, TO=175, TRANSACTION=176, TRUE=177, 
		TRY_CAST=178, TYPE=179, UESCAPE=180, UNBOUNDED=181, UNCOMMITTED=182, UNION=183, 
		UNNEST=184, USE=185, USING=186, VALIDATE=187, VALUES=188, VERBOSE=189, 
		VIEW=190, WHEN=191, WHERE=192, WITH=193, WORK=194, WRITE=195, YEAR=196, 
		ZONE=197, EQ=198, NEQ=199, LT=200, LTE=201, GT=202, GTE=203, PLUS=204, 
		MINUS=205, ASTERISK=206, SLASH=207, PERCENT=208, CONCAT=209, STRING=210, 
		UNICODE_STRING=211, BINARY_LITERAL=212, INTEGER_VALUE=213, DECIMAL_VALUE=214, 
		DOUBLE_VALUE=215, IDENTIFIER=216, DIGIT_IDENTIFIER=217, QUOTED_IDENTIFIER=218, 
		BACKQUOTED_IDENTIFIER=219, TIME_WITH_TIME_ZONE=220, TIMESTAMP_WITH_TIME_ZONE=221, 
		DOUBLE_PRECISION=222, SIMPLE_COMMENT=223, BRACKETED_COMMENT=224, WS=225, 
		UNRECOGNIZED=226, DELIMITER=227;
	public static final int
		RULE_singleStatement = 0, RULE_singleExpression = 1, RULE_statement = 2, 
		RULE_expression = 3, RULE_fileOper = 4, RULE_connectStatement = 5, RULE_loadTable = 6, 
		RULE_save = 7, RULE_query = 8, RULE_queryAsTable = 9, RULE_insertInto = 10, 
		RULE_insertIntoStatement = 11, RULE_path = 12, RULE_format = 13, RULE_execStatement = 14, 
		RULE_properties = 15, RULE_property = 16, RULE_propertyKey = 17, RULE_propertyValue = 18, 
		RULE_partitionSpecLocation = 19, RULE_partitionSpec = 20, RULE_partitionVal = 21, 
		RULE_locationSpec = 22, RULE_constant = 23, RULE_interval = 24, RULE_intervalField = 25, 
		RULE_intervalValue = 26, RULE_booleanValue = 27, RULE_ender = 28, RULE_string = 29, 
		RULE_qualifiedName = 30, RULE_identifier = 31, RULE_number = 32, RULE_nonReserved = 33;
	public static final String[] ruleNames = {
		"singleStatement", "singleExpression", "statement", "expression", "fileOper", 
		"connectStatement", "loadTable", "save", "query", "queryAsTable", "insertInto", 
		"insertIntoStatement", "path", "format", "execStatement", "properties", 
		"property", "propertyKey", "propertyValue", "partitionSpecLocation", "partitionSpec", 
		"partitionVal", "locationSpec", "constant", "interval", "intervalField", 
		"intervalValue", "booleanValue", "ender", "string", "qualifiedName", "identifier", 
		"number", "nonReserved"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "'('", "','", "')'", "'PUT'", "'GET'", "'OVERWRITE'", 
		"'LOAD'", "'SAVE'", "'CONNECT'", "'LOCATION'", "'APPEND'", "'ERROR_IF_EXISTS'", 
		"'IGNORE'", "'LOCAL'", "'EXEC'", "'ADD'", "'ALL'", "'ALTER'", "'ANALYZE'", 
		"'AND'", "'ANY'", "'ARRAY'", "'AS'", "'ASC'", "'AT'", "'BERNOULLI'", "'BETWEEN'", 
		"'BY'", "'CALL'", "'CASCADE'", "'CASE'", "'CAST'", "'CATALOGS'", "'COALESCE'", 
		"'COLUMN'", "'COLUMNS'", "'COMMENT'", "'COMMIT'", "'COMMITTED'", "'CONSTRAINT'", 
		"'CREATE'", "'CROSS'", "'CUBE'", "'CURRENT'", "'CURRENT_DATE'", "'CURRENT_TIME'", 
		"'CURRENT_TIMESTAMP'", "'DATA'", "'DATE'", "'DAY'", "'DEALLOCATE'", "'DELETE'", 
		"'DESC'", "'DESCRIBE'", "'DISTINCT'", "'DISTRIBUTED'", "'DROP'", "'ELSE'", 
		"'END'", "'ESCAPE'", "'EXCEPT'", "'EXCLUDING'", "'EXECUTE'", "'EXISTS'", 
		"'EXPLAIN'", "'EXTRACT'", "'FALSE'", "'FILTER'", "'FIRST'", "'FOLLOWING'", 
		"'FOR'", "'FORMAT'", "'FROM'", "'FULL'", "'FUNCTIONS'", "'GRANT'", "'GRANTS'", 
		"'GRAPHVIZ'", "'GROUP'", "'GROUPING'", "'HAVING'", "'HOUR'", "'IF'", "'IN'", 
		"'INCLUDING'", "'INNER'", "'INPUT'", "'INSERT'", "'INTEGER'", "'INTERSECT'", 
		"'INTERVAL'", "'INTO'", "'IS'", "'ISOLATION'", "'JOIN'", "'LAST'", "'LATERAL'", 
		"'LEFT'", "'LEVEL'", "'LIKE'", "'LIMIT'", "'LOCALTIME'", "'LOCALTIMESTAMP'", 
		"'LOGICAL'", "'MAP'", "'MINUTE'", "'MONTH'", "'NATURAL'", "'NFC'", "'NFD'", 
		"'NFKC'", "'NFKD'", "'NO'", "'NORMALIZE'", "'NOT'", "'NULL'", "'NULLIF'", 
		"'NULLS'", "'ON'", "'ONLY'", "'OPTION'", "'OR'", "'ORDER'", "'ORDINALITY'", 
		"'OUTER'", "'OUTPUT'", "'OVER'", "'PARTITION'", "'PARTITIONS'", "'POSITION'", 
		"'PRECEDING'", "'PREPARE'", "'PRIVILEGES'", "'PROPERTIES'", "'PUBLIC'", 
		"'RANGE'", "'READ'", "'RECURSIVE'", "'RENAME'", "'REPEATABLE'", "'REPLACE'", 
		"'RESET'", "'RESTRICT'", "'REVOKE'", "'RIGHT'", "'ROLLBACK'", "'ROLLUP'", 
		"'ROW'", "'ROWS'", "'SCHEMA'", "'SCHEMAS'", "'SECOND'", "'SELECT'", "'SERIALIZABLE'", 
		"'SESSION'", "'SET'", "'SETS'", "'SHOW'", "'SMALLINT'", "'SOME'", "'START'", 
		"'STATS'", "'SUBSTRING'", "'SYSTEM'", "'TABLE'", "'TABLES'", "'TABLESAMPLE'", 
		"'TEXT'", "'THEN'", "'TIME'", "'TIMESTAMP'", "'TINYINT'", "'TO'", "'TRANSACTION'", 
		"'TRUE'", "'TRY_CAST'", "'TYPE'", "'UESCAPE'", "'UNBOUNDED'", "'UNCOMMITTED'", 
		"'UNION'", "'UNNEST'", "'USE'", "'USING'", "'VALIDATE'", "'VALUES'", "'VERBOSE'", 
		"'VIEW'", "'WHEN'", "'WHERE'", "'WITH'", "'WORK'", "'WRITE'", "'YEAR'", 
		"'ZONE'", "'='", null, "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "PUT", "GET", "OVERWRITE", "LOAD", 
		"SAVE", "CONNECT", "LOCATION", "APPEND", "ERROR_IF_EXISTS", "IGNORE", 
		"LOCAL", "EXEC", "ADD", "ALL", "ALTER", "ANALYZE", "AND", "ANY", "ARRAY", 
		"AS", "ASC", "AT", "BERNOULLI", "BETWEEN", "BY", "CALL", "CASCADE", "CASE", 
		"CAST", "CATALOGS", "COALESCE", "COLUMN", "COLUMNS", "COMMENT", "COMMIT", 
		"COMMITTED", "CONSTRAINT", "CREATE", "CROSS", "CUBE", "CURRENT", "CURRENT_DATE", 
		"CURRENT_TIME", "CURRENT_TIMESTAMP", "DATA", "DATE", "DAY", "DEALLOCATE", 
		"DELETE", "DESC", "DESCRIBE", "DISTINCT", "DISTRIBUTED", "DROP", "ELSE", 
		"END", "ESCAPE", "EXCEPT", "EXCLUDING", "EXECUTE", "EXISTS", "EXPLAIN", 
		"EXTRACT", "FALSE", "FILTER", "FIRST", "FOLLOWING", "FOR", "FORMAT", "FROM", 
		"FULL", "FUNCTIONS", "GRANT", "GRANTS", "GRAPHVIZ", "GROUP", "GROUPING", 
		"HAVING", "HOUR", "IF", "IN", "INCLUDING", "INNER", "INPUT", "INSERT", 
		"INTEGER", "INTERSECT", "INTERVAL", "INTO", "IS", "ISOLATION", "JOIN", 
		"LAST", "LATERAL", "LEFT", "LEVEL", "LIKE", "LIMIT", "LOCALTIME", "LOCALTIMESTAMP", 
		"LOGICAL", "MAP", "MINUTE", "MONTH", "NATURAL", "NFC", "NFD", "NFKC", 
		"NFKD", "NO", "NORMALIZE", "NOT", "NULL", "NULLIF", "NULLS", "ON", "ONLY", 
		"OPTION", "OR", "ORDER", "ORDINALITY", "OUTER", "OUTPUT", "OVER", "PARTITION", 
		"PARTITIONS", "POSITION", "PRECEDING", "PREPARE", "PRIVILEGES", "PROPERTIES", 
		"PUBLIC", "RANGE", "READ", "RECURSIVE", "RENAME", "REPEATABLE", "REPLACE", 
		"RESET", "RESTRICT", "REVOKE", "RIGHT", "ROLLBACK", "ROLLUP", "ROW", "ROWS", 
		"SCHEMA", "SCHEMAS", "SECOND", "SELECT", "SERIALIZABLE", "SESSION", "SET", 
		"SETS", "SHOW", "SMALLINT", "SOME", "START", "STATS", "SUBSTRING", "SYSTEM", 
		"TABLE", "TABLES", "TABLESAMPLE", "TEXT", "THEN", "TIME", "TIMESTAMP", 
		"TINYINT", "TO", "TRANSACTION", "TRUE", "TRY_CAST", "TYPE", "UESCAPE", 
		"UNBOUNDED", "UNCOMMITTED", "UNION", "UNNEST", "USE", "USING", "VALIDATE", 
		"VALUES", "VERBOSE", "VIEW", "WHEN", "WHERE", "WITH", "WORK", "WRITE", 
		"YEAR", "ZONE", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "PERCENT", "CONCAT", "STRING", "UNICODE_STRING", 
		"BINARY_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_VALUE", "IDENTIFIER", 
		"DIGIT_IDENTIFIER", "QUOTED_IDENTIFIER", "BACKQUOTED_IDENTIFIER", "TIME_WITH_TIME_ZONE", 
		"TIMESTAMP_WITH_TIME_ZONE", "DOUBLE_PRECISION", "SIMPLE_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED", "DELIMITER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			statement();
			setState(69);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSingleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSingleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			expression();
			setState(72);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public FileOperContext fileOper() {
			return getRuleContext(FileOperContext.class,0);
		}
		public ConnectStatementContext connectStatement() {
			return getRuleContext(ConnectStatementContext.class,0);
		}
		public LoadTableContext loadTable() {
			return getRuleContext(LoadTableContext.class,0);
		}
		public SaveContext save() {
			return getRuleContext(SaveContext.class,0);
		}
		public QueryAsTableContext queryAsTable() {
			return getRuleContext(QueryAsTableContext.class,0);
		}
		public InsertIntoStatementContext insertIntoStatement() {
			return getRuleContext(InsertIntoStatementContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExecStatementContext execStatement() {
			return getRuleContext(ExecStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				fileOper();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				connectStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				loadTable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				save();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				queryAsTable();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				insertIntoStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				query();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				execStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileOperContext extends ParserRuleContext {
		public Token operType;
		public PathContext src;
		public PathContext dst;
		public List<PathContext> path() {
			return getRuleContexts(PathContext.class);
		}
		public PathContext path(int i) {
			return getRuleContext(PathContext.class,i);
		}
		public TerminalNode PUT() { return getToken(SqlBaseParser.PUT, 0); }
		public TerminalNode GET() { return getToken(SqlBaseParser.GET, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlBaseParser.OVERWRITE, 0); }
		public TerminalNode DELETE() { return getToken(SqlBaseParser.DELETE, 0); }
		public FileOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileOper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFileOper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFileOper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFileOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileOperContext fileOper() throws RecognitionException {
		FileOperContext _localctx = new FileOperContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fileOper);
		int _la;
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PUT:
			case GET:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				((FileOperContext)_localctx).operType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PUT || _la==GET) ) {
					((FileOperContext)_localctx).operType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				((FileOperContext)_localctx).src = path();
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(88);
					_la = _input.LA(1);
					if ( !(_la==OVERWRITE || _la==TO) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(91);
				((FileOperContext)_localctx).dst = path();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				((FileOperContext)_localctx).operType = match(DELETE);
				setState(94);
				((FileOperContext)_localctx).src = path();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConnectStatementContext extends ParserRuleContext {
		public Token conn;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode CONNECT() { return getToken(SqlBaseParser.CONNECT, 0); }
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SqlBaseParser.IDENTIFIER, 0); }
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public ConnectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterConnectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitConnectStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitConnectStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnectStatementContext connectStatement() throws RecognitionException {
		ConnectStatementContext _localctx = new ConnectStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_connectStatement);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(CREATE);
				setState(98);
				match(CONNECT);
				setState(99);
				((ConnectStatementContext)_localctx).conn = match(IDENTIFIER);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(100);
					match(WITH);
					}
				}

				setState(103);
				properties();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(DROP);
				setState(105);
				match(CONNECT);
				setState(106);
				((ConnectStatementContext)_localctx).conn = match(IDENTIFIER);
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(SHOW);
				setState(108);
				match(CONNECT);
				setState(109);
				((ConnectStatementContext)_localctx).conn = match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadTableContext extends ParserRuleContext {
		public QualifiedNameContext tableName;
		public TerminalNode LOAD() { return getToken(SqlBaseParser.LOAD, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode LOCAL() { return getToken(SqlBaseParser.LOCAL, 0); }
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public LoadTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLoadTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLoadTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLoadTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadTableContext loadTable() throws RecognitionException {
		LoadTableContext _localctx = new LoadTableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_loadTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(LOAD);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL) {
				{
				setState(113);
				match(LOCAL);
				}
			}

			setState(116);
			format();
			setState(117);
			match(T__0);
			setState(118);
			path();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(119);
				match(WITH);
				setState(120);
				properties();
				}
			}

			setState(123);
			match(AS);
			setState(124);
			((LoadTableContext)_localctx).tableName = qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SaveContext extends ParserRuleContext {
		public Token saveMode;
		public QualifiedNameContext tableName;
		public TerminalNode SAVE() { return getToken(SqlBaseParser.SAVE, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public TerminalNode OVERWRITE() { return getToken(SqlBaseParser.OVERWRITE, 0); }
		public TerminalNode APPEND() { return getToken(SqlBaseParser.APPEND, 0); }
		public TerminalNode ERROR_IF_EXISTS() { return getToken(SqlBaseParser.ERROR_IF_EXISTS, 0); }
		public TerminalNode IGNORE() { return getToken(SqlBaseParser.IGNORE, 0); }
		public SaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_save; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSave(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveContext save() throws RecognitionException {
		SaveContext _localctx = new SaveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_save);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(SAVE);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERROR_IF_EXISTS) | (1L << IGNORE))) != 0)) {
				{
				setState(127);
				((SaveContext)_localctx).saveMode = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERROR_IF_EXISTS) | (1L << IGNORE))) != 0)) ) {
					((SaveContext)_localctx).saveMode = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(130);
			((SaveContext)_localctx).tableName = qualifiedName();
			setState(131);
			match(AS);
			setState(132);
			format();
			setState(133);
			match(T__0);
			setState(134);
			path();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(135);
				partitionSpec();
				}
			}

			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(138);
				match(WITH);
				setState(139);
				properties();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(SELECT);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << PUT) | (1L << GET) | (1L << OVERWRITE) | (1L << LOAD) | (1L << SAVE) | (1L << CONNECT) | (1L << LOCATION) | (1L << APPEND) | (1L << ERROR_IF_EXISTS) | (1L << IGNORE) | (1L << LOCAL) | (1L << EXEC) | (1L << ADD) | (1L << ALL) | (1L << ALTER) | (1L << ANALYZE) | (1L << AND) | (1L << ANY) | (1L << ARRAY) | (1L << AS) | (1L << ASC) | (1L << AT) | (1L << BERNOULLI) | (1L << BETWEEN) | (1L << BY) | (1L << CALL) | (1L << CASCADE) | (1L << CASE) | (1L << CAST) | (1L << CATALOGS) | (1L << COALESCE) | (1L << COLUMN) | (1L << COLUMNS) | (1L << COMMENT) | (1L << COMMIT) | (1L << COMMITTED) | (1L << CONSTRAINT) | (1L << CREATE) | (1L << CROSS) | (1L << CUBE) | (1L << CURRENT) | (1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP) | (1L << DATA) | (1L << DATE) | (1L << DAY) | (1L << DEALLOCATE) | (1L << DELETE) | (1L << DESC) | (1L << DESCRIBE) | (1L << DISTINCT) | (1L << DISTRIBUTED) | (1L << DROP) | (1L << ELSE) | (1L << END) | (1L << ESCAPE) | (1L << EXCEPT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (EXCLUDING - 64)) | (1L << (EXECUTE - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (EXTRACT - 64)) | (1L << (FALSE - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FOLLOWING - 64)) | (1L << (FOR - 64)) | (1L << (FORMAT - 64)) | (1L << (FROM - 64)) | (1L << (FULL - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (GRANT - 64)) | (1L << (GRANTS - 64)) | (1L << (GRAPHVIZ - 64)) | (1L << (GROUP - 64)) | (1L << (GROUPING - 64)) | (1L << (HAVING - 64)) | (1L << (HOUR - 64)) | (1L << (IF - 64)) | (1L << (IN - 64)) | (1L << (INCLUDING - 64)) | (1L << (INNER - 64)) | (1L << (INPUT - 64)) | (1L << (INSERT - 64)) | (1L << (INTEGER - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTERVAL - 64)) | (1L << (INTO - 64)) | (1L << (IS - 64)) | (1L << (ISOLATION - 64)) | (1L << (JOIN - 64)) | (1L << (LAST - 64)) | (1L << (LATERAL - 64)) | (1L << (LEFT - 64)) | (1L << (LEVEL - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCALTIME - 64)) | (1L << (LOCALTIMESTAMP - 64)) | (1L << (LOGICAL - 64)) | (1L << (MAP - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATURAL - 64)) | (1L << (NFC - 64)) | (1L << (NFD - 64)) | (1L << (NFKC - 64)) | (1L << (NFKD - 64)) | (1L << (NO - 64)) | (1L << (NORMALIZE - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (NULLIF - 64)) | (1L << (NULLS - 64)) | (1L << (ON - 64)) | (1L << (ONLY - 64)) | (1L << (OPTION - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (ORDINALITY - 64)) | (1L << (OUTER - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (OUTPUT - 128)) | (1L << (OVER - 128)) | (1L << (PARTITION - 128)) | (1L << (PARTITIONS - 128)) | (1L << (POSITION - 128)) | (1L << (PRECEDING - 128)) | (1L << (PREPARE - 128)) | (1L << (PRIVILEGES - 128)) | (1L << (PROPERTIES - 128)) | (1L << (PUBLIC - 128)) | (1L << (RANGE - 128)) | (1L << (READ - 128)) | (1L << (RECURSIVE - 128)) | (1L << (RENAME - 128)) | (1L << (REPEATABLE - 128)) | (1L << (REPLACE - 128)) | (1L << (RESET - 128)) | (1L << (RESTRICT - 128)) | (1L << (REVOKE - 128)) | (1L << (RIGHT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (ROLLUP - 128)) | (1L << (ROW - 128)) | (1L << (ROWS - 128)) | (1L << (SCHEMA - 128)) | (1L << (SCHEMAS - 128)) | (1L << (SECOND - 128)) | (1L << (SELECT - 128)) | (1L << (SERIALIZABLE - 128)) | (1L << (SESSION - 128)) | (1L << (SET - 128)) | (1L << (SETS - 128)) | (1L << (SHOW - 128)) | (1L << (SMALLINT - 128)) | (1L << (SOME - 128)) | (1L << (START - 128)) | (1L << (STATS - 128)) | (1L << (SUBSTRING - 128)) | (1L << (SYSTEM - 128)) | (1L << (TABLE - 128)) | (1L << (TABLES - 128)) | (1L << (TABLESAMPLE - 128)) | (1L << (TEXT - 128)) | (1L << (THEN - 128)) | (1L << (TIME - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TINYINT - 128)) | (1L << (TO - 128)) | (1L << (TRANSACTION - 128)) | (1L << (TRUE - 128)) | (1L << (TRY_CAST - 128)) | (1L << (TYPE - 128)) | (1L << (UESCAPE - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (UNCOMMITTED - 128)) | (1L << (UNION - 128)) | (1L << (UNNEST - 128)) | (1L << (USE - 128)) | (1L << (USING - 128)) | (1L << (VALIDATE - 128)) | (1L << (VALUES - 128)) | (1L << (VERBOSE - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (WHERE - 192)) | (1L << (WITH - 192)) | (1L << (WORK - 192)) | (1L << (WRITE - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (EQ - 192)) | (1L << (NEQ - 192)) | (1L << (LT - 192)) | (1L << (LTE - 192)) | (1L << (GT - 192)) | (1L << (GTE - 192)) | (1L << (PLUS - 192)) | (1L << (MINUS - 192)) | (1L << (ASTERISK - 192)) | (1L << (SLASH - 192)) | (1L << (PERCENT - 192)) | (1L << (CONCAT - 192)) | (1L << (STRING - 192)) | (1L << (UNICODE_STRING - 192)) | (1L << (BINARY_LITERAL - 192)) | (1L << (INTEGER_VALUE - 192)) | (1L << (DECIMAL_VALUE - 192)) | (1L << (DOUBLE_VALUE - 192)) | (1L << (IDENTIFIER - 192)) | (1L << (DIGIT_IDENTIFIER - 192)) | (1L << (QUOTED_IDENTIFIER - 192)) | (1L << (BACKQUOTED_IDENTIFIER - 192)) | (1L << (TIME_WITH_TIME_ZONE - 192)) | (1L << (TIMESTAMP_WITH_TIME_ZONE - 192)) | (1L << (DOUBLE_PRECISION - 192)) | (1L << (SIMPLE_COMMENT - 192)) | (1L << (BRACKETED_COMMENT - 192)) | (1L << (WS - 192)) | (1L << (UNRECOGNIZED - 192)) | (1L << (DELIMITER - 192)))) != 0)) {
				{
				{
				setState(143);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryAsTableContext extends ParserRuleContext {
		public IdentifierContext tableName;
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QueryAsTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryAsTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQueryAsTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQueryAsTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQueryAsTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryAsTableContext queryAsTable() throws RecognitionException {
		QueryAsTableContext _localctx = new QueryAsTableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_queryAsTable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(SELECT);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(150);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==T__1) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(156);
			match(AS);
			setState(157);
			((QueryAsTableContext)_localctx).tableName = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertIntoContext extends ParserRuleContext {
		public Token saveMode;
		public TerminalNode INSERT() { return getToken(SqlBaseParser.INSERT, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode LOCAL() { return getToken(SqlBaseParser.LOCAL, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public TerminalNode OVERWRITE() { return getToken(SqlBaseParser.OVERWRITE, 0); }
		public TerminalNode APPEND() { return getToken(SqlBaseParser.APPEND, 0); }
		public TerminalNode ERROR_IF_EXISTS() { return getToken(SqlBaseParser.ERROR_IF_EXISTS, 0); }
		public TerminalNode IGNORE() { return getToken(SqlBaseParser.IGNORE, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public InsertIntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertInto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInsertInto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInsertInto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInsertInto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertIntoContext insertInto() throws RecognitionException {
		InsertIntoContext _localctx = new InsertIntoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_insertInto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(INSERT);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERROR_IF_EXISTS) | (1L << IGNORE))) != 0) || _la==INTO) {
				{
				setState(160);
				((InsertIntoContext)_localctx).saveMode = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERROR_IF_EXISTS) | (1L << IGNORE))) != 0) || _la==INTO) ) {
					((InsertIntoContext)_localctx).saveMode = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL) {
				{
				setState(163);
				match(LOCAL);
				}
			}

			setState(166);
			format();
			setState(167);
			match(T__0);
			setState(168);
			path();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(169);
				partitionSpec();
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(170);
					match(IF);
					setState(171);
					match(NOT);
					setState(172);
					match(EXISTS);
					}
				}

				}
			}

			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(177);
				match(WITH);
				setState(178);
				properties();
				}
			}

			setState(181);
			match(FROM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertIntoStatementContext extends ParserRuleContext {
		public QualifiedNameContext tableName;
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public InsertIntoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertIntoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInsertIntoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInsertIntoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInsertIntoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertIntoStatementContext insertIntoStatement() throws RecognitionException {
		InsertIntoStatementContext _localctx = new InsertIntoStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_insertIntoStatement);
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				insertInto();
				setState(184);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				insertInto();
				setState(187);
				((InsertIntoStatementContext)_localctx).tableName = qualifiedName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_path);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(BACKQUOTED_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormatContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormatContext format() throws RecognitionException {
		FormatContext _localctx = new FormatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_format);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExecStatementContext extends ParserRuleContext {
		public Token command;
		public TerminalNode EXEC() { return getToken(SqlBaseParser.EXEC, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ExecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecStatementContext execStatement() throws RecognitionException {
		ExecStatementContext _localctx = new ExecStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_execStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(EXEC);
			setState(198);
			((ExecStatementContext)_localctx).command = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertiesContext extends ParserRuleContext {
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_properties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__2);
			setState(201);
			property();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(202);
				match(T__3);
				setState(203);
				property();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public PropertyKeyContext key;
		public PropertyValueContext value;
		public PropertyKeyContext propertyKey() {
			return getRuleContext(PropertyKeyContext.class,0);
		}
		public PropertyValueContext propertyValue() {
			return getRuleContext(PropertyValueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((PropertyContext)_localctx).key = propertyKey();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FALSE || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (TRUE - 177)) | (1L << (EQ - 177)) | (1L << (STRING - 177)) | (1L << (INTEGER_VALUE - 177)) | (1L << (DECIMAL_VALUE - 177)))) != 0)) {
				{
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(212);
					match(EQ);
					}
				}

				setState(215);
				((PropertyContext)_localctx).value = propertyValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyKeyContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public PropertyKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPropertyKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPropertyKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPropertyKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyKeyContext propertyKey() throws RecognitionException {
		PropertyKeyContext _localctx = new PropertyKeyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_propertyKey);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXPLAIN:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SERIALIZABLE:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRANSACTION:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				identifier();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(219);
					match(T__0);
					setState(220);
					identifier();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public PropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPropertyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPropertyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPropertyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyValueContext propertyValue() throws RecognitionException {
		PropertyValueContext _localctx = new PropertyValueContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_propertyValue);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(INTEGER_VALUE);
				}
				break;
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(DECIMAL_VALUE);
				}
				break;
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				booleanValue();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecLocationContext extends ParserRuleContext {
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public PartitionSpecLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpecLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPartitionSpecLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPartitionSpecLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPartitionSpecLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionSpecLocationContext partitionSpecLocation() throws RecognitionException {
		PartitionSpecLocationContext _localctx = new PartitionSpecLocationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_partitionSpecLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			partitionSpec();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCATION) {
				{
				setState(236);
				locationSpec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public List<PartitionValContext> partitionVal() {
			return getRuleContexts(PartitionValContext.class);
		}
		public PartitionValContext partitionVal(int i) {
			return getRuleContext(PartitionValContext.class,i);
		}
		public PartitionSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPartitionSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPartitionSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPartitionSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionSpecContext partitionSpec() throws RecognitionException {
		PartitionSpecContext _localctx = new PartitionSpecContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_partitionSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(PARTITION);
			setState(240);
			match(T__2);
			setState(241);
			partitionVal();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(242);
				match(T__3);
				setState(243);
				partitionVal();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionValContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public PartitionValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPartitionVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPartitionVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPartitionVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionValContext partitionVal() throws RecognitionException {
		PartitionValContext _localctx = new PartitionValContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_partitionVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			identifier();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(252);
				match(EQ);
				setState(253);
				constant();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationSpecContext extends ParserRuleContext {
		public TerminalNode LOCATION() { return getToken(SqlBaseParser.LOCATION, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public LocationSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLocationSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLocationSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLocationSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationSpecContext locationSpec() throws RecognitionException {
		LocationSpecContext _localctx = new LocationSpecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_locationSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(LOCATION);
			setState(257);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullLiteralContext extends ConstantContext {
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public NullLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ConstantContext {
		public List<TerminalNode> STRING() { return getTokens(SqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlBaseParser.STRING, i);
		}
		public StringLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeConstructorContext extends ConstantContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TypeConstructorContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTypeConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTypeConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalLiteralContext extends ConstantContext {
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public IntervalLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntervalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntervalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntervalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLiteralContext extends ConstantContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends ConstantContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constant);
		int _la;
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(NULL);
				}
				break;
			case 2:
				_localctx = new IntervalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				interval();
				}
				break;
			case 3:
				_localctx = new TypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				identifier();
				setState(262);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new NumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				number();
				}
				break;
			case 5:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				booleanValue();
				}
				break;
			case 6:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(266);
					match(STRING);
					}
					}
					setState(269); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STRING );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public List<IntervalFieldContext> intervalField() {
			return getRuleContexts(IntervalFieldContext.class);
		}
		public IntervalFieldContext intervalField(int i) {
			return getRuleContext(IntervalFieldContext.class,i);
		}
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_interval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(INTERVAL);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & ((1L << (PLUS - 204)) | (1L << (MINUS - 204)) | (1L << (STRING - 204)) | (1L << (INTEGER_VALUE - 204)) | (1L << (DECIMAL_VALUE - 204)))) != 0)) {
				{
				{
				setState(274);
				intervalField();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalFieldContext extends ParserRuleContext {
		public IntervalValueContext value;
		public IdentifierContext unit;
		public IdentifierContext to;
		public IntervalValueContext intervalValue() {
			return getRuleContext(IntervalValueContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public IntervalFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntervalField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntervalField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntervalField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalFieldContext intervalField() throws RecognitionException {
		IntervalFieldContext _localctx = new IntervalFieldContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_intervalField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			((IntervalFieldContext)_localctx).value = intervalValue();
			setState(281);
			((IntervalFieldContext)_localctx).unit = identifier();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(282);
				match(TO);
				setState(283);
				((IntervalFieldContext)_localctx).to = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public IntervalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntervalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntervalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntervalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalValueContext intervalValue() throws RecognitionException {
		IntervalValueContext _localctx = new IntervalValueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_intervalValue);
		int _la;
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(286);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(289);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SqlBaseParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SqlBaseParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnderContext extends ParserRuleContext {
		public EnderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ender; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterEnder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitEnder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitEnder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnderContext ender() throws RecognitionException {
		EnderContext _localctx = new EnderContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ender);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnicodeStringLiteralContext extends StringContext {
		public TerminalNode UNICODE_STRING() { return getToken(SqlBaseParser.UNICODE_STRING, 0); }
		public TerminalNode UESCAPE() { return getToken(SqlBaseParser.UESCAPE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public UnicodeStringLiteralContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnicodeStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnicodeStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnicodeStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicStringLiteralContext extends StringContext {
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public BasicStringLiteralContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBasicStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBasicStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBasicStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_string);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new BasicStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				match(STRING);
				}
				break;
			case UNICODE_STRING:
				_localctx = new UnicodeStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(UNICODE_STRING);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UESCAPE) {
					{
					setState(299);
					match(UESCAPE);
					setState(300);
					match(STRING);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			identifier();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(306);
				match(T__0);
				setState(307);
				identifier();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BackQuotedIdentifierContext extends IdentifierContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public BackQuotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBackQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBackQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBackQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuotedIdentifierContext extends IdentifierContext {
		public TerminalNode QUOTED_IDENTIFIER() { return getToken(SqlBaseParser.QUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DigitIdentifierContext extends IdentifierContext {
		public TerminalNode DIGIT_IDENTIFIER() { return getToken(SqlBaseParser.DIGIT_IDENTIFIER, 0); }
		public DigitIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDigitIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDigitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDigitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlBaseParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_identifier);
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(IDENTIFIER);
				}
				break;
			case QUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(QUOTED_IDENTIFIER);
				}
				break;
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXPLAIN:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SERIALIZABLE:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRANSACTION:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				nonReserved();
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new BackQuotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
				match(BACKQUOTED_IDENTIFIER);
				}
				break;
			case DIGIT_IDENTIFIER:
				_localctx = new DigitIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				match(DIGIT_IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleLiteralContext extends NumberContext {
		public TerminalNode DOUBLE_VALUE() { return getToken(SqlBaseParser.DOUBLE_VALUE, 0); }
		public DoubleLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_number);
		try {
			setState(323);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_VALUE:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				match(DECIMAL_VALUE);
				}
				break;
			case DOUBLE_VALUE:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(DOUBLE_VALUE);
				}
				break;
			case INTEGER_VALUE:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				match(INTEGER_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SqlBaseParser.ADD, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public TerminalNode ANALYZE() { return getToken(SqlBaseParser.ANALYZE, 0); }
		public TerminalNode ANY() { return getToken(SqlBaseParser.ANY, 0); }
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode AT() { return getToken(SqlBaseParser.AT, 0); }
		public TerminalNode BERNOULLI() { return getToken(SqlBaseParser.BERNOULLI, 0); }
		public TerminalNode CALL() { return getToken(SqlBaseParser.CALL, 0); }
		public TerminalNode CASCADE() { return getToken(SqlBaseParser.CASCADE, 0); }
		public TerminalNode CATALOGS() { return getToken(SqlBaseParser.CATALOGS, 0); }
		public TerminalNode COALESCE() { return getToken(SqlBaseParser.COALESCE, 0); }
		public TerminalNode COLUMN() { return getToken(SqlBaseParser.COLUMN, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode COMMIT() { return getToken(SqlBaseParser.COMMIT, 0); }
		public TerminalNode COMMITTED() { return getToken(SqlBaseParser.COMMITTED, 0); }
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public TerminalNode DATA() { return getToken(SqlBaseParser.DATA, 0); }
		public TerminalNode DATE() { return getToken(SqlBaseParser.DATE, 0); }
		public TerminalNode DAY() { return getToken(SqlBaseParser.DAY, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode DISTRIBUTED() { return getToken(SqlBaseParser.DISTRIBUTED, 0); }
		public TerminalNode EXCLUDING() { return getToken(SqlBaseParser.EXCLUDING, 0); }
		public TerminalNode EXPLAIN() { return getToken(SqlBaseParser.EXPLAIN, 0); }
		public TerminalNode FILTER() { return getToken(SqlBaseParser.FILTER, 0); }
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlBaseParser.FUNCTIONS, 0); }
		public TerminalNode GRANT() { return getToken(SqlBaseParser.GRANT, 0); }
		public TerminalNode GRANTS() { return getToken(SqlBaseParser.GRANTS, 0); }
		public TerminalNode GRAPHVIZ() { return getToken(SqlBaseParser.GRAPHVIZ, 0); }
		public TerminalNode HOUR() { return getToken(SqlBaseParser.HOUR, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode INCLUDING() { return getToken(SqlBaseParser.INCLUDING, 0); }
		public TerminalNode INPUT() { return getToken(SqlBaseParser.INPUT, 0); }
		public TerminalNode INTEGER() { return getToken(SqlBaseParser.INTEGER, 0); }
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public TerminalNode ISOLATION() { return getToken(SqlBaseParser.ISOLATION, 0); }
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public TerminalNode LATERAL() { return getToken(SqlBaseParser.LATERAL, 0); }
		public TerminalNode LEVEL() { return getToken(SqlBaseParser.LEVEL, 0); }
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public TerminalNode LOGICAL() { return getToken(SqlBaseParser.LOGICAL, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode MINUTE() { return getToken(SqlBaseParser.MINUTE, 0); }
		public TerminalNode MONTH() { return getToken(SqlBaseParser.MONTH, 0); }
		public TerminalNode NFC() { return getToken(SqlBaseParser.NFC, 0); }
		public TerminalNode NFD() { return getToken(SqlBaseParser.NFD, 0); }
		public TerminalNode NFKC() { return getToken(SqlBaseParser.NFKC, 0); }
		public TerminalNode NFKD() { return getToken(SqlBaseParser.NFKD, 0); }
		public TerminalNode NO() { return getToken(SqlBaseParser.NO, 0); }
		public TerminalNode NULLIF() { return getToken(SqlBaseParser.NULLIF, 0); }
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public TerminalNode ONLY() { return getToken(SqlBaseParser.ONLY, 0); }
		public TerminalNode OPTION() { return getToken(SqlBaseParser.OPTION, 0); }
		public TerminalNode ORDINALITY() { return getToken(SqlBaseParser.ORDINALITY, 0); }
		public TerminalNode OUTPUT() { return getToken(SqlBaseParser.OUTPUT, 0); }
		public TerminalNode OVER() { return getToken(SqlBaseParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlBaseParser.PARTITIONS, 0); }
		public TerminalNode POSITION() { return getToken(SqlBaseParser.POSITION, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode PRIVILEGES() { return getToken(SqlBaseParser.PRIVILEGES, 0); }
		public TerminalNode PROPERTIES() { return getToken(SqlBaseParser.PROPERTIES, 0); }
		public TerminalNode PUBLIC() { return getToken(SqlBaseParser.PUBLIC, 0); }
		public TerminalNode RANGE() { return getToken(SqlBaseParser.RANGE, 0); }
		public TerminalNode READ() { return getToken(SqlBaseParser.READ, 0); }
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode REPEATABLE() { return getToken(SqlBaseParser.REPEATABLE, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode RESET() { return getToken(SqlBaseParser.RESET, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlBaseParser.RESTRICT, 0); }
		public TerminalNode REVOKE() { return getToken(SqlBaseParser.REVOKE, 0); }
		public TerminalNode ROLLBACK() { return getToken(SqlBaseParser.ROLLBACK, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode SCHEMA() { return getToken(SqlBaseParser.SCHEMA, 0); }
		public TerminalNode SCHEMAS() { return getToken(SqlBaseParser.SCHEMAS, 0); }
		public TerminalNode SECOND() { return getToken(SqlBaseParser.SECOND, 0); }
		public TerminalNode SERIALIZABLE() { return getToken(SqlBaseParser.SERIALIZABLE, 0); }
		public TerminalNode SESSION() { return getToken(SqlBaseParser.SESSION, 0); }
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode SETS() { return getToken(SqlBaseParser.SETS, 0); }
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode SMALLINT() { return getToken(SqlBaseParser.SMALLINT, 0); }
		public TerminalNode SOME() { return getToken(SqlBaseParser.SOME, 0); }
		public TerminalNode START() { return getToken(SqlBaseParser.START, 0); }
		public TerminalNode STATS() { return getToken(SqlBaseParser.STATS, 0); }
		public TerminalNode SUBSTRING() { return getToken(SqlBaseParser.SUBSTRING, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlBaseParser.SYSTEM, 0); }
		public TerminalNode TABLES() { return getToken(SqlBaseParser.TABLES, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(SqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode TEXT() { return getToken(SqlBaseParser.TEXT, 0); }
		public TerminalNode TIME() { return getToken(SqlBaseParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SqlBaseParser.TIMESTAMP, 0); }
		public TerminalNode TINYINT() { return getToken(SqlBaseParser.TINYINT, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode TRANSACTION() { return getToken(SqlBaseParser.TRANSACTION, 0); }
		public TerminalNode TRY_CAST() { return getToken(SqlBaseParser.TRY_CAST, 0); }
		public TerminalNode TYPE() { return getToken(SqlBaseParser.TYPE, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode UNCOMMITTED() { return getToken(SqlBaseParser.UNCOMMITTED, 0); }
		public TerminalNode USE() { return getToken(SqlBaseParser.USE, 0); }
		public TerminalNode VALIDATE() { return getToken(SqlBaseParser.VALIDATE, 0); }
		public TerminalNode VERBOSE() { return getToken(SqlBaseParser.VERBOSE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TerminalNode WORK() { return getToken(SqlBaseParser.WORK, 0); }
		public TerminalNode WRITE() { return getToken(SqlBaseParser.WRITE, 0); }
		public TerminalNode YEAR() { return getToken(SqlBaseParser.YEAR, 0); }
		public TerminalNode ZONE() { return getToken(SqlBaseParser.ZONE, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNonReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNonReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNonReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_nonReserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !(((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (ADD - 18)) | (1L << (ALL - 18)) | (1L << (ANALYZE - 18)) | (1L << (ANY - 18)) | (1L << (ARRAY - 18)) | (1L << (ASC - 18)) | (1L << (AT - 18)) | (1L << (BERNOULLI - 18)) | (1L << (CALL - 18)) | (1L << (CASCADE - 18)) | (1L << (CATALOGS - 18)) | (1L << (COALESCE - 18)) | (1L << (COLUMN - 18)) | (1L << (COLUMNS - 18)) | (1L << (COMMENT - 18)) | (1L << (COMMIT - 18)) | (1L << (COMMITTED - 18)) | (1L << (CURRENT - 18)) | (1L << (DATA - 18)) | (1L << (DATE - 18)) | (1L << (DAY - 18)) | (1L << (DESC - 18)) | (1L << (DISTRIBUTED - 18)) | (1L << (EXCLUDING - 18)) | (1L << (EXPLAIN - 18)) | (1L << (FILTER - 18)) | (1L << (FIRST - 18)) | (1L << (FOLLOWING - 18)) | (1L << (FORMAT - 18)) | (1L << (FUNCTIONS - 18)) | (1L << (GRANT - 18)) | (1L << (GRANTS - 18)) | (1L << (GRAPHVIZ - 18)))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (HOUR - 84)) | (1L << (IF - 84)) | (1L << (INCLUDING - 84)) | (1L << (INPUT - 84)) | (1L << (INTEGER - 84)) | (1L << (INTERVAL - 84)) | (1L << (ISOLATION - 84)) | (1L << (LAST - 84)) | (1L << (LATERAL - 84)) | (1L << (LEVEL - 84)) | (1L << (LIMIT - 84)) | (1L << (LOGICAL - 84)) | (1L << (MAP - 84)) | (1L << (MINUTE - 84)) | (1L << (MONTH - 84)) | (1L << (NFC - 84)) | (1L << (NFD - 84)) | (1L << (NFKC - 84)) | (1L << (NFKD - 84)) | (1L << (NO - 84)) | (1L << (NULLIF - 84)) | (1L << (NULLS - 84)) | (1L << (ONLY - 84)) | (1L << (OPTION - 84)) | (1L << (ORDINALITY - 84)) | (1L << (OUTPUT - 84)) | (1L << (OVER - 84)) | (1L << (PARTITION - 84)) | (1L << (PARTITIONS - 84)) | (1L << (POSITION - 84)) | (1L << (PRECEDING - 84)) | (1L << (PRIVILEGES - 84)) | (1L << (PROPERTIES - 84)) | (1L << (PUBLIC - 84)) | (1L << (RANGE - 84)) | (1L << (READ - 84)) | (1L << (RENAME - 84)) | (1L << (REPEATABLE - 84)) | (1L << (REPLACE - 84)) | (1L << (RESET - 84)) | (1L << (RESTRICT - 84)) | (1L << (REVOKE - 84)))) != 0) || ((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (ROLLBACK - 148)) | (1L << (ROW - 148)) | (1L << (ROWS - 148)) | (1L << (SCHEMA - 148)) | (1L << (SCHEMAS - 148)) | (1L << (SECOND - 148)) | (1L << (SERIALIZABLE - 148)) | (1L << (SESSION - 148)) | (1L << (SET - 148)) | (1L << (SETS - 148)) | (1L << (SHOW - 148)) | (1L << (SMALLINT - 148)) | (1L << (SOME - 148)) | (1L << (START - 148)) | (1L << (STATS - 148)) | (1L << (SUBSTRING - 148)) | (1L << (SYSTEM - 148)) | (1L << (TABLES - 148)) | (1L << (TABLESAMPLE - 148)) | (1L << (TEXT - 148)) | (1L << (TIME - 148)) | (1L << (TIMESTAMP - 148)) | (1L << (TINYINT - 148)) | (1L << (TO - 148)) | (1L << (TRANSACTION - 148)) | (1L << (TRY_CAST - 148)) | (1L << (TYPE - 148)) | (1L << (UNBOUNDED - 148)) | (1L << (UNCOMMITTED - 148)) | (1L << (USE - 148)) | (1L << (VALIDATE - 148)) | (1L << (VERBOSE - 148)) | (1L << (VIEW - 148)) | (1L << (WORK - 148)) | (1L << (WRITE - 148)) | (1L << (YEAR - 148)) | (1L << (ZONE - 148)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00e5\u014a\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4U\n\4\3\5\3\5\3\6\3\6\3\6\5\6\\\n\6\3\6\3\6\3\6\3\6\5\6b\n\6\3"+
		"\7\3\7\3\7\3\7\5\7h\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7q\n\7\3\b\3\b\5"+
		"\bu\n\b\3\b\3\b\3\b\3\b\3\b\5\b|\n\b\3\b\3\b\3\b\3\t\3\t\5\t\u0083\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\t\3\t\5\t\u008f\n\t\3\n\3\n\7"+
		"\n\u0093\n\n\f\n\16\n\u0096\13\n\3\13\3\13\7\13\u009a\n\13\f\13\16\13"+
		"\u009d\13\13\3\13\3\13\3\13\3\f\3\f\5\f\u00a4\n\f\3\f\5\f\u00a7\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b0\n\f\5\f\u00b2\n\f\3\f\3\f\5\f\u00b6"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c0\n\r\3\16\3\16\5\16\u00c4"+
		"\n\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00cf\n\21\f\21"+
		"\16\21\u00d2\13\21\3\21\3\21\3\22\3\22\5\22\u00d8\n\22\3\22\5\22\u00db"+
		"\n\22\3\23\3\23\3\23\7\23\u00e0\n\23\f\23\16\23\u00e3\13\23\3\23\5\23"+
		"\u00e6\n\23\3\24\3\24\3\24\3\24\5\24\u00ec\n\24\3\25\3\25\5\25\u00f0\n"+
		"\25\3\26\3\26\3\26\3\26\3\26\7\26\u00f7\n\26\f\26\16\26\u00fa\13\26\3"+
		"\26\3\26\3\27\3\27\3\27\5\27\u0101\n\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\6\31\u010e\n\31\r\31\16\31\u010f\5\31\u0112"+
		"\n\31\3\32\3\32\7\32\u0116\n\32\f\32\16\32\u0119\13\32\3\33\3\33\3\33"+
		"\3\33\5\33\u011f\n\33\3\34\5\34\u0122\n\34\3\34\3\34\5\34\u0126\n\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u0130\n\37\5\37\u0132\n\37"+
		"\3 \3 \3 \7 \u0137\n \f \16 \u013a\13 \3!\3!\3!\3!\3!\5!\u0141\n!\3\""+
		"\3\"\3\"\5\"\u0146\n\"\3#\3#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\13\3\2\b\t\4\2\n\n\u00b1\u00b1\4"+
		"\2\n\n\17\21\3\2\4\4\5\2\n\n\17\21``\3\2\u00ce\u00cf\3\2\u00d7\u00d8\4"+
		"\2GG\u00b3\u00b3-\2\24\25\27\27\31\32\34\36!\"%+\60\60\64\6699<<BBEEH"+
		"JLLORVWYY[[]]__bbdeggiiloquyz|}\u0080\u0080\u0082\u0087\u0089\u008d\u008f"+
		"\u0094\u0096\u0096\u0098\u009c\u009e\u00a8\u00aa\u00ac\u00ae\u00b2\u00b4"+
		"\u00b5\u00b7\u00b8\u00bb\u00bb\u00bd\u00bd\u00bf\u00c0\u00c4\u00c7\2\u015f"+
		"\2F\3\2\2\2\4I\3\2\2\2\6T\3\2\2\2\bV\3\2\2\2\na\3\2\2\2\fp\3\2\2\2\16"+
		"r\3\2\2\2\20\u0080\3\2\2\2\22\u0090\3\2\2\2\24\u0097\3\2\2\2\26\u00a1"+
		"\3\2\2\2\30\u00bf\3\2\2\2\32\u00c3\3\2\2\2\34\u00c5\3\2\2\2\36\u00c7\3"+
		"\2\2\2 \u00ca\3\2\2\2\"\u00d5\3\2\2\2$\u00e5\3\2\2\2&\u00eb\3\2\2\2(\u00ed"+
		"\3\2\2\2*\u00f1\3\2\2\2,\u00fd\3\2\2\2.\u0102\3\2\2\2\60\u0111\3\2\2\2"+
		"\62\u0113\3\2\2\2\64\u011a\3\2\2\2\66\u0125\3\2\2\28\u0127\3\2\2\2:\u0129"+
		"\3\2\2\2<\u0131\3\2\2\2>\u0133\3\2\2\2@\u0140\3\2\2\2B\u0145\3\2\2\2D"+
		"\u0147\3\2\2\2FG\5\6\4\2GH\7\2\2\3H\3\3\2\2\2IJ\5\b\5\2JK\7\2\2\3K\5\3"+
		"\2\2\2LU\5\n\6\2MU\5\f\7\2NU\5\16\b\2OU\5\20\t\2PU\5\24\13\2QU\5\30\r"+
		"\2RU\5\22\n\2SU\5\36\20\2TL\3\2\2\2TM\3\2\2\2TN\3\2\2\2TO\3\2\2\2TP\3"+
		"\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\7\3\2\2\2VW\3\2\2\2W\t\3\2\2\2X"+
		"Y\t\2\2\2Y[\5\32\16\2Z\\\t\3\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\5\32"+
		"\16\2^b\3\2\2\2_`\78\2\2`b\5\32\16\2aX\3\2\2\2a_\3\2\2\2b\13\3\2\2\2c"+
		"d\7-\2\2de\7\r\2\2eg\7\u00da\2\2fh\7\u00c3\2\2gf\3\2\2\2gh\3\2\2\2hi\3"+
		"\2\2\2iq\5 \21\2jk\7=\2\2kl\7\r\2\2lq\7\u00da\2\2mn\7\u00a2\2\2no\7\r"+
		"\2\2oq\7\u00da\2\2pc\3\2\2\2pj\3\2\2\2pm\3\2\2\2q\r\3\2\2\2rt\7\13\2\2"+
		"su\7\22\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\5\34\17\2wx\7\3\2\2x{\5\32"+
		"\16\2yz\7\u00c3\2\2z|\5 \21\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\33\2\2"+
		"~\177\5> \2\177\17\3\2\2\2\u0080\u0082\7\f\2\2\u0081\u0083\t\4\2\2\u0082"+
		"\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\5>"+
		" \2\u0085\u0086\7\33\2\2\u0086\u0087\5\34\17\2\u0087\u0088\7\3\2\2\u0088"+
		"\u008a\5\32\16\2\u0089\u008b\5*\26\2\u008a\u0089\3\2\2\2\u008a\u008b\3"+
		"\2\2\2\u008b\u008e\3\2\2\2\u008c\u008d\7\u00c3\2\2\u008d\u008f\5 \21\2"+
		"\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\21\3\2\2\2\u0090\u0094"+
		"\7\u009d\2\2\u0091\u0093\n\5\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\23\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u009b\7\u009d\2\2\u0098\u009a\n\5\2\2\u0099\u0098\3\2\2"+
		"\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\33\2\2\u009f\u00a0\5@!\2\u00a0"+
		"\25\3\2\2\2\u00a1\u00a3\7\\\2\2\u00a2\u00a4\t\6\2\2\u00a3\u00a2\3\2\2"+
		"\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a7\7\22\2\2\u00a6"+
		"\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\5\34"+
		"\17\2\u00a9\u00aa\7\3\2\2\u00aa\u00b1\5\32\16\2\u00ab\u00af\5*\26\2\u00ac"+
		"\u00ad\7W\2\2\u00ad\u00ae\7w\2\2\u00ae\u00b0\7D\2\2\u00af\u00ac\3\2\2"+
		"\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b4\7\u00c3\2\2\u00b4\u00b6\5 \21"+
		"\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\7M\2\2\u00b8\27\3\2\2\2\u00b9\u00ba\5\26\f\2\u00ba\u00bb\5\22\n\2\u00bb"+
		"\u00c0\3\2\2\2\u00bc\u00bd\5\26\f\2\u00bd\u00be\5> \2\u00be\u00c0\3\2"+
		"\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0\31\3\2\2\2\u00c1\u00c4"+
		"\7\u00dd\2\2\u00c2\u00c4\5@!\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2"+
		"\u00c4\33\3\2\2\2\u00c5\u00c6\5@!\2\u00c6\35\3\2\2\2\u00c7\u00c8\7\23"+
		"\2\2\u00c8\u00c9\7\u00d4\2\2\u00c9\37\3\2\2\2\u00ca\u00cb\7\5\2\2\u00cb"+
		"\u00d0\5\"\22\2\u00cc\u00cd\7\6\2\2\u00cd\u00cf\5\"\22\2\u00ce\u00cc\3"+
		"\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\7\2\2\u00d4!\3\2\2\2"+
		"\u00d5\u00da\5$\23\2\u00d6\u00d8\7\u00c8\2\2\u00d7\u00d6\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\5&\24\2\u00da\u00d7\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db#\3\2\2\2\u00dc\u00e1\5@!\2\u00dd\u00de"+
		"\7\3\2\2\u00de\u00e0\5@!\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e6\7\u00d4\2\2\u00e5\u00dc\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6"+
		"%\3\2\2\2\u00e7\u00ec\7\u00d7\2\2\u00e8\u00ec\7\u00d8\2\2\u00e9\u00ec"+
		"\58\35\2\u00ea\u00ec\7\u00d4\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3\2\2"+
		"\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\'\3\2\2\2\u00ed\u00ef"+
		"\5*\26\2\u00ee\u00f0\5.\30\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		")\3\2\2\2\u00f1\u00f2\7\u0084\2\2\u00f2\u00f3\7\5\2\2\u00f3\u00f8\5,\27"+
		"\2\u00f4\u00f5\7\6\2\2\u00f5\u00f7\5,\27\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u00fc\7\7\2\2\u00fc+\3\2\2\2\u00fd\u0100\5@!\2\u00fe"+
		"\u00ff\7\u00c8\2\2\u00ff\u0101\5\60\31\2\u0100\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101-\3\2\2\2\u0102\u0103\7\16\2\2\u0103\u0104\7\u00d4\2\2\u0104"+
		"/\3\2\2\2\u0105\u0112\7x\2\2\u0106\u0112\5\62\32\2\u0107\u0108\5@!\2\u0108"+
		"\u0109\7\u00d4\2\2\u0109\u0112\3\2\2\2\u010a\u0112\5B\"\2\u010b\u0112"+
		"\58\35\2\u010c\u010e\7\u00d4\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2"+
		"\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u0105"+
		"\3\2\2\2\u0111\u0106\3\2\2\2\u0111\u0107\3\2\2\2\u0111\u010a\3\2\2\2\u0111"+
		"\u010b\3\2\2\2\u0111\u010d\3\2\2\2\u0112\61\3\2\2\2\u0113\u0117\7_\2\2"+
		"\u0114\u0116\5\64\33\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\63\3\2\2\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011b\5\66\34\2\u011b\u011e\5@!\2\u011c\u011d\7\u00b1\2\2\u011d\u011f"+
		"\5@!\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\65\3\2\2\2\u0120"+
		"\u0122\t\7\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0126\t\b\2\2\u0124\u0126\7\u00d4\2\2\u0125\u0121\3\2\2\2\u0125"+
		"\u0124\3\2\2\2\u0126\67\3\2\2\2\u0127\u0128\t\t\2\2\u01289\3\2\2\2\u0129"+
		"\u012a\7\4\2\2\u012a;\3\2\2\2\u012b\u0132\7\u00d4\2\2\u012c\u012f\7\u00d5"+
		"\2\2\u012d\u012e\7\u00b6\2\2\u012e\u0130\7\u00d4\2\2\u012f\u012d\3\2\2"+
		"\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012b\3\2\2\2\u0131\u012c"+
		"\3\2\2\2\u0132=\3\2\2\2\u0133\u0138\5@!\2\u0134\u0135\7\3\2\2\u0135\u0137"+
		"\5@!\2\u0136\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139?\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0141\7\u00da"+
		"\2\2\u013c\u0141\7\u00dc\2\2\u013d\u0141\5D#\2\u013e\u0141\7\u00dd\2\2"+
		"\u013f\u0141\7\u00db\2\2\u0140\u013b\3\2\2\2\u0140\u013c\3\2\2\2\u0140"+
		"\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141A\3\2\2\2"+
		"\u0142\u0146\7\u00d8\2\2\u0143\u0146\7\u00d9\2\2\u0144\u0146\7\u00d7\2"+
		"\2\u0145\u0142\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2\u0146C"+
		"\3\2\2\2\u0147\u0148\t\n\2\2\u0148E\3\2\2\2)T[agpt{\u0082\u008a\u008e"+
		"\u0094\u009b\u00a3\u00a6\u00af\u00b1\u00b5\u00bf\u00c3\u00d0\u00d7\u00da"+
		"\u00e1\u00e5\u00eb\u00ef\u00f8\u0100\u010f\u0111\u0117\u011e\u0121\u0125"+
		"\u012f\u0131\u0138\u0140\u0145";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}