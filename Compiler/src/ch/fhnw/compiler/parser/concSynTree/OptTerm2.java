package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class OptTerm2 implements IConcSynWrapper{
    Term2 term2;

    public OptTerm2(Term2 term2) {
        this.term2 = term2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}