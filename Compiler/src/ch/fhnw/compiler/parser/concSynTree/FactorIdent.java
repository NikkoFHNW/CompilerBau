package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FactorIdent extends AbstractFactor{
    TokenTupel ident;
    OptInitOrExprList optInitOrExprList;

    public FactorIdent(TokenTupel ident, OptInitOrExprList optInitOrExprList) {
        this.ident = ident;
        this.optInitOrExprList = optInitOrExprList;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
