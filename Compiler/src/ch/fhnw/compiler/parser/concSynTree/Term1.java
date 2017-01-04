package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Term1 implements IConcSyn.ITerm1 {
    Term2 term2;
    OptTerm2 optTerm2;

    public Term1(Term2 term2, OptTerm2 optTerm2) {
        this.term2 = term2;
        this.optTerm2 = optTerm2;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
