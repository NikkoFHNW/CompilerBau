package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepTerm2Eps extends RepTerm2 implements IConcSyn{

	public RepTerm2Eps() {
		super(null, null);
	}
	
	IAbs toAbstrSyntax(){
		return null;
	}
}
