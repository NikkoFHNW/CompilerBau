package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class StoDecl implements IConcSyn.IStoDecl {
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;

    public StoDecl(OptChangeMode optChangeMode, TypedIdent typedIdent) {
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
    }
    @Override
    public IAbs.IStoDecl toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.StoDecl(optChangeMode.toAbstrSyntax(), typedIdent.toAbstrSyntax());
    }
}
