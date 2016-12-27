package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class OptFlowMode implements IConcSynWrapper {
    Token flowMode;

    public OptFlowMode(Token flowMode) {
        this.flowMode = flowMode;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
