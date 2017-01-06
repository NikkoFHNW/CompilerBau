package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepTerm1Eps extends RepTerm1 implements IConcSyn {

	public RepTerm1Eps() {
		super(null, null);
	}
	
	IAbs toAbstrSyntax(){
		return null;
	}
}
