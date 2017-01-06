package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepFactorEps extends RepFactor implements IConcSyn{

	public RepFactorEps() {
		super(null);
	}
	
	IAbs toAbstrSyntax(){
		return new ch.fhnw.compiler.parser.abs.RepFactorEps();
	}
}
