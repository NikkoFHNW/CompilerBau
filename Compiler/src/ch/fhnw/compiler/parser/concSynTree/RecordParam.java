package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RecordParam implements IConcSynWrapper{
    Token dot;
    Token ident;
    Token colon;
    Token recident;

    public RecordParam(Token dot, Token ident, Token colon, Token recident) {
        this.dot = dot;
        this.ident = ident;
        this.colon = colon;
        this.recident = recident;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
