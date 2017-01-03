package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecConstrIdentFirst implements IConcSynWrapper {
    TokenTupel ident;
    RepCommaIdentLiteral repCommaIdentLiteral;

    public RecConstrIdentFirst(TokenTupel ident, RepCommaIdentLiteral repCommaIdentLiteral) {
        this.ident = ident;
        this.repCommaIdentLiteral = repCommaIdentLiteral;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
