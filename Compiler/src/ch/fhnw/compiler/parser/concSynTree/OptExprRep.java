package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class OptExprRep implements IConcSynWrapper {
    Expr expr;
    RepCommaExpr rep;

    public OptExprRep(Expr expr, RepCommaExpr rep) {
        this.expr = expr;
        this.rep = rep;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
