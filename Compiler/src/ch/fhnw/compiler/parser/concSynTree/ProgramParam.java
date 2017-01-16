package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.*;
import ch.fhnw.compiler.parser.abs.Param;

public class ProgramParam implements IConcSyn.IParam {
    OptFlowMode optFlowMode;
    OptChangeMode optChangeMode;
    IParam typedIdent;

    ProgramParam next;

    public ProgramParam(OptFlowMode optFlowMode, OptChangeMode optChangeMode, IParam typedIdent, ProgramParam next) {
        this.optFlowMode = optFlowMode;
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
    }

    @Override
    public IAbs.IParam toAbstrSyntax() {
        if (next != null)
            return new Param(optFlowMode.toAbstrSyntax(), null,  optChangeMode.toAbstrSyntax(), typedIdent.toAbstrSyntax(), next.toAbstrSyntax());

        return new Param(optFlowMode.toAbstrSyntax(), null,  optChangeMode.toAbstrSyntax(), typedIdent.toAbstrSyntax(), null);

    }
}
