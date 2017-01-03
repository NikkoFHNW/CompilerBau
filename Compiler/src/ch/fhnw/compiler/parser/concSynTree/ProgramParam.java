package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class ProgramParam implements IConcSynWrapper {
    OptFlowMode optFlowMode;
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;

    public ProgramParam(OptFlowMode optFlowMode, OptChangeMode optChangeMode, TypedIdent typedIdent) {
        this.optFlowMode = optFlowMode;
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
