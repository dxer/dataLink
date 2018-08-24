package io.dxer.etl.sql.tree;

import javax.annotation.Nullable;

public abstract class AstVisitor<R, C> {

    public R process(Node node) {
        return process(node, null);
    }

    public R process(Node node, @Nullable C context) {
        return node.accept(this, context);
    }

    protected R visitNode(Node node, C context) {
        return null;
    }

    protected R visitExpression(Expression node, C context) {
        return visitNode(node, context);
    }

    protected R visitStatement(Statement node, C context) {
        return visitNode(node, context);
    }


    protected R visitIdentifier(Identifier node, C context)
    {
        return visitExpression(node, context);
    }


    protected R visitProperty(Property node, C context)
    {
        return visitNode(node, context);
    }

}
