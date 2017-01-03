package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class ExprList implements IConcSynWrapper {
    OptExprRep optExprRep;

    public ExprList(OptExprRep optExprRep) {
        this.optExprRep = optExprRep;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
