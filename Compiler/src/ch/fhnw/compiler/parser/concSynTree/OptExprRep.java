package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptExprRep implements IConcSyn.IOptExprRep{
    Expr expr;
    RepCommaExpr rep;

    public OptExprRep(Expr expr, RepCommaExpr rep) {
        this.expr = expr;
        this.rep = rep;
    }

    @Override
    public IAbs.IExprList toAbstrSyntax() {
        return null;
    }
}
