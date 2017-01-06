package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Term1 implements IConcSyn.ITerm1 {
    Term2 term2;
    RepTerm2 repTerm2;  // gemäss folien Optional(slides8, s7), aber relOpr without second expression?? darum rep..

    public Term1(Term2 term2, RepTerm2 repTerm2) {
        this.term2 = term2;
        this.repTerm2 = repTerm2;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        if (repTerm2 != null)
            return repTerm2.toAbstrSyntax(term2.toAbstrSyntax());
        else
            return term2.toAbstrSyntax();
    }
}
