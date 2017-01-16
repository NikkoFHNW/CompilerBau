package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.*;
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
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError {
        if (next!= null && !(this.next instanceof RepTerm3Eps)) {
            ExprDyadic exprDyadic = new ExprDyadic(addOpr, expr, term3.toAbstrSyntax());
            return next.toAbstrSyntax(exprDyadic);
        } else if (term3 != null)
            return term3.toAbstrSyntax();

        return (IAbs.IExpr) new ch.fhnw.compiler.parser.abs.RepTerm3Eps();

    }
}
