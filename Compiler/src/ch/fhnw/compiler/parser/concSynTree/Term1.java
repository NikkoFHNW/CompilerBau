package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Term1 implements IConcSynWrapper{
    Term2 term2;
    OptTerm2 optTerm2;

    public Term1(Term2 term2, OptTerm2 optTerm2) {
        this.term2 = term2;
        this.optTerm2 = optTerm2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
