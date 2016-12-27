package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class Idents implements IConcSynWrapper {
    Token ident;
    RepCommaIdent repCommaIdent;

    public Idents(Token ident, RepCommaIdent repCommaIdent) {
        this.ident = ident;
        this.repCommaIdent = repCommaIdent;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
