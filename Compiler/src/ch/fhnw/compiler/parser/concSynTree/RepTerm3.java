package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprDyadic;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepTerm3 implements IConcSyn.IRepTerm3 {
    TokenTupel addOpr;
    Term3 term3;
    RepTerm3 next;

    public RepTerm3(TokenTupel addOpr, Term3 term3) {
        this.addOpr = addOpr;
        this.term3 = term3;
    }

    public void setNext(RepTerm3 next) {
        this.next = next;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) {
        ExprDyadic exprDyadic = new ExprDyadic(addOpr, expr, term3.toAbstrSyntax());
        return next.toAbstrSyntax(exprDyadic);
    }
}
