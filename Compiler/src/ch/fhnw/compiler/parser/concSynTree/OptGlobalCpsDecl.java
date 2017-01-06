package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptGlobalCpsDecl implements IConcSyn.ICpsDecl {
    CpsDecl cpsDecl;

    public OptGlobalCpsDecl(CpsDecl cpsDecl) {
        this.cpsDecl = cpsDecl;
    }

    @Override
    public IAbs.ICpsDecl toAbstrSyntax() {
        return cpsDecl.toAbstrSyntax();
    }
}
