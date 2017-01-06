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
    public IAbs.IExpr toAbstrSyntax() {
        if (rep == null)
            return expr.toAbstrSyntax();
        else {
            return rep.toAbstrSyntax(expr.toAbstrSyntax());
        }

    }
}
