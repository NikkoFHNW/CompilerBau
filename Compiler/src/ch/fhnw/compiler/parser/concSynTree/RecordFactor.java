package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordFactor implements IConcSynWrapper {
    TokenTupel ident1;
    TokenTupel ident2;

    public RecordFactor(TokenTupel ident1, TokenTupel ident2) {
        this.ident1 = ident1;
        this.ident2 = ident2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
