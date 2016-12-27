package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class OptTerm2 implements IConcSynWrapper{
    Token relopr;
    Term2 term2;

    public OptTerm2(Token relopr, Term2 term2) {
        this.relopr = relopr;
        this.term2 = term2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
