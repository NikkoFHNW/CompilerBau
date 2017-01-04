package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class Idents implements IConcSyn.IIdents {
    TokenTupel ident;
    Idents next;

    public Idents(TokenTupel ident) {
        this.ident = ident;
    }

    public void setNext(Idents next) {
        this.next = next;
    }

    @Override
    public IAbs.IGlobInit toAbstrSyntax() {
        return null;
    }
}
