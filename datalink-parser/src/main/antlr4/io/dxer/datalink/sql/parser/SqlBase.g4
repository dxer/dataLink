grammar SqlBase;

@members {
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
}


statements
    : (singleStatement)* EOF
    ;

singleStatement
    : statement ';'
    ;

singleExpression
    : expression EOF
    ;

statement
    : query                                                                                 #queryStatement
    | CREATE TEMPORARY? CONNECTION (IF NOT EXISTS)?
        connectionType '.' name=IDENTIFIER WITH? properties                                 #createConnection
    | DROP TEMPORARY?  CONNECTION  (IF EXISTS)? connectionType '.' name=IDENTIFIER          #dropConnection
    | SHOW CREATE CONNECTION connectionType '.' name=IDENTIFIER                             #showCreateConnection
    | SHOW CONNECTIONS (IN identifier (LIKE pattern=STRING)?)?                          #showConnections
    | LOAD DATA LOCAL? format '.' path (OPTIONS options=properties)?
       ((OVERWRITE? INTO) | AS) tableName=tableIdentifier partitionSpec?                    #loadTable
    | INSERT OVERWRITE LOCAL? format '.' path (OPTIONS options=properties)?
       (query | tableName=identifier)                                                                 #insertInto
    | query AS tableName=identifier                                                         #queryAsTable
    | EXEC func=identifier funcParams                                                       #execFunc
    | ~(';')*                                                                               #test
    ;

expression
    :
    ;

query
    : SELECT ~(';')*
    ;

connectionType
    : JDBC | HBASE | FTP | SFTP | SSH | MAIL | REDIS
    ;

format
    : identifier
    ;

path
    : identifier | BACKQUOTED_IDENTIFIER
    ;

tableIdentifier
    : (db=identifier '.')? table=identifier
    ;

partitionSpec
    : PARTITION '(' partitionVal (',' partitionVal)* ')'
    ;

partitionVal
    : identifier (EQ constant)?
    ;

properties
    : '(' property (',' property)* ')'
    ;

property
    : key=propertyKey (EQ? value=propertyValue)?
    ;

propertyKey
    : identifier ('.' identifier)*
    | STRING
    ;

propertyValue
    : INTEGER_VALUE
    | DECIMAL_VALUE
    | booleanValue
    | STRING
    ;

funcParams
    : '(' params (',' params)* ')'
    ;

params
    : INTEGER_VALUE
    | DECIMAL_VALUE
    | booleanValue
    | STRING
    ;

booleanValue
    : TRUE | FALSE
    ;

constant
    : NULL                                                                                     #nullLiteral
    | interval                                                                                 #intervalLiteral
    | identifier STRING                                                                        #typeConstructor
    | number                                                                                   #numericLiteral
    | booleanValue                                                                             #booleanLiteral
    | STRING+                                                                                  #stringLiteral
    ;

interval
    : INTERVAL intervalField*
    ;

intervalField
    : value=intervalValue unit=identifier (TO to=identifier)?
    ;

intervalValue
    : (PLUS | MINUS)? (INTEGER_VALUE | DECIMAL_VALUE)
    | STRING
    ;

number
    : MINUS? DECIMAL_VALUE            #decimalLiteral
    | MINUS? INTEGER_VALUE            #integerLiteral
    | MINUS? BIGINT_LITERAL           #bigIntLiteral
    | MINUS? SMALLINT_LITERAL         #smallIntLiteral
    | MINUS? TINYINT_LITERAL          #tinyIntLiteral
    | MINUS? DOUBLE_LITERAL           #doubleLiteral
    | MINUS? BIGDECIMAL_LITERAL       #bigDecimalLiteral
    ;

identifier
    : strictIdentifier
//    | ANTI | FULL | INNER | LEFT | SEMI | RIGHT | NATURAL | JOIN | CROSS | ON
//    | UNION | INTERSECT | EXCEPT | SETMINUS
    ;

strictIdentifier
    : IDENTIFIER             #unquotedIdentifier
    | quotedIdentifier       #quotedIdentifierAlternative
    ;

quotedIdentifier
    : BACKQUOTED_IDENTIFIER
    ;

INSERT: 'INSERT';
CREATE: 'CREATE';
DROP: 'DROP';
SHOW: 'SHOW';
SELECT: 'SELECT';
WITH: 'WITH';
TRUE: 'TRUE';
FALSE: 'FALSE';
PARTITION: 'PARTITION';
NULL: 'NULL';
INTERVAL: 'INTERVAL';
TO: 'TO';
AS: 'AS';
LIKE: 'LIKE';
INTO: 'INTO';
IN: 'IN';
FROM: 'FROM';

EQ  : '=' | '==';
NSEQ: '<=>';
NEQ : '<>';
NEQJ: '!=';
LT  : '<';
LTE : '<=' | '!>';
GT  : '>';
GTE : '>=' | '!<';



PLUS: '+';
MINUS: '-';
ASTERISK: '*';
SLASH: '/';
PERCENT: '%';
DIV: 'DIV';
TILDE: '~';
AMPERSAND: '&';
PIPE: '|';
CONCAT_PIPE: '||';
HAT: '^';


OVERWRITE: 'OVERWRITE';
LOAD: 'LOAD';
DATA: 'DATA';
OPTIONS: 'OPTIONS';
CONNECTION: 'CONNECTION';
CONNECTIONS: 'CONNECTIONS';
LOCATION: 'LOCATION';
APPEND: 'APPEND';
ERROR_IF_EXISTS: 'ERROR_IF_EXISTS';
IGNORE: 'IGNORE';
LOCAL: 'LOCAL';
EXEC: 'EXEC';
JDBC: 'JDBC';
HBASE: 'HBASE';
FTP: 'FTP';
SFTP: 'SFTP';
SSH: 'SSH';
MAIL: 'MAIL';
REDIS: 'REDIS';
TEMPORARY: 'TEMPORARY' | 'TEMP';



STRING
    : '\'' ( ~('\''|'\\') | ('\\' .) )* '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )* '"'
    ;

BIGINT_LITERAL
    : DIGIT+ 'L'
    ;

SMALLINT_LITERAL
    : DIGIT+ 'S'
    ;

TINYINT_LITERAL
    : DIGIT+ 'Y'
    ;

INTEGER_VALUE
    : DIGIT+
    ;

DECIMAL_VALUE
    : DIGIT+ EXPONENT
    | DECIMAL_DIGITS EXPONENT? {isValidDecimal()}?
    ;

DOUBLE_LITERAL
    : DIGIT+ EXPONENT? 'D'
    | DECIMAL_DIGITS EXPONENT? 'D' {isValidDecimal()}?
    ;

BIGDECIMAL_LITERAL
    : DIGIT+ EXPONENT? 'BD'
    | DECIMAL_DIGITS EXPONENT? 'BD' {isValidDecimal()}?
    ;

IDENTIFIER
    : (LETTER | DIGIT | '_')+
    ;

BACKQUOTED_IDENTIFIER
    : '`' ( ~'`' | '``' )* '`'
    ;

fragment DECIMAL_DIGITS
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

fragment EXPONENT
    : 'E' [+-]? DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [A-Z]
    ;

SIMPLE_COMMENT
    : '--' ~[\r\n]* '\r'? '\n'? -> channel(HIDDEN)
    ;

BRACKETED_EMPTY_COMMENT
    : '/**/' -> channel(HIDDEN)
    ;

BRACKETED_COMMENT
    : '/*' ~[+] .*? '*/' -> channel(HIDDEN)
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;
