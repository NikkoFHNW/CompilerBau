package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Expr implements IConcSyn.IExpr {
    Term1 term1;
    RepTerm1 next;

    public Expr(Term1 term1, RepTerm1 next) {
        this.term1 = term1;
        this.next = next;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        if (next != null)
            return next.toAbstrSyntax(term1.toAbstrSyntax());
        else return term1.toAbstrSyntax();
    }
}
