package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptLocalcpsStoDeclEps extends OptLocalcpsStoDecl implements IConcSyn{

	public OptLocalcpsStoDeclEps() {
		super(null, null);
	}
	
	
	public IAbs.IDecl toAbstrSyntax(){
		return null;
	}
}
