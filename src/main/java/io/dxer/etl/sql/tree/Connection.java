package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;
import java.util.Properties;

import static com.google.common.base.Objects.toStringHelper;

public class Connection extends Statement {

    private String name;

    private Properties properties;

    private OperType operType;

    public enum OperType {
        CREATE,
        DROP,
        SHOW
    }

    public Connection(NodeLocation location, OperType operType, String name, Properties properties) {
        super(Optional.fromNullable(location));
        this.operType = Preconditions.checkNotNull(operType, "operType is null");
        this.name = Preconditions.checkNotNull(name, "connect name is null");
        if (this.operType == OperType.CREATE) {
            this.properties = Preconditions.checkNotNull(properties, "properties is null");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(properties.getProperty("url")), "url is null");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(properties.getProperty("driver")), "driver is null");
            Preconditions.checkArgument(properties.getProperty("user") != null, "user is null");
            Preconditions.checkArgument(properties.getProperty("password") != null, "password is null");
        }
    }

    protected Connection(Optional<NodeLocation> location) {
        super(location);
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

    public OperType getOperType() {
        return operType;
    }

    public String getName() {
        return name;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getJDBCUrl() {
        return properties.getProperty("url");
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }

    public Properties getConnectionProperties() {
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("driver", properties.getProperty("driver"));
        connectionProperties.setProperty("user", properties.getProperty("user"));
        connectionProperties.setProperty("password", properties.getProperty("password"));

        return connectionProperties;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public boolean isAvailable() {
        if (!Strings.isNullOrEmpty(name) &&
                properties != null &&
                !Strings.isNullOrEmpty(properties.getProperty("driver")) &&
                !Strings.isNullOrEmpty(properties.getProperty("url")) &&
                properties.containsKey("user") &&
                properties.containsKey("password")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("operType", operType)
                .add("name", name)
                .add("properties", properties)
                .toString();
    }
}
