package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class GlobInits implements IConcSynWrapper{
    Token init;
    Idents idents;

    public GlobInits(Token init, Idents idents) {
        this.init = init;
        this.idents = idents;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
