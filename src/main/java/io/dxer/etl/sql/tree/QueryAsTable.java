package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import java.util.List;

import static com.google.common.base.Objects.toStringHelper;

public class QueryAsTable extends Statement {

    private String tableName;

    private String query;

    protected QueryAsTable(Optional<NodeLocation> location) {
        super(location);
    }

    public QueryAsTable(NodeLocation location, String query, String tableName) {
        super(Optional.fromNullable(location));
        this.query = Preconditions.checkNotNull(query, "query is null");
        this.tableName = Preconditions.checkNotNull(tableName, "tablename is null");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return super.accept(visitor, context);
    }

    @Override
    public Optional<NodeLocation> getLocation() {
        return super.getLocation();
    }

    @Override
    public List<? extends Node> getChildren() {
        return null;
    }

    public String getTableName() {
        return tableName;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("query", query)
                .add("tableName", tableName)
                .toString();
    }
}
