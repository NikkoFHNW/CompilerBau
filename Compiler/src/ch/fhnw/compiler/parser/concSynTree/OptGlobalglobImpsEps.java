package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptGlobalglobImpsEps extends OptGlobalglobImps implements IConcSyn{

	public OptGlobalglobImpsEps() {
		super(null, null);
	}
	
	public ch.fhnw.compiler.parser.abs.IAbs.IGlobImp toAbstrSyntax(){
		return new ch.fhnw.compiler.parser.abs.OptGlobalglobImpsEps();
	}
}
