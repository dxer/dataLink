package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.google.common.base.Objects.toStringHelper;

public class Save extends Statement {

    private String tableName;

    private String saveMode;

    private String format;

    private String path;

    private Map<String, String> partitionMap;

    private Properties properties;

    public Save(NodeLocation location, String saveMode, String tableName, String format, String path, Map<String, String> partitionMap, Properties properties) {
        super(Optional.fromNullable(location));
        this.saveMode = saveMode;
        this.tableName = tableName;
        this.format = format;
        this.path = path;
        this.partitionMap = partitionMap;
        this.properties = properties;
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

    public String getSaveMode() {
        return saveMode;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFormat() {
        return format;
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
                .add("saveMode", saveMode)
                .add("tableName", tableName)
                .add("format", format)
                .add("path", path)
                .add("partittionMap", partitionMap)
                .add("properties", properties)
                .toString();
    }
}
