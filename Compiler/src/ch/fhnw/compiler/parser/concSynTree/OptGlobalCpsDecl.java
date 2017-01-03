package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class OptGlobalCpsDecl implements IConcSynWrapper {
    Token global;
    CpsDecl cpsDecl;

    public OptGlobalCpsDecl(Token global, CpsDecl cpsDecl) {
        this.global = global;
        this.cpsDecl = cpsDecl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}