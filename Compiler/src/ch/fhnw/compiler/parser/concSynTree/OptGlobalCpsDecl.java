package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;

public class OptGlobalCpsDecl implements IConcSyn.ICpsDecl {
    CpsDecl cpsDecl;

    public OptGlobalCpsDecl(CpsDecl cpsDecl) {
        this.cpsDecl = cpsDecl;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() throws GrammarError {
        return cpsDecl.toAbstrSyntax();
    }
}
