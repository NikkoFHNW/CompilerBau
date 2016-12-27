package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class TypedIdent implements IConcSynWrapper{
    Token ident;
    Token colon;
    Token atomtype;

    public TypedIdent(Token ident, Token colon, Token atomtype) {
        this.ident = ident;
        this.colon = colon;
        this.atomtype = atomtype;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
