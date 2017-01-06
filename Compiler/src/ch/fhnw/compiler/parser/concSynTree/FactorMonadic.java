package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprMonadic;
import ch.fhnw.compiler.parser.abs.IAbs;

public class FactorMonadic extends AbstractFactor {
    MonadicOpr monadicOpr;
    AbstractFactor factor;

    public FactorMonadic(MonadicOpr monadicOpr, AbstractFactor factor) {
        this.monadicOpr = monadicOpr;
        this.factor = factor;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return monadicOpr.toAbstrSyntax(factor.toAbstrSyntax());
    }
}
