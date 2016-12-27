package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class OptExprRepCommaExpr implements IConcSynWrapper {
    Expr expr;
    RepCommaExpr repCommaExpr;

    public OptExprRepCommaExpr(Expr expr, RepCommaExpr repCommaExpr) {
        this.expr = expr;
        this.repCommaExpr = repCommaExpr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
