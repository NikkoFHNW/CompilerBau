package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class GlobInits implements IConcSynWrapper{
    Idents idents;

    public GlobInits(Idents idents) {
        this.idents = idents;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
