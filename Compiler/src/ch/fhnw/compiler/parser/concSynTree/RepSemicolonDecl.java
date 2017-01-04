package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepSemicolonDecl implements IConcSyn.IDecl {
    Decl decl;
    RepSemicolonDecl repSemicolonDecl;

    public RepSemicolonDecl(Decl decl, RepSemicolonDecl repSemicolonDecl) {
        this.decl = decl;
        this.repSemicolonDecl = repSemicolonDecl;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
