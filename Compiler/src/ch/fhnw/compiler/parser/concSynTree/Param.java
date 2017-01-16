package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Param implements IConcSyn.IParam {
    OptFlowMode optFlowMode;
    OptMechMode optMechMode;
    OptChangeMode optChangeMode;
    IParam typedIdentOrRecIdent;

    Param next;

    public Param(OptFlowMode optFlowMode, OptMechMode optMechMode, OptChangeMode optChangeMode, IParam param, Param next) {
        this.optFlowMode = optFlowMode;
        this.optMechMode = optMechMode;
        this.optChangeMode = optChangeMode;
        this.typedIdentOrRecIdent = param;
        this.next = next;
    }


    public void setNext(Param next) {
        this.next = next;
    }

    @Override
    public IAbs.IParam toAbstrSyntax() {
        if (next != null)
            return new ch.fhnw.compiler.parser.abs.Param(optFlowMode.toAbstrSyntax(),optMechMode.toAbstrSyntax(),optChangeMode.toAbstrSyntax(),typedIdentOrRecIdent.toAbstrSyntax(), next.toAbstrSyntax());

        return new ch.fhnw.compiler.parser.abs.Param(optFlowMode.toAbstrSyntax(),optMechMode.toAbstrSyntax(),optChangeMode.toAbstrSyntax(),typedIdentOrRecIdent.toAbstrSyntax(), null);

    }
}
