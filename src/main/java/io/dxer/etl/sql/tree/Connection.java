package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;
import java.util.Properties;

import static com.google.common.base.Objects.toStringHelper;

public class Connection extends Statement {

    private ConnectionType connectionType;

    private boolean isTempConnection;

    private String name;

    private Properties properties;

    private OperType operType;

    public enum OperType {
        CREATE("CREATE"),
        DROP("DROP"),
        SHOW("SHOW"),
        SHOW_CONNECTIONS("SHOW_CONNECTIONS");

        private String name;

        OperType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public enum ConnectionType {
        JDBC("jdbc"),
        HBASE("hbase"),
        SSH("ssh"),
        FTP("ftp"),
        NONE("");

        private String name;

        ConnectionType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static ConnectionType getConnectionType(String name) {
            try {
                if (!Strings.isNullOrEmpty(name)) {
                    return valueOf(name.toUpperCase());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return NONE;
        }
    }


    public Connection(OperType operType, boolean isTempConnection, ConnectionType connectionType, String name, Properties properties) {
        super(Optional.<NodeLocation>absent());

        this.operType = Preconditions.checkNotNull(operType, "operType is null");
        this.isTempConnection = isTempConnection;

        if (this.connectionType == null) {
            this.connectionType = ConnectionType.NONE;
        } else {
            this.connectionType = connectionType;
        }

        System.out.println(this.connectionType);

        if (this.operType == OperType.CREATE) {
            //  connection type is necessary where create connection
            Preconditions.checkState(connectionType != null && connectionType != ConnectionType.NONE, "connectionType is null");
        }

        if (this.operType != OperType.SHOW_CONNECTIONS) {
            this.name = Preconditions.checkNotNull(name, "connect name is null");
        }
        if (this.operType == OperType.CREATE && this.connectionType == ConnectionType.JDBC) {
            this.properties = Preconditions.checkNotNull(properties, "properties is null");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(properties.getProperty("url")), "url is null");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(properties.getProperty("driver")), "driver is null");
            Preconditions.checkArgument(properties.getProperty("user") != null, "user is null");
            Preconditions.checkArgument(properties.getProperty("password") != null, "password is null");
        }
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

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public String getName() {
        return name;
    }

    public Properties getProperties() {
        return properties;
    }

    public boolean isTempConnection() {
        return isTempConnection;
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
                .add("operType", operType)
                .add("isTempConnection", isTempConnection)
                .add("connectionType", connectionType)
                .add("name", name)
                .add("properties", properties)
                .toString();
    }
}
