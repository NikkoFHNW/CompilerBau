package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecConstrIdentFirst implements IConcSyn.IRecConstr {
    TokenTupel ident;
    RepCommaIdentLiteral repCommaIdentLiteral;

    public RecConstrIdentFirst(TokenTupel ident, RepCommaIdentLiteral repCommaIdentLiteral) {
        this.ident = ident;
        this.repCommaIdentLiteral = repCommaIdentLiteral;
    }


    @Override
    public IAbs toAbstrSyntax() {
        return null;
    }
}
