package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepFactor implements IConcSynWrapper {
    Token multopr;
    Factor factor;
    RepFactor repFactor;

    public RepFactor(Token multopr, Factor factor, RepFactor repFactor) {
        this.multopr = multopr;
        this.factor = factor;
        this.repFactor = repFactor;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
