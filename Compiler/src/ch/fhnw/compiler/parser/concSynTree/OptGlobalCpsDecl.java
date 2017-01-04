package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptGlobalCpsDecl implements IConcSyn.IStoDecl {
    Token global;
    CpsDecl cpsDecl;

    public OptGlobalCpsDecl(Token global, CpsDecl cpsDecl) {
        this.global = global;
        this.cpsDecl = cpsDecl;
    }

    @Override
    public IAbs.IStoDecl toAbstrSyntax() {
        return null;
    }
}
