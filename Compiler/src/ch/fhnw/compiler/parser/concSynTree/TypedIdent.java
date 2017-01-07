package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class TypedIdent implements IConcSyn.IParam {
    TokenTupel ident;
    TokenTupel atomtype;

    public TypedIdent(TokenTupel ident, TokenTupel at) {
        this.ident = ident;
        this.atomtype = at;
    }

    @Override
    public ch.fhnw.compiler.parser.abs.IAbs.IParam toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.TypedIdent(ident,atomtype);
    }
}
