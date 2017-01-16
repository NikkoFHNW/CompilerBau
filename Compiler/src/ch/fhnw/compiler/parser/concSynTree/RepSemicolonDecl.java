package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.*;
import ch.fhnw.compiler.parser.abs.CpsDecl;

public class RepSemicolonDecl implements IConcSyn.IDecl {
    IDecl decl;
    RepSemicolonDecl repSemicolonDecl;

    public RepSemicolonDecl(IDecl decl, RepSemicolonDecl repSemicolonDecl) {
        this.decl = decl;
        this.repSemicolonDecl = repSemicolonDecl;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() throws GrammarError {
        return new CpsDecl(decl.toAbstrSyntax(), repSemicolonDecl.toAbstrSyntax());
    }
}
