package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Param implements IConcSyn.IParam {
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
    public IAbs.IParam toAbstrSyntax(IRepCommaParam repParam) {
        return null;
    }
}
