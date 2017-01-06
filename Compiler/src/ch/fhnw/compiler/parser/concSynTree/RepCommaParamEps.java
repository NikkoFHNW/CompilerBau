package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaParamEps extends RepCommaParam implements IConcSyn {

	public RepCommaParamEps() {
		super(null, null);
	}
	
	public ch.fhnw.compiler.parser.abs.IAbs.IParam toAbstrSyntax(){
		return null;
	}
}
