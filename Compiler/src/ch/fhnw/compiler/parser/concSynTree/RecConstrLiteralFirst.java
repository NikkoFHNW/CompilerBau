package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecConstrLiteralFirst implements IConcSynWrapper {
    TokenTupel literal;
    RepCommaIdentLiteral repCommaIdentLiteral;

    public RecConstrLiteralFirst(TokenTupel literal, RepCommaIdentLiteral repCommaIdentLiteral) {
        this.literal = literal;
        this.repCommaIdentLiteral = repCommaIdentLiteral;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
