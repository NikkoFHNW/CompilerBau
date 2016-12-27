package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Term3 implements IConcSynWrapper{
    Factor factor;
    RepFactor repFactor;

    public Term3(Factor factor, RepFactor repFactor) {
        this.factor = factor;
        this.repFactor = repFactor;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
