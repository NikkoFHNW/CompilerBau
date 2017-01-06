package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.ExprMonadic;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn.IMonadicOpr;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class MonadicOpr implements IMonadicOpr{
    TokenTupel monadicOpr;

    public MonadicOpr(TokenTupel monadicOpr) {
        this.monadicOpr = monadicOpr;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax(AbstractFactor factor) {
        return new ExprMonadic(monadicOpr.getOp(), factor.toAbstrSyntax());
    }
}
