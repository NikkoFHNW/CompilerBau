package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsStoDecl implements IConcSyn.ICpsDecl {
    StoDecl stoDecl;
    RepSemicolonStoDecl repSemicolonStoDecl;

    public CpsStoDecl(StoDecl stoDecl, RepSemicolonStoDecl repSemicolonStoDecl) {
        this.stoDecl = stoDecl;
        this.repSemicolonStoDecl = repSemicolonStoDecl;
    }

    @Override
    public IAbs.ICpsDecl toAbstrSyntax() {
        return null;
    }
}
