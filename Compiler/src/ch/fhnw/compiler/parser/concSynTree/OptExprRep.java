package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

import java.util.LinkedList;
import java.util.List;

public class OptExprRep implements IConcSyn.IOptExprRep{
    List<Expr> expressions;

    public OptExprRep(List<Expr> expressions) {
        this.expressions = expressions;
    }

    @Override
    public List<IAbs.IExpr> toAbstrSyntax() {
        List<IAbs.IExpr> result = new LinkedList<>();
        for (Expr expr : expressions)
            result.add(expr.toAbstrSyntax());

        return result;
    }
}
