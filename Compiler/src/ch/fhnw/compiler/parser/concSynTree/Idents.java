package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class Idents implements IConcSynWrapper {
    TokenTupel ident;
    Idents next;

    public Idents(TokenTupel ident) {
        this.ident = ident;
    }

    public void setNext(Idents next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
