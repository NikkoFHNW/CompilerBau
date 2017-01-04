package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepCommaIdent implements IConcSyn.IIdents {
    TokenTupel ident;
    RepCommaIdent repCommaIdent;


    public RepCommaIdent(TokenTupel ident, RepCommaIdent repCommaIdent) {
        this.ident = ident;
        this.repCommaIdent = repCommaIdent;
    }


    @Override
    public IAbs.IGlobInit toAbstrSyntax() {
        return null;
    }
}
