package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.GlobalInit;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class Idents implements IConcSyn.IIdents {
    TokenTupel ident;
    Idents next;

    public Idents(TokenTupel ident) {
        this.ident = ident;
    }

    public void setNext(Idents next) {
        if (next == null)
            this.next = next;
        else
            next.setNext(next);
    }

    @Override
    public IAbs.IGlobInit toAbstrSyntax() {
        return new GlobalInit(ident, next.toAbstrSyntax());
    }
}
