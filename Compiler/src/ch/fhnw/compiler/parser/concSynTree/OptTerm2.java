package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptTerm2 implements IConcSyn.ITerm2{
    Term2 term2;

    public OptTerm2(Term2 term2) {
        this.term2 = term2;
    }


    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
