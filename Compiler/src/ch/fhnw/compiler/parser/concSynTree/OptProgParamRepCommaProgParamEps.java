package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptProgParamRepCommaProgParamEps extends OptProgParamRepCommaProgParam implements IConcSyn {

	public OptProgParamRepCommaProgParamEps() {

		super(null, null);
	}
	
	public ch.fhnw.compiler.parser.abs.IAbs.IParam toAbstrSyntax(){
		return null;
	}
}
