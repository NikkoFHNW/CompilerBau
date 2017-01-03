package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class FactorMonadic extends AbstractFactor {
    MonadicOpr monadicOpr;
    AbstractFactor factor;

    public FactorMonadic(MonadicOpr monadicOpr, AbstractFactor factor) {
        this.monadicOpr = monadicOpr;
        this.factor = factor;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
