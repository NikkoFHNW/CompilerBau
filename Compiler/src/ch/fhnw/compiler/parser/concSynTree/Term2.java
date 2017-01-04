package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Term2 implements IConcSyn.ITerm2 {
    Term3 term3;
    RepTerm3 repTerm3;

    public Term2(Term3 term3, RepTerm3 repTerm3) {
        this.term3 = term3;
        this.repTerm3 = repTerm3;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
