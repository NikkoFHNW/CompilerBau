package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaGlobImpEps extends RepCommaGlobImp implements IConcSyn {

	public RepCommaGlobImpEps() {
		super(null, null);
	}
	
	public ch.fhnw.compiler.parser.abs.IAbs.IGlobImp toAbstrSyntax(){
		return null;
	}
}
