package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprFunCall;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.RoutineCall;
import ch.fhnw.compiler.scanner.data.TokenTupel;

import java.util.List;

public class FactorExprList extends AbstractFactor  {
    TokenTupel ident;
    List<IAbs.IExpr> exprList;

    public FactorExprList(TokenTupel ident, List<IAbs.IExpr> exprList) {
        this.ident = ident;
        this.exprList = exprList;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        RoutineCall routineCall = new RoutineCall(ident, exprList);
        return new ExprFunCall(routineCall);
    }
}
