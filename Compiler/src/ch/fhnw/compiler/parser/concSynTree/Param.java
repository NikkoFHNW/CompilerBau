package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Param implements IConcSyn.IParam {
    OptFlowMode optFlowMode;
    OptMechMode optMechMode;
    OptChangeMode optChangeMode;
    IParam typedIdentOrRecIdent;

    public Param(OptFlowMode optFlowMode, OptMechMode optMechMode, OptChangeMode optChangeMode, IParam param) {
        this.optFlowMode = optFlowMode;
        this.optMechMode = optMechMode;
        this.optChangeMode = optChangeMode;
        this.typedIdentOrRecIdent = param;
    }


    @Override
    public IAbs.IParam toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.Param(optFlowMode.toAbstrSyntax(),optMechMode.toAbstrSyntax(),optChangeMode.toAbstrSyntax(),typedIdentOrRecIdent.toAbstrSyntax());
    }
}
