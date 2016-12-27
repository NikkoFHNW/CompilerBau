package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Param implements IConcSynWrapper {
    OptFlowMode optFlowMode;
    OptMechMode optMechMode;
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;
    RecordParam recordParam;

    public Param(OptFlowMode optFlowMode, OptMechMode optMechMode, OptChangeMode optChangeMode, TypedIdent typedIdent, RecordParam recordParam) {
        this.optFlowMode = optFlowMode;
        this.optMechMode = optMechMode;
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
        this.recordParam = recordParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
