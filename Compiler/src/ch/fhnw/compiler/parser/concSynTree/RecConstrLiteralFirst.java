package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecConstrLiteralFirst extends AbstractRecConstr {
    TokenTupel literal;
    RepCommaIdentLiteral repCommaIdentLiteral;

    public RecConstrLiteralFirst(TokenTupel literal, RepCommaIdentLiteral repCommaIdentLiteral) {
        this.literal = literal;
        this.repCommaIdentLiteral = repCommaIdentLiteral;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        return null;
    }
}
