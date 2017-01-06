package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepSemicolonStoDecl implements IConcSyn.IStoDecl {
    StoDecl stoDecl;
    RepSemicolonStoDecl repSemicolonStoDecl;

    public RepSemicolonStoDecl(StoDecl stoDecl, RepSemicolonStoDecl repSemicolonStoDecl) {
        this.stoDecl = stoDecl;
        this.repSemicolonStoDecl = repSemicolonStoDecl;
    }

    @Override
    public IAbs.IStoDecl toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.RepSemicolonStoDecl(stoDecl.toAbstrSyntax(),repSemicolonStoDecl.toAbstrSyntax());
    }
}
