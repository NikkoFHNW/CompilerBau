package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class FactorRecord extends AbstractFactor implements IConcSynWrapper {
    Token ident;
    Token ident2;

    public FactorRecord(Token ident, Token ident2) {
        this.ident = ident;
        this.ident2 = ident2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
