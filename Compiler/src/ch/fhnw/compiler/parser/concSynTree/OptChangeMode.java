package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class OptChangeMode implements IConcSynWrapper {
    Token changeMode;

    public OptChangeMode(Token changeMode) {
        this.changeMode = changeMode;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
