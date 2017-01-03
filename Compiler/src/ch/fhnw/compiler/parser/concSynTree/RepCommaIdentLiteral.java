package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepCommaIdentLiteral implements IConcSynWrapper {
    TokenTupel ident;
    TokenTupel literal;

    RepCommaIdentLiteral next;

    public RepCommaIdentLiteral(TokenTupel ident, TokenTupel literal) {
        this.ident = ident;
        this.literal = literal;
    }

    public void setNext(RepCommaIdentLiteral next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }

}
