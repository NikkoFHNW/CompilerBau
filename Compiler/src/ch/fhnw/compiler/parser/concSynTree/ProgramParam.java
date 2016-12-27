package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class ProgramParam implements IConcSynWrapper {
    OptFlowMode optFlowMode;
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;
    RecordParam recordParam;

    public ProgramParam(OptFlowMode optFlowMode, OptChangeMode optChangeMode, TypedIdent typedIdent, RecordParam recordParam) {
        this.optFlowMode = optFlowMode;
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
        this.recordParam = recordParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
