package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaExpr implements IConcSyn.IRepCommaExpr {
    Expr expr;
    RepCommaExpr next;

    public RepCommaExpr(Expr expr) {
        this.expr = expr;
    }

    public void setNext(RepCommaExpr next) {
        this.next = next;
    }


    //TODO param??
    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) {
        if (next == null) {
            return this.expr.toAbstrSyntax();
        } else
            return next.toAbstrSyntax(this.expr.toAbstrSyntax());
    }
}
