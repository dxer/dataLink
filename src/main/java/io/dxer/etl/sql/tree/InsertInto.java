package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.google.common.base.Objects.toStringHelper;

public class InsertInto extends Statement {

    private String format;

    private boolean isLocal;

    private String path;

    private Map<String, String> partitionMap;

    private Properties properties;

    private String saveMode;

    private boolean isQuery;

    private String tableName;

    private String query;


    public InsertInto(Optional<NodeLocation> location) {
        super(location);
    }

    public InsertInto(NodeLocation location, String saveMode, boolean isLocal, String format, String path, Map<String, String> partitionMap, Properties properties, boolean isQuery, String str) {
        super(Optional.of(location));
        this.saveMode = saveMode;
        this.isLocal = isLocal;
        this.format = Preconditions.checkNotNull(format, "format is null");
        this.path = Preconditions.checkNotNull(path, "path is null");
        this.partitionMap = partitionMap;
        this.properties = properties;
        if (isQuery) {
            this.query = str;
        } else {
            this.tableName = str;
        }
        Preconditions.checkArgument(!Strings.isNullOrEmpty(query) ||
                !Strings.isNullOrEmpty(tableName), "query or tablename should not be empty");
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

    public String getFormat() {
        return format;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getPartitionMap() {
        return partitionMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getSaveMode() {
        return saveMode;
    }

    public boolean isQuery() {
        return isQuery;
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
                .add("isLocal", isLocal)
                .add("format", format)
                .add("path", path)
                .add("partitionMap", partitionMap)
                .add("properties", properties)
                .add("tableName", tableName)
                .add("query", query)
                .toString();
    }
}
