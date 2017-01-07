package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprStore;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.IsInitialization;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FactorIdent extends AbstractFactor{
    TokenTupel ident;
    IExprList optInitOrExprList;

    public FactorIdent(TokenTupel ident, IExprList optInitOrExprList) {
        this.ident = ident;
        this.optInitOrExprList = optInitOrExprList;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        OptInitOrExprList o = (OptInitOrExprList) optInitOrExprList;
        IsInitialization isInit = o.isInit()? IsInitialization.INITIALIZATION : IsInitialization.NO_INITIALIZATION;
        return new ExprStore(ident.toString(), isInit);
    };
}
