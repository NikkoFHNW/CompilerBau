package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprFunCall;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.RoutineCall;
import ch.fhnw.compiler.scanner.data.TokenTupel;

import java.util.LinkedList;
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
        List<IAbs.IExpr> rectAsso = new LinkedList<>();
        for (int i = exprList.size()-1; i >= 0; i--) {
            rectAsso.add(exprList.get(i));
        }

        RoutineCall routineCall = new RoutineCall(ident, rectAsso);
        return new ExprFunCall(routineCall);
    }
}
