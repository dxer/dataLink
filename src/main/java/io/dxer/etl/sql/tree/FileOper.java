package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;

import java.util.List;

public class FileOper extends Statement {

    private String operType;

    private boolean isOverwrite = false;

    private String src;

    private String dst;

    public FileOper(Optional<NodeLocation> location, String operType, String src, String dst, boolean isOverwrite) {
        super(location);
        this.operType = operType;
        this.src = src;
        this.dst = dst;
        this.isOverwrite = isOverwrite;
    }

    public FileOper(NodeLocation location, String operType, String src, String dst, boolean isOverwrite) {
        this(Optional.fromNullable(location), operType, src, dst, isOverwrite);
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

    public String getOperType() {
        return operType;
    }


    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
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
        return null;
    }
}
