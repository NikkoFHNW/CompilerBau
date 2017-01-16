package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.*;

public class RepCommaExpr implements IConcSyn.IRepCommaExpr {
    Expr expr;
    RepCommaExpr next;

    public RepCommaExpr(Expr expr) {
        this.expr = expr;
    }

    public void setNext(RepCommaExpr next) {
        this.next = next;
    }


    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError {
        if (next instanceof RepCommaExprEps)
            return this.expr.toAbstrSyntax();
        else
            return next.toAbstrSyntax(this.expr.toAbstrSyntax());



    }
}
