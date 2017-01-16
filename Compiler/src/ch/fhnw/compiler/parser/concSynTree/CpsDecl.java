package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsDecl implements IConcSyn.IDecl {
    IDecl decl;
    RepSemicolonDecl repSemicolonDecl;

    public CpsDecl(IDecl decl, RepSemicolonDecl repSemicolonDecl) {
        this.decl = decl;
        this.repSemicolonDecl = repSemicolonDecl;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() throws GrammarError {
        return new ch.fhnw.compiler.parser.abs.CpsDecl(decl.toAbstrSyntax(), repSemicolonDecl.toAbstrSyntax());
    }
}
