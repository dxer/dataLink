package io.dxer.etl.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request {
    private String sql;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
