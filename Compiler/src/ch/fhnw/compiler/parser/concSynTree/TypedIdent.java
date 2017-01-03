package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class TypedIdent implements IConcSynWrapper{
    TokenTupel ident;
    TokenTupel atomtype;

    public TypedIdent(TokenTupel ident, TokenTupel at) {
        this.ident = ident;
        this.atomtype = at;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
