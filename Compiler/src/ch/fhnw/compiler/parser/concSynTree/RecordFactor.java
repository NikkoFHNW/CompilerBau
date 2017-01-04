package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordFactor implements IConcSyn.IFactor {
    TokenTupel ident1;
    TokenTupel ident2;

    public RecordFactor(TokenTupel ident1, TokenTupel ident2) {
        this.ident1 = ident1;
        this.ident2 = ident2;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
