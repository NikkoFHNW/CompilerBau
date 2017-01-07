package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsDecl implements IConcSyn.ICpsDecl {
    IDecl decl;
    RepSemicolonDecl repSemicolonDecl;

    public CpsDecl(IDecl decl, RepSemicolonDecl repSemicolonDecl) {
        this.decl = decl;
        this.repSemicolonDecl = repSemicolonDecl;
    }

    @Override
    public IAbs.ICpsDecl toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.CpsDecl(decl.toAbstrSyntax(), repSemicolonDecl.toAbstrSyntax());
    }
}
