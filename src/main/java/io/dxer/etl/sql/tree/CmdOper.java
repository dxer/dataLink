package io.dxer.etl.sql.tree;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import java.util.List;

import static com.google.common.base.Objects.toStringHelper;

public class CmdOper extends Statement {

    private String command;

    public CmdOper(NodeLocation location, String command) {
        super(Optional.of(location));
        this.command = Preconditions.checkNotNull(command, "command is null");
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
                .add("command", command)
                .toString();
    }
}
