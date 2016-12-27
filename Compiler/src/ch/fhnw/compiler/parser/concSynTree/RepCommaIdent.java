package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaIdent implements IConcSynWrapper{
    Token comma;
    Token ident;
    RepCommaIdent repCommaIdent;


    public RepCommaIdent(Token comma, Token ident, RepCommaIdent repCommaIdent) {
        this.comma = comma;
        this.ident = ident;
        this.repCommaIdent = repCommaIdent;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
