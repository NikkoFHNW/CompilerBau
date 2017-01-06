package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class TypedIdent implements IConcSyn.IFactor {
    TokenTupel ident;
    TokenTupel atomtype;

    public TypedIdent(TokenTupel ident, TokenTupel at) {
        this.ident = ident;
        this.atomtype = at;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.TypedIdent(ident,atomtype);
    }
}
