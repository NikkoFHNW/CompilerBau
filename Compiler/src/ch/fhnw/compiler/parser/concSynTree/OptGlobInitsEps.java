package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.IAbs.IGlobInit;

public class OptGlobInitsEps extends OptGlobInits implements IConcSyn{

	public OptGlobInitsEps() {
		super(null);
	}
	
	public IGlobInit toAbstrSyntax(){
		return null;
	}
}
