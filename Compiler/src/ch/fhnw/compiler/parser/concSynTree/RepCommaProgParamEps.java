package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaProgParamEps extends RepCommaProgParam implements IConcSyn{

	public RepCommaProgParamEps() {
		super(null, null);
	}
	
	
	public ch.fhnw.compiler.parser.abs.IAbs.IParam toAbstrSyntax(){
		return null;
	}
}
