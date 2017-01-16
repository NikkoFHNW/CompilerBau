package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprStore;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.IsInitialization;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FactorIdent extends AbstractFactor{
    TokenTupel ident;
    boolean isInitialization;

    public FactorIdent(TokenTupel ident, boolean isInitialization) {
        this.ident = ident;
        this.isInitialization = isInitialization;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return new ExprStore(ident.getStringVal(),isInitialization);
    };
}
