package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.ExprDyadic;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.OptTerm2Eps;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepTerm2 implements IConcSyn.IOptTerm2{
    TokenTupel relOpr;
    Term2 term2;
    RepTerm2 next;

    public RepTerm2(TokenTupel relOpr, Term2 term2) {
        this.relOpr = relOpr;
        this.term2 = term2;
    }

    public void setNext(RepTerm2 next) {
        this.next = next;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError {
        if (next != null && !(next instanceof RepTerm2Eps)) {
            ExprDyadic exprDyadic = new ExprDyadic(relOpr, expr, term2.toAbstrSyntax());
            return next.toAbstrSyntax(exprDyadic);
        } else if (term2 != null)
            return term2.toAbstrSyntax();

        return new OptTerm2Eps();
    }
}
