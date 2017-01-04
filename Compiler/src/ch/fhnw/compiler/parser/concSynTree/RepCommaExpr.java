package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaExpr implements IConcSyn.IExpr {
    Expr expr;
    RepCommaExpr next;

    public RepCommaExpr(Expr expr) {
        this.expr = expr;
    }

    public void setNext(RepCommaExpr next) {
        this.next = next;
    }


    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
