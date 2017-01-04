package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class ProgramParam implements IConcSyn.IParam {
    OptFlowMode optFlowMode;
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;

    public ProgramParam(OptFlowMode optFlowMode, OptChangeMode optChangeMode, TypedIdent typedIdent) {
        this.optFlowMode = optFlowMode;
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
    }

    @Override
    public IAbs.IParam toAbstrSyntax(IRepCommaParam repParam) {
        return null;
    }
}
