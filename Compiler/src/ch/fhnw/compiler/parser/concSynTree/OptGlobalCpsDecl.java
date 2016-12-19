package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.scanner.data.Terminal;

public class OptGlobalCpsDecl implements IConcSynWrapper {
    Terminal global;
    CpsDecl cpsDecl;

    public OptGlobalCpsDecl(Terminal global, CpsDecl cpsDecl) {
        this.global = global;
        this.cpsDecl = cpsDecl;
    }
}
