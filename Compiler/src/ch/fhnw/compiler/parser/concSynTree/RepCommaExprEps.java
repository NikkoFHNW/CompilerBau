package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaExprEps extends RepCommaExpr implements IConcSyn {

	public RepCommaExprEps() {
		super(null);
	}
	
	IAbs toAbstrSyntax(){
		return null;
	}
}
