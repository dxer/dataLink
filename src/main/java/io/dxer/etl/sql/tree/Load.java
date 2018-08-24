package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Properties;

import static com.google.common.base.Objects.toStringHelper;

public class Load extends Statement {

    private boolean isLocal = false;

    private String format;

    private String path;

    private Properties properties;

    private String tableName;

    protected Load(Optional<NodeLocation> location) {
        super(location);
    }

    public Load(NodeLocation location, boolean isLocal, String format, String path, Properties properties, String tableName) {
        super(Optional.fromNullable(location));
        this.isLocal = isLocal;
        this.format = Preconditions.checkNotNull(format, "format is null");
        this.path = Preconditions.checkNotNull(path, "path is null");
        this.properties = properties;
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

    public boolean isLocal() {
        return isLocal;
    }

    public String getFormat() {
        return format;
    }

    public String getPath() {
        return path;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getTableName() {
        return tableName;
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
                .add("isLocal", isLocal)
                .add("format", format)
                .add("path", path)
                .add("properties", properties)
                .add("tableName", tableName)
                .toString();
    }
}