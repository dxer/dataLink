package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;

import java.util.List;

import static com.google.common.base.Objects.toStringHelper;

public class Query extends Statement {

    private String sql;

    protected Query(Optional<NodeLocation> location) {
        super(location);
    }

    public Query(NodeLocation location, String sql) {
        super(Optional.of(location));
        this.sql = sql;
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

    public String getSql() {
        return sql;
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
                .add("sql", sql)
                .toString();
    }
}
