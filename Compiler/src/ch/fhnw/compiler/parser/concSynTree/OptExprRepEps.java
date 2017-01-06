package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptExprRepEps extends OptExprRep implements IConcSyn.IExpr {
    public OptExprRepEps() {
    	super(null, null);
    }

	@Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
