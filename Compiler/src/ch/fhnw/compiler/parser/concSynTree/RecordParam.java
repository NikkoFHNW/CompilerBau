package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordParam implements IConcSynWrapper{
    TokenTupel ident;
    TokenTupel recident;

    public RecordParam(TokenTupel ident, TokenTupel recIdent) {
        this.ident = ident;
        this.recident = recIdent;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
