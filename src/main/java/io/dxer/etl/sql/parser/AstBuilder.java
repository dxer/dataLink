package io.dxer.etl.sql.parser;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.dxer.etl.sql.exception.ParsingException;
import io.dxer.etl.sql.tree.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static java.util.Objects.requireNonNull;

public class AstBuilder extends SqlBaseBaseVisitor<Node> {

    private int parameterPosition;

    private final ParsingOptions parsingOptions;

    AstBuilder(ParsingOptions parsingOptions) {
        this.parsingOptions = requireNonNull(parsingOptions, "parsingOptions is null");
    }

    @Override
    public Node visitSingleStatement(SqlBaseParser.SingleStatementContext context) {
        return visit(context.statement());
    }

    @Override
    public Node visitSingleExpression(SqlBaseParser.SingleExpressionContext context) {
        return visit(context.expression());
    }

    // ******************* statements **********************


    @Override
    public Node visitFileOper(SqlBaseParser.FileOperContext ctx) {
        return new FileOper(getLocation(ctx),
                getTextIfPresent(ctx.operType).get(),
                getPath(ctx.src),
                getPath(ctx.dst),
                ctx.OVERWRITE() != null);
    }

    @Override
    public Node visitConnectStatement(SqlBaseParser.ConnectStatementContext ctx) {
        Connection.OperType type = null;
        if (ctx.CREATE() != null) {
            type = Connection.OperType.CREATE;
        } else if (ctx.DROP() != null) {
            type = Connection.OperType.DROP;
        } else if (ctx.SHOW() != null) {
            type = Connection.OperType.SHOW;
        }

        return new Connection(getLocation(ctx),
                type,
                getTextIfPresent(ctx.conn).orNull(),
                getProperties(ctx.properties()));
    }


    @Override
    public Node visitLoadTable(SqlBaseParser.LoadTableContext ctx) {
        boolean isLocal = ctx.LOCAL() != null;

        return new Load(getLocation(ctx),
                isLocal,
                getTextIfPresent(ctx.format()).orNull(),
                getPath(ctx.path()),
                getProperties(ctx.properties()),
                getTextIfPresent(ctx.tableName).orNull());
    }

    @Override
    public Node visitSave(SqlBaseParser.SaveContext ctx) {
        Map<String, String> partitionMap = getPartitionMap(ctx.partitionSpec());

        String saveMode = getTextIfPresent(ctx.saveMode).orNull();

        return new Save(getLocation(ctx),
                saveMode,
                getTextIfPresent(ctx.tableName).orNull(),
                getTextIfPresent(ctx.format()).orNull(),
                getPath(ctx.path()),
                partitionMap,
                getProperties(ctx.properties()));
    }

    @Override
    public Node visitQueryAsTable(SqlBaseParser.QueryAsTableContext ctx) {
        String tableName = getTextIfPresent(ctx.tableName).orNull();

        String originalText = getOriginalText(ctx);
        String query = originalText.replaceAll("(?i)as[\\s|\\n]+" + tableName, "");

        return new QueryAsTable(getLocation(ctx), query, tableName);
    }

    @Override
    public Node visitQuery(SqlBaseParser.QueryContext ctx) {
        String originalText = getOriginalText(ctx);
        return new Query(getLocation(ctx), originalText);
    }

    @Override
    public Node visitInsertIntoStatement(SqlBaseParser.InsertIntoStatementContext ctx) {
        SqlBaseParser.InsertIntoContext insertInto = ctx.insertInto();
        String saveMode = getTextIfPresent(insertInto.saveMode).orNull();

        boolean isLocal = insertInto.LOCAL() != null ? true : false;

        Properties props = getProperties(insertInto.properties());

        String format = getTextIfPresent(insertInto.format()).orNull();
        String path = getPath(insertInto.path());

        Map<String, String> partitionMap = getPartitionMap(insertInto.partitionSpec());

        boolean isQuery = false;

        String str = null;
        if (ctx.query() != null) {
            isQuery = true;
            str = getOriginalText(ctx.query());
        } else {
            str = getTextIfPresent(ctx.tableName).orNull();
        }
        return new InsertInto(getLocation(ctx),
                saveMode,
                isLocal,
                format,
                path,
                partitionMap,
                props,
                isQuery,
                str);
    }

    @Override
    public Node visitExecStatement(SqlBaseParser.ExecStatementContext ctx) {
        String originalText = getOriginalText(ctx);
        String command = originalText.replaceFirst("(?i)exec[\\s|\\n]" , "");

        return super.visitExecStatement(ctx);
    }

    @Override
    public Node visitProperty(SqlBaseParser.PropertyContext context) {
        String value = null;

        if (context.value != null && context.value.STRING() != null) {
            value = unquote(getTextIfPresent(context.value).orNull());
        } else {
            value = getTextIfPresent(context.value).orNull();
        }

        return new Property(getLocation(context),
                getTextIfPresent(context.key).orNull(),
                value);
    }

    // ***************** helpers *****************


    private <T> Optional<T> visitIfPresent(ParserRuleContext context, Class<T> clazz) {
        return Optional.fromNullable(clazz.cast(visit(context)));
    }

    private <T> List<T> visit(List<? extends ParserRuleContext> contexts, Class<T> clazz) {
        List<T> result = Lists.newArrayList();
        for (ParserRuleContext c : contexts) {
            Object o = this.visit(c);
            if (o != null) {
                result.add(clazz.cast(o));
            }
        }

        return result;
    }


    private static boolean isHexDigit(char c) {
        return ((c >= '0') && (c <= '9')) ||
                ((c >= 'A') && (c <= 'F')) ||
                ((c >= 'a') && (c <= 'f'));
    }

    private static boolean isValidUnicodeEscape(char c) {
        return c < 0x7F && c > 0x20 && !isHexDigit(c) && c != '"' && c != '+' && c != '\'';
    }

    private static Optional<String> getTextIfPresent(ParserRuleContext context) {
        if (context != null) {
            return Optional.fromNullable(context.getText());
        }
        return Optional.fromNullable(null);
    }

    private static Optional<String> getTextIfPresent(Token token) {
        if (token != null) {
            return Optional.fromNullable(token.getText());
        }
        return Optional.fromNullable(null);
    }

    private static String unquote(String value) {
        if (Strings.isNullOrEmpty(value) || value.length() < 2) {
            return null;
        }
        return value.substring(1, value.length() - 1)
                .replace("''", "'");
    }

    private static String getPath(SqlBaseParser.PathContext pathContext) {
        if (pathContext != null) {
            if (null != pathContext.BACKQUOTED_IDENTIFIER()) {
                return unBackQuote(getTextIfPresent(pathContext).orNull());
            } else if (null != pathContext.identifier()) {
                return unquote(getTextIfPresent(pathContext).orNull());
            }
        }
        return null;
    }

    private static String unBackQuote(String value) {
        if (Strings.isNullOrEmpty(value) || value.length() < 2) {
            return null;
        }
        return value.substring(1, value.length() - 1);
    }

    private static String getOriginalText(ParserRuleContext ctx) {
        if (ctx == null) {
            return null;
        }
        int start = ctx.start.getStartIndex();
        int stop = ctx.stop.getStopIndex();
        Interval interval = new Interval(start, stop);
        String originalText = ((SqlBaseLexer) ctx.start.getTokenSource())._input.getText(interval);

        return originalText;
    }

    private Properties getProperties(SqlBaseParser.PropertiesContext ctx) {
        Properties props = null;
        List<Property> properties = null;
        if (ctx != null && ctx.property() != null) {
            properties = visit(ctx.property(), Property.class);
        }

        if (properties != null && !properties.isEmpty()) {
            props = new Properties();
            for (Property p : properties) {
                if (!Strings.isNullOrEmpty(p.getKey())) {
                    props.setProperty(p.getKey(), p.getValue());
                }
            }
        }
        return props;
    }

    private Map<String, String> getPartitionMap(SqlBaseParser.PartitionSpecContext ctx) {
        Map<String, String> partitionMap = null;
        if (ctx != null) {
            List<SqlBaseParser.PartitionValContext> partitionValContexts = ctx.partitionVal();
            if (partitionValContexts != null) {
                partitionMap = Maps.newHashMap();
                for (SqlBaseParser.PartitionValContext p : partitionValContexts) {
                    String colName = getTextIfPresent(p.identifier()).orNull();
                    String partitionVal = getTextIfPresent(p.constant()).orNull();

                    partitionMap.put(colName, partitionVal);
                }
            }
        }
        return partitionMap;
    }

    private static void check(boolean condition, String message, ParserRuleContext context) {
        if (!condition) {
            throw parseError(message, context);
        }
    }

    public static NodeLocation getLocation(TerminalNode terminalNode) {
        requireNonNull(terminalNode, "terminalNode is null");
        return getLocation(terminalNode.getSymbol());
    }

    public static NodeLocation getLocation(ParserRuleContext parserRuleContext) {
        requireNonNull(parserRuleContext, "parserRuleContext is null");
        return getLocation(parserRuleContext.getStart());
    }

    public static NodeLocation getLocation(Token token) {
        requireNonNull(token, "token is null");
        return new NodeLocation(token.getLine(), token.getCharPositionInLine());
    }

    private static ParsingException parseError(String message, ParserRuleContext context) {
        return new ParsingException(message, null, context.getStart().getLine(), context.getStart().getCharPositionInLine());
    }
}
