package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.*;
import ch.fhnw.compiler.parser.abs.Param;

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
    public IAbs.IParam toAbstrSyntax() {
        return new Param(optFlowMode.toAbstrSyntax(), null,  optChangeMode.toAbstrSyntax(), typedIdent.toAbstrSyntax());
    }
}
