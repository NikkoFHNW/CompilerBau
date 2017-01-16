package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepSemicolonStoDeclEps extends RepSemicolonStoDecl implements IConcSyn {

	public RepSemicolonStoDeclEps() {
		super(null, null);
	}
	
	public IAbs.IStoDecl toAbstrSyntax(){
		return null;
	}
}
