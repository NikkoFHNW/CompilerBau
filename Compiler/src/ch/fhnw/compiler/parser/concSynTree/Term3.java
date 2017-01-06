package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Term3 implements IConcSyn.ITerm3 {
    AbstractFactor factor;
    RepFactor repFactor;

    public Term3(AbstractFactor factor, RepFactor repFactor) {
        this.factor = factor;
        this.repFactor = repFactor;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        if (repFactor != null)
            return repFactor.toAbstrSyntax(factor.toAbstrSyntax());
        else
            return factor.toAbstrSyntax();
    }
}
