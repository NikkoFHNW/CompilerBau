package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;

public class FactorParen extends AbstractFactor implements IConcSyn {
    Expr expr;

    public FactorParen(Expr expr) {
        this.expr = expr;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() throws GrammarError {
        return expr.toAbstrSyntax();
    }
}
