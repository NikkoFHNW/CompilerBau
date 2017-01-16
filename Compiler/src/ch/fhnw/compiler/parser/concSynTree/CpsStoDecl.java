package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsStoDecl implements IConcSyn.IStoDecl {
    StoDecl stoDecl;
    RepSemicolonStoDecl repSemicolonStoDecl;

    public CpsStoDecl(StoDecl stoDecl, RepSemicolonStoDecl repSemicolonStoDecl) {
        this.stoDecl = stoDecl;
        this.repSemicolonStoDecl = repSemicolonStoDecl;
    }

    @Override
    public IAbs.IStoDecl toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.CpsStoDecl(stoDecl.toAbstrSyntax(),repSemicolonStoDecl.toAbstrSyntax());
    }
}
