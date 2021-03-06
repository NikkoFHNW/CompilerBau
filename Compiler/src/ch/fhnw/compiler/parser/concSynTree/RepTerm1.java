package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.*;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepTerm1 implements IConcSyn.IRepTerm1 {
    TokenTupel boolOpr;
    Term1 term1;
    RepTerm1 next;

    public RepTerm1(TokenTupel boolOpr, Term1 term1) {
        this.boolOpr = boolOpr;
        this.term1 = term1;
    }

    public void setNext(RepTerm1 next) {
        this.next = next;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError {
        if (next != null && !(next instanceof RepTerm1Eps)) {
            ExprDyadic exprDyadic = new ExprDyadic(boolOpr, expr, term1.toAbstrSyntax());
            return next.toAbstrSyntax(exprDyadic);
        } else if (term1 != null){
            term1.toAbstrSyntax();
        }

        return new ch.fhnw.compiler.parser.abs.RepTerm1Eps();


    }
}
