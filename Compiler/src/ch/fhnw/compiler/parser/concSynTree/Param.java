package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Param implements IConcSynWrapper {
    OptFlowMode optFlowMode;
    OptMechMode optMechMode;
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;

    public Param(OptFlowMode optFlowMode, OptMechMode optMechMode, OptChangeMode optChangeMode, TypedIdent typedIdent) {
        this.optFlowMode = optFlowMode;
        this.optMechMode = optMechMode;
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
