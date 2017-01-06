package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecConstrIdentFirst extends AbstractRecConstr  {
    TokenTupel ident;
    RepCommaIdentLiteral repCommaIdentLiteral;

    public RecConstrIdentFirst(TokenTupel ident, RepCommaIdentLiteral repCommaIdentLiteral) {
        this.ident = ident;
        this.repCommaIdentLiteral = repCommaIdentLiteral;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        return null;
    }
}
