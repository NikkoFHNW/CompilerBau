package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.RecordExpr;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FactorRecord extends AbstractFactor implements IConcSyn {
    TokenTupel ident;
    TokenTupel ident2;

    public FactorRecord(TokenTupel ident, TokenTupel ident2) {
        this.ident = ident;
        this.ident2 = ident2;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return new RecordExpr(ident, ident2);
    }
}
