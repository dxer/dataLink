// Generated from io\dxer\datalink\sql\parser\SqlBase.g4 by ANTLR 4.7
package io.dxer.datalink.sql.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INSERT=6, CREATE=7, DROP=8, SHOW=9, 
		SELECT=10, WITH=11, TRUE=12, FALSE=13, PARTITION=14, NULL=15, INTERVAL=16, 
		TO=17, AS=18, LIKE=19, INTO=20, IN=21, FROM=22, EQ=23, NSEQ=24, NEQ=25, 
		NEQJ=26, LT=27, LTE=28, GT=29, GTE=30, PLUS=31, MINUS=32, ASTERISK=33, 
		SLASH=34, PERCENT=35, DIV=36, TILDE=37, AMPERSAND=38, PIPE=39, CONCAT_PIPE=40, 
		HAT=41, OVERWRITE=42, LOAD=43, DATA=44, OPTIONS=45, CONNECTION=46, CONNECTIONS=47, 
		LOCATION=48, APPEND=49, ERROR_IF_EXISTS=50, IGNORE=51, LOCAL=52, EXEC=53, 
		JDBC=54, HBASE=55, FTP=56, SFTP=57, SSH=58, MAIL=59, REDIS=60, TEMPORARY=61, 
		STRING=62, BIGINT_LITERAL=63, SMALLINT_LITERAL=64, TINYINT_LITERAL=65, 
		INTEGER_VALUE=66, DECIMAL_VALUE=67, DOUBLE_LITERAL=68, BIGDECIMAL_LITERAL=69, 
		IDENTIFIER=70, BACKQUOTED_IDENTIFIER=71, SIMPLE_COMMENT=72, BRACKETED_EMPTY_COMMENT=73, 
		BRACKETED_COMMENT=74, WS=75, UNRECOGNIZED=76;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "INSERT", "CREATE", "DROP", "SHOW", 
		"SELECT", "WITH", "TRUE", "FALSE", "PARTITION", "NULL", "INTERVAL", "TO", 
		"AS", "LIKE", "INTO", "IN", "FROM", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", 
		"LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "DIV", 
		"TILDE", "AMPERSAND", "PIPE", "CONCAT_PIPE", "HAT", "OVERWRITE", "LOAD", 
		"DATA", "OPTIONS", "CONNECTION", "CONNECTIONS", "LOCATION", "APPEND", 
		"ERROR_IF_EXISTS", "IGNORE", "LOCAL", "EXEC", "JDBC", "HBASE", "FTP", 
		"SFTP", "SSH", "MAIL", "REDIS", "TEMPORARY", "STRING", "BIGINT_LITERAL", 
		"SMALLINT_LITERAL", "TINYINT_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", 
		"DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", "IDENTIFIER", "BACKQUOTED_IDENTIFIER", 
		"DECIMAL_DIGITS", "EXPONENT", "DIGIT", "LETTER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", 
		"BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'.'", "'('", "','", "')'", "'INSERT'", "'CREATE'", "'DROP'", 
		"'SHOW'", "'SELECT'", "'WITH'", "'TRUE'", "'FALSE'", "'PARTITION'", "'NULL'", 
		"'INTERVAL'", "'TO'", "'AS'", "'LIKE'", "'INTO'", "'IN'", "'FROM'", null, 
		"'<=>'", "'<>'", "'!='", "'<'", null, "'>'", null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", "'||'", "'^'", "'OVERWRITE'", 
		"'LOAD'", "'DATA'", "'OPTIONS'", "'CONNECTION'", "'CONNECTIONS'", "'LOCATION'", 
		"'APPEND'", "'ERROR_IF_EXISTS'", "'IGNORE'", "'LOCAL'", "'EXEC'", "'JDBC'", 
		"'HBASE'", "'FTP'", "'SFTP'", "'SSH'", "'MAIL'", "'REDIS'", null, null, 
		null, null, null, null, null, null, null, null, null, null, "'/**/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "INSERT", "CREATE", "DROP", "SHOW", 
		"SELECT", "WITH", "TRUE", "FALSE", "PARTITION", "NULL", "INTERVAL", "TO", 
		"AS", "LIKE", "INTO", "IN", "FROM", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", 
		"LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "DIV", 
		"TILDE", "AMPERSAND", "PIPE", "CONCAT_PIPE", "HAT", "OVERWRITE", "LOAD", 
		"DATA", "OPTIONS", "CONNECTION", "CONNECTIONS", "LOCATION", "APPEND", 
		"ERROR_IF_EXISTS", "IGNORE", "LOCAL", "EXEC", "JDBC", "HBASE", "FTP", 
		"SFTP", "SSH", "MAIL", "REDIS", "TEMPORARY", "STRING", "BIGINT_LITERAL", 
		"SMALLINT_LITERAL", "TINYINT_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", 
		"DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", "IDENTIFIER", "BACKQUOTED_IDENTIFIER", 
		"SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", "WS", 
		"UNRECOGNIZED"
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


	  /**
	   * Verify whether current token is a valid decimal token (which contains dot).
	   * Returns true if the character that follows the token is not a digit or letter or underscore.
	   *
	   * For example:
	   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
	   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
	   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
	   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is followed
	   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
	   * which is not a digit or letter or underscore.
	   */
	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }


	public SqlBaseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 66:
			return DECIMAL_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 67:
			return DOUBLE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 68:
			return BIGDECIMAL_LITERAL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean DECIMAL_VALUE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isValidDecimal();
		}
		return true;
	}
	private boolean DOUBLE_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isValidDecimal();
		}
		return true;
	}
	private boolean BIGDECIMAL_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return isValidDecimal();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2N\u02a6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\5\30\u0110"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\5\35\u0122\n\35\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u012a"+
		"\n\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3("+
		"\3)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39"+
		"\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3="+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u01da\n>\3?\3?\3?\3?\7?\u01e0"+
		"\n?\f?\16?\u01e3\13?\3?\3?\3?\3?\3?\7?\u01ea\n?\f?\16?\u01ed\13?\3?\5"+
		"?\u01f0\n?\3@\6@\u01f3\n@\r@\16@\u01f4\3@\3@\3A\6A\u01fa\nA\rA\16A\u01fb"+
		"\3A\3A\3B\6B\u0201\nB\rB\16B\u0202\3B\3B\3C\6C\u0208\nC\rC\16C\u0209\3"+
		"D\6D\u020d\nD\rD\16D\u020e\3D\3D\3D\3D\5D\u0215\nD\3D\3D\5D\u0219\nD\3"+
		"E\6E\u021c\nE\rE\16E\u021d\3E\5E\u0221\nE\3E\3E\3E\3E\5E\u0227\nE\3E\3"+
		"E\3E\5E\u022c\nE\3F\6F\u022f\nF\rF\16F\u0230\3F\5F\u0234\nF\3F\3F\3F\3"+
		"F\3F\5F\u023b\nF\3F\3F\3F\3F\3F\5F\u0242\nF\3G\3G\3G\6G\u0247\nG\rG\16"+
		"G\u0248\3H\3H\3H\3H\7H\u024f\nH\fH\16H\u0252\13H\3H\3H\3I\6I\u0257\nI"+
		"\rI\16I\u0258\3I\3I\7I\u025d\nI\fI\16I\u0260\13I\3I\3I\6I\u0264\nI\rI"+
		"\16I\u0265\5I\u0268\nI\3J\3J\5J\u026c\nJ\3J\6J\u026f\nJ\rJ\16J\u0270\3"+
		"K\3K\3L\3L\3M\3M\3M\3M\7M\u027b\nM\fM\16M\u027e\13M\3M\5M\u0281\nM\3M"+
		"\5M\u0284\nM\3M\3M\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\7O\u0294\nO\fO"+
		"\16O\u0297\13O\3O\3O\3O\3O\3O\3P\6P\u029f\nP\rP\16P\u02a0\3P\3P\3Q\3Q"+
		"\3\u0295\2R\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008b"+
		"G\u008dH\u008fI\u0091\2\u0093\2\u0095\2\u0097\2\u0099J\u009bK\u009dL\u009f"+
		"M\u00a1N\3\2\13\4\2))^^\4\2$$^^\3\2bb\4\2--//\3\2\62;\3\2C\\\4\2\f\f\17"+
		"\17\3\2--\5\2\13\f\17\17\"\"\2\u02c9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\3\u00a3"+
		"\3\2\2\2\5\u00a5\3\2\2\2\7\u00a7\3\2\2\2\t\u00a9\3\2\2\2\13\u00ab\3\2"+
		"\2\2\r\u00ad\3\2\2\2\17\u00b4\3\2\2\2\21\u00bb\3\2\2\2\23\u00c0\3\2\2"+
		"\2\25\u00c5\3\2\2\2\27\u00cc\3\2\2\2\31\u00d1\3\2\2\2\33\u00d6\3\2\2\2"+
		"\35\u00dc\3\2\2\2\37\u00e6\3\2\2\2!\u00eb\3\2\2\2#\u00f4\3\2\2\2%\u00f7"+
		"\3\2\2\2\'\u00fa\3\2\2\2)\u00ff\3\2\2\2+\u0104\3\2\2\2-\u0107\3\2\2\2"+
		"/\u010f\3\2\2\2\61\u0111\3\2\2\2\63\u0115\3\2\2\2\65\u0118\3\2\2\2\67"+
		"\u011b\3\2\2\29\u0121\3\2\2\2;\u0123\3\2\2\2=\u0129\3\2\2\2?\u012b\3\2"+
		"\2\2A\u012d\3\2\2\2C\u012f\3\2\2\2E\u0131\3\2\2\2G\u0133\3\2\2\2I\u0135"+
		"\3\2\2\2K\u0139\3\2\2\2M\u013b\3\2\2\2O\u013d\3\2\2\2Q\u013f\3\2\2\2S"+
		"\u0142\3\2\2\2U\u0144\3\2\2\2W\u014e\3\2\2\2Y\u0153\3\2\2\2[\u0158\3\2"+
		"\2\2]\u0160\3\2\2\2_\u016b\3\2\2\2a\u0177\3\2\2\2c\u0180\3\2\2\2e\u0187"+
		"\3\2\2\2g\u0197\3\2\2\2i\u019e\3\2\2\2k\u01a4\3\2\2\2m\u01a9\3\2\2\2o"+
		"\u01ae\3\2\2\2q\u01b4\3\2\2\2s\u01b8\3\2\2\2u\u01bd\3\2\2\2w\u01c1\3\2"+
		"\2\2y\u01c6\3\2\2\2{\u01d9\3\2\2\2}\u01ef\3\2\2\2\177\u01f2\3\2\2\2\u0081"+
		"\u01f9\3\2\2\2\u0083\u0200\3\2\2\2\u0085\u0207\3\2\2\2\u0087\u0218\3\2"+
		"\2\2\u0089\u022b\3\2\2\2\u008b\u0241\3\2\2\2\u008d\u0246\3\2\2\2\u008f"+
		"\u024a\3\2\2\2\u0091\u0267\3\2\2\2\u0093\u0269\3\2\2\2\u0095\u0272\3\2"+
		"\2\2\u0097\u0274\3\2\2\2\u0099\u0276\3\2\2\2\u009b\u0287\3\2\2\2\u009d"+
		"\u028e\3\2\2\2\u009f\u029e\3\2\2\2\u00a1\u02a4\3\2\2\2\u00a3\u00a4\7="+
		"\2\2\u00a4\4\3\2\2\2\u00a5\u00a6\7\60\2\2\u00a6\6\3\2\2\2\u00a7\u00a8"+
		"\7*\2\2\u00a8\b\3\2\2\2\u00a9\u00aa\7.\2\2\u00aa\n\3\2\2\2\u00ab\u00ac"+
		"\7+\2\2\u00ac\f\3\2\2\2\u00ad\u00ae\7K\2\2\u00ae\u00af\7P\2\2\u00af\u00b0"+
		"\7U\2\2\u00b0\u00b1\7G\2\2\u00b1\u00b2\7T\2\2\u00b2\u00b3\7V\2\2\u00b3"+
		"\16\3\2\2\2\u00b4\u00b5\7E\2\2\u00b5\u00b6\7T\2\2\u00b6\u00b7\7G\2\2\u00b7"+
		"\u00b8\7C\2\2\u00b8\u00b9\7V\2\2\u00b9\u00ba\7G\2\2\u00ba\20\3\2\2\2\u00bb"+
		"\u00bc\7F\2\2\u00bc\u00bd\7T\2\2\u00bd\u00be\7Q\2\2\u00be\u00bf\7R\2\2"+
		"\u00bf\22\3\2\2\2\u00c0\u00c1\7U\2\2\u00c1\u00c2\7J\2\2\u00c2\u00c3\7"+
		"Q\2\2\u00c3\u00c4\7Y\2\2\u00c4\24\3\2\2\2\u00c5\u00c6\7U\2\2\u00c6\u00c7"+
		"\7G\2\2\u00c7\u00c8\7N\2\2\u00c8\u00c9\7G\2\2\u00c9\u00ca\7E\2\2\u00ca"+
		"\u00cb\7V\2\2\u00cb\26\3\2\2\2\u00cc\u00cd\7Y\2\2\u00cd\u00ce\7K\2\2\u00ce"+
		"\u00cf\7V\2\2\u00cf\u00d0\7J\2\2\u00d0\30\3\2\2\2\u00d1\u00d2\7V\2\2\u00d2"+
		"\u00d3\7T\2\2\u00d3\u00d4\7W\2\2\u00d4\u00d5\7G\2\2\u00d5\32\3\2\2\2\u00d6"+
		"\u00d7\7H\2\2\u00d7\u00d8\7C\2\2\u00d8\u00d9\7N\2\2\u00d9\u00da\7U\2\2"+
		"\u00da\u00db\7G\2\2\u00db\34\3\2\2\2\u00dc\u00dd\7R\2\2\u00dd\u00de\7"+
		"C\2\2\u00de\u00df\7T\2\2\u00df\u00e0\7V\2\2\u00e0\u00e1\7K\2\2\u00e1\u00e2"+
		"\7V\2\2\u00e2\u00e3\7K\2\2\u00e3\u00e4\7Q\2\2\u00e4\u00e5\7P\2\2\u00e5"+
		"\36\3\2\2\2\u00e6\u00e7\7P\2\2\u00e7\u00e8\7W\2\2\u00e8\u00e9\7N\2\2\u00e9"+
		"\u00ea\7N\2\2\u00ea \3\2\2\2\u00eb\u00ec\7K\2\2\u00ec\u00ed\7P\2\2\u00ed"+
		"\u00ee\7V\2\2\u00ee\u00ef\7G\2\2\u00ef\u00f0\7T\2\2\u00f0\u00f1\7X\2\2"+
		"\u00f1\u00f2\7C\2\2\u00f2\u00f3\7N\2\2\u00f3\"\3\2\2\2\u00f4\u00f5\7V"+
		"\2\2\u00f5\u00f6\7Q\2\2\u00f6$\3\2\2\2\u00f7\u00f8\7C\2\2\u00f8\u00f9"+
		"\7U\2\2\u00f9&\3\2\2\2\u00fa\u00fb\7N\2\2\u00fb\u00fc\7K\2\2\u00fc\u00fd"+
		"\7M\2\2\u00fd\u00fe\7G\2\2\u00fe(\3\2\2\2\u00ff\u0100\7K\2\2\u0100\u0101"+
		"\7P\2\2\u0101\u0102\7V\2\2\u0102\u0103\7Q\2\2\u0103*\3\2\2\2\u0104\u0105"+
		"\7K\2\2\u0105\u0106\7P\2\2\u0106,\3\2\2\2\u0107\u0108\7H\2\2\u0108\u0109"+
		"\7T\2\2\u0109\u010a\7Q\2\2\u010a\u010b\7O\2\2\u010b.\3\2\2\2\u010c\u0110"+
		"\7?\2\2\u010d\u010e\7?\2\2\u010e\u0110\7?\2\2\u010f\u010c\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\60\3\2\2\2\u0111\u0112\7>\2\2\u0112\u0113\7?\2\2"+
		"\u0113\u0114\7@\2\2\u0114\62\3\2\2\2\u0115\u0116\7>\2\2\u0116\u0117\7"+
		"@\2\2\u0117\64\3\2\2\2\u0118\u0119\7#\2\2\u0119\u011a\7?\2\2\u011a\66"+
		"\3\2\2\2\u011b\u011c\7>\2\2\u011c8\3\2\2\2\u011d\u011e\7>\2\2\u011e\u0122"+
		"\7?\2\2\u011f\u0120\7#\2\2\u0120\u0122\7@\2\2\u0121\u011d\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0122:\3\2\2\2\u0123\u0124\7@\2\2\u0124<\3\2\2\2\u0125"+
		"\u0126\7@\2\2\u0126\u012a\7?\2\2\u0127\u0128\7#\2\2\u0128\u012a\7>\2\2"+
		"\u0129\u0125\3\2\2\2\u0129\u0127\3\2\2\2\u012a>\3\2\2\2\u012b\u012c\7"+
		"-\2\2\u012c@\3\2\2\2\u012d\u012e\7/\2\2\u012eB\3\2\2\2\u012f\u0130\7,"+
		"\2\2\u0130D\3\2\2\2\u0131\u0132\7\61\2\2\u0132F\3\2\2\2\u0133\u0134\7"+
		"\'\2\2\u0134H\3\2\2\2\u0135\u0136\7F\2\2\u0136\u0137\7K\2\2\u0137\u0138"+
		"\7X\2\2\u0138J\3\2\2\2\u0139\u013a\7\u0080\2\2\u013aL\3\2\2\2\u013b\u013c"+
		"\7(\2\2\u013cN\3\2\2\2\u013d\u013e\7~\2\2\u013eP\3\2\2\2\u013f\u0140\7"+
		"~\2\2\u0140\u0141\7~\2\2\u0141R\3\2\2\2\u0142\u0143\7`\2\2\u0143T\3\2"+
		"\2\2\u0144\u0145\7Q\2\2\u0145\u0146\7X\2\2\u0146\u0147\7G\2\2\u0147\u0148"+
		"\7T\2\2\u0148\u0149\7Y\2\2\u0149\u014a\7T\2\2\u014a\u014b\7K\2\2\u014b"+
		"\u014c\7V\2\2\u014c\u014d\7G\2\2\u014dV\3\2\2\2\u014e\u014f\7N\2\2\u014f"+
		"\u0150\7Q\2\2\u0150\u0151\7C\2\2\u0151\u0152\7F\2\2\u0152X\3\2\2\2\u0153"+
		"\u0154\7F\2\2\u0154\u0155\7C\2\2\u0155\u0156\7V\2\2\u0156\u0157\7C\2\2"+
		"\u0157Z\3\2\2\2\u0158\u0159\7Q\2\2\u0159\u015a\7R\2\2\u015a\u015b\7V\2"+
		"\2\u015b\u015c\7K\2\2\u015c\u015d\7Q\2\2\u015d\u015e\7P\2\2\u015e\u015f"+
		"\7U\2\2\u015f\\\3\2\2\2\u0160\u0161\7E\2\2\u0161\u0162\7Q\2\2\u0162\u0163"+
		"\7P\2\2\u0163\u0164\7P\2\2\u0164\u0165\7G\2\2\u0165\u0166\7E\2\2\u0166"+
		"\u0167\7V\2\2\u0167\u0168\7K\2\2\u0168\u0169\7Q\2\2\u0169\u016a\7P\2\2"+
		"\u016a^\3\2\2\2\u016b\u016c\7E\2\2\u016c\u016d\7Q\2\2\u016d\u016e\7P\2"+
		"\2\u016e\u016f\7P\2\2\u016f\u0170\7G\2\2\u0170\u0171\7E\2\2\u0171\u0172"+
		"\7V\2\2\u0172\u0173\7K\2\2\u0173\u0174\7Q\2\2\u0174\u0175\7P\2\2\u0175"+
		"\u0176\7U\2\2\u0176`\3\2\2\2\u0177\u0178\7N\2\2\u0178\u0179\7Q\2\2\u0179"+
		"\u017a\7E\2\2\u017a\u017b\7C\2\2\u017b\u017c\7V\2\2\u017c\u017d\7K\2\2"+
		"\u017d\u017e\7Q\2\2\u017e\u017f\7P\2\2\u017fb\3\2\2\2\u0180\u0181\7C\2"+
		"\2\u0181\u0182\7R\2\2\u0182\u0183\7R\2\2\u0183\u0184\7G\2\2\u0184\u0185"+
		"\7P\2\2\u0185\u0186\7F\2\2\u0186d\3\2\2\2\u0187\u0188\7G\2\2\u0188\u0189"+
		"\7T\2\2\u0189\u018a\7T\2\2\u018a\u018b\7Q\2\2\u018b\u018c\7T\2\2\u018c"+
		"\u018d\7a\2\2\u018d\u018e\7K\2\2\u018e\u018f\7H\2\2\u018f\u0190\7a\2\2"+
		"\u0190\u0191\7G\2\2\u0191\u0192\7Z\2\2\u0192\u0193\7K\2\2\u0193\u0194"+
		"\7U\2\2\u0194\u0195\7V\2\2\u0195\u0196\7U\2\2\u0196f\3\2\2\2\u0197\u0198"+
		"\7K\2\2\u0198\u0199\7I\2\2\u0199\u019a\7P\2\2\u019a\u019b\7Q\2\2\u019b"+
		"\u019c\7T\2\2\u019c\u019d\7G\2\2\u019dh\3\2\2\2\u019e\u019f\7N\2\2\u019f"+
		"\u01a0\7Q\2\2\u01a0\u01a1\7E\2\2\u01a1\u01a2\7C\2\2\u01a2\u01a3\7N\2\2"+
		"\u01a3j\3\2\2\2\u01a4\u01a5\7G\2\2\u01a5\u01a6\7Z\2\2\u01a6\u01a7\7G\2"+
		"\2\u01a7\u01a8\7E\2\2\u01a8l\3\2\2\2\u01a9\u01aa\7L\2\2\u01aa\u01ab\7"+
		"F\2\2\u01ab\u01ac\7D\2\2\u01ac\u01ad\7E\2\2\u01adn\3\2\2\2\u01ae\u01af"+
		"\7J\2\2\u01af\u01b0\7D\2\2\u01b0\u01b1\7C\2\2\u01b1\u01b2\7U\2\2\u01b2"+
		"\u01b3\7G\2\2\u01b3p\3\2\2\2\u01b4\u01b5\7H\2\2\u01b5\u01b6\7V\2\2\u01b6"+
		"\u01b7\7R\2\2\u01b7r\3\2\2\2\u01b8\u01b9\7U\2\2\u01b9\u01ba\7H\2\2\u01ba"+
		"\u01bb\7V\2\2\u01bb\u01bc\7R\2\2\u01bct\3\2\2\2\u01bd\u01be\7U\2\2\u01be"+
		"\u01bf\7U\2\2\u01bf\u01c0\7J\2\2\u01c0v\3\2\2\2\u01c1\u01c2\7O\2\2\u01c2"+
		"\u01c3\7C\2\2\u01c3\u01c4\7K\2\2\u01c4\u01c5\7N\2\2\u01c5x\3\2\2\2\u01c6"+
		"\u01c7\7T\2\2\u01c7\u01c8\7G\2\2\u01c8\u01c9\7F\2\2\u01c9\u01ca\7K\2\2"+
		"\u01ca\u01cb\7U\2\2\u01cbz\3\2\2\2\u01cc\u01cd\7V\2\2\u01cd\u01ce\7G\2"+
		"\2\u01ce\u01cf\7O\2\2\u01cf\u01d0\7R\2\2\u01d0\u01d1\7Q\2\2\u01d1\u01d2"+
		"\7T\2\2\u01d2\u01d3\7C\2\2\u01d3\u01d4\7T\2\2\u01d4\u01da\7[\2\2\u01d5"+
		"\u01d6\7V\2\2\u01d6\u01d7\7G\2\2\u01d7\u01d8\7O\2\2\u01d8\u01da\7R\2\2"+
		"\u01d9\u01cc\3\2\2\2\u01d9\u01d5\3\2\2\2\u01da|\3\2\2\2\u01db\u01e1\7"+
		")\2\2\u01dc\u01e0\n\2\2\2\u01dd\u01de\7^\2\2\u01de\u01e0\13\2\2\2\u01df"+
		"\u01dc\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4"+
		"\u01f0\7)\2\2\u01e5\u01eb\7$\2\2\u01e6\u01ea\n\3\2\2\u01e7\u01e8\7^\2"+
		"\2\u01e8\u01ea\13\2\2\2\u01e9\u01e6\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea"+
		"\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ee\3\2"+
		"\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f0\7$\2\2\u01ef\u01db\3\2\2\2\u01ef"+
		"\u01e5\3\2\2\2\u01f0~\3\2\2\2\u01f1\u01f3\5\u0095K\2\u01f2\u01f1\3\2\2"+
		"\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u01f7\7N\2\2\u01f7\u0080\3\2\2\2\u01f8\u01fa\5\u0095K\2"+
		"\u01f9\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc"+
		"\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7U\2\2\u01fe\u0082\3\2\2\2\u01ff"+
		"\u0201\5\u0095K\2\u0200\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0200"+
		"\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\7[\2\2\u0205"+
		"\u0084\3\2\2\2\u0206\u0208\5\u0095K\2\u0207\u0206\3\2\2\2\u0208\u0209"+
		"\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u0086\3\2\2\2\u020b"+
		"\u020d\5\u0095K\2\u020c\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020c"+
		"\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\5\u0093J"+
		"\2\u0211\u0219\3\2\2\2\u0212\u0214\5\u0091I\2\u0213\u0215\5\u0093J\2\u0214"+
		"\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\6D"+
		"\2\2\u0217\u0219\3\2\2\2\u0218\u020c\3\2\2\2\u0218\u0212\3\2\2\2\u0219"+
		"\u0088\3\2\2\2\u021a\u021c\5\u0095K\2\u021b\u021a\3\2\2\2\u021c\u021d"+
		"\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f"+
		"\u0221\5\u0093J\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222"+
		"\3\2\2\2\u0222\u0223\7F\2\2\u0223\u022c\3\2\2\2\u0224\u0226\5\u0091I\2"+
		"\u0225\u0227\5\u0093J\2\u0226\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228\u0229\7F\2\2\u0229\u022a\6E\3\2\u022a\u022c\3\2\2"+
		"\2\u022b\u021b\3\2\2\2\u022b\u0224\3\2\2\2\u022c\u008a\3\2\2\2\u022d\u022f"+
		"\5\u0095K\2\u022e\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u022e\3\2\2"+
		"\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232\u0234\5\u0093J\2\u0233"+
		"\u0232\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\7D"+
		"\2\2\u0236\u0237\7F\2\2\u0237\u0242\3\2\2\2\u0238\u023a\5\u0091I\2\u0239"+
		"\u023b\5\u0093J\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c"+
		"\3\2\2\2\u023c\u023d\7D\2\2\u023d\u023e\7F\2\2\u023e\u023f\3\2\2\2\u023f"+
		"\u0240\6F\4\2\u0240\u0242\3\2\2\2\u0241\u022e\3\2\2\2\u0241\u0238\3\2"+
		"\2\2\u0242\u008c\3\2\2\2\u0243\u0247\5\u0097L\2\u0244\u0247\5\u0095K\2"+
		"\u0245\u0247\7a\2\2\u0246\u0243\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0245"+
		"\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u008e\3\2\2\2\u024a\u0250\7b\2\2\u024b\u024f\n\4\2\2\u024c\u024d\7b\2"+
		"\2\u024d\u024f\7b\2\2\u024e\u024b\3\2\2\2\u024e\u024c\3\2\2\2\u024f\u0252"+
		"\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0253\3\2\2\2\u0252"+
		"\u0250\3\2\2\2\u0253\u0254\7b\2\2\u0254\u0090\3\2\2\2\u0255\u0257\5\u0095"+
		"K\2\u0256\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0256\3\2\2\2\u0258"+
		"\u0259\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025e\7\60\2\2\u025b\u025d\5"+
		"\u0095K\2\u025c\u025b\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025c\3\2\2\2"+
		"\u025e\u025f\3\2\2\2\u025f\u0268\3\2\2\2\u0260\u025e\3\2\2\2\u0261\u0263"+
		"\7\60\2\2\u0262\u0264\5\u0095K\2\u0263\u0262\3\2\2\2\u0264\u0265\3\2\2"+
		"\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\3\2\2\2\u0267\u0256"+
		"\3\2\2\2\u0267\u0261\3\2\2\2\u0268\u0092\3\2\2\2\u0269\u026b\7G\2\2\u026a"+
		"\u026c\t\5\2\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e\3\2"+
		"\2\2\u026d\u026f\5\u0095K\2\u026e\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0094\3\2\2\2\u0272\u0273\t\6"+
		"\2\2\u0273\u0096\3\2\2\2\u0274\u0275\t\7\2\2\u0275\u0098\3\2\2\2\u0276"+
		"\u0277\7/\2\2\u0277\u0278\7/\2\2\u0278\u027c\3\2\2\2\u0279\u027b\n\b\2"+
		"\2\u027a\u0279\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a\3\2\2\2\u027c\u027d"+
		"\3\2\2\2\u027d\u0280\3\2\2\2\u027e\u027c\3\2\2\2\u027f\u0281\7\17\2\2"+
		"\u0280\u027f\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0283\3\2\2\2\u0282\u0284"+
		"\7\f\2\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285"+
		"\u0286\bM\2\2\u0286\u009a\3\2\2\2\u0287\u0288\7\61\2\2\u0288\u0289\7,"+
		"\2\2\u0289\u028a\7,\2\2\u028a\u028b\7\61\2\2\u028b\u028c\3\2\2\2\u028c"+
		"\u028d\bN\2\2\u028d\u009c\3\2\2\2\u028e\u028f\7\61\2\2\u028f\u0290\7,"+
		"\2\2\u0290\u0291\3\2\2\2\u0291\u0295\n\t\2\2\u0292\u0294\13\2\2\2\u0293"+
		"\u0292\3\2\2\2\u0294\u0297\3\2\2\2\u0295\u0296\3\2\2\2\u0295\u0293\3\2"+
		"\2\2\u0296\u0298\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u0299\7,\2\2\u0299"+
		"\u029a\7\61\2\2\u029a\u029b\3\2\2\2\u029b\u029c\bO\2\2\u029c\u009e\3\2"+
		"\2\2\u029d\u029f\t\n\2\2\u029e\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\bP"+
		"\2\2\u02a3\u00a0\3\2\2\2\u02a4\u02a5\13\2\2\2\u02a5\u00a2\3\2\2\2*\2\u010f"+
		"\u0121\u0129\u01d9\u01df\u01e1\u01e9\u01eb\u01ef\u01f4\u01fb\u0202\u0209"+
		"\u020e\u0214\u0218\u021d\u0220\u0226\u022b\u0230\u0233\u023a\u0241\u0246"+
		"\u0248\u024e\u0250\u0258\u025e\u0265\u0267\u026b\u0270\u027c\u0280\u0283"+
		"\u0295\u02a0\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}