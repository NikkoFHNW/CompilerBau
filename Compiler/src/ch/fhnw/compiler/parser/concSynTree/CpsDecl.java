package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsDecl implements IConcSyn.ICpsDecl {
    Decl decl;
    RepSemicolonDecl repSemicolonDecl;

    public CpsDecl(Decl decl, RepSemicolonDecl repSemicolonDecl) {
        this.decl = decl;
        this.repSemicolonDecl = repSemicolonDecl;
    }

    @Override
    public IAbs.ICpsDecl toAbstrSyntax() {
        return null;
    }
}
