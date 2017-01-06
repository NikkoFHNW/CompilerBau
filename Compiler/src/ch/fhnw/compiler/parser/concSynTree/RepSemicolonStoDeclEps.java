package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepSemicolonStoDeclEps extends RepSemicolonStoDecl implements IConcSyn {

	public RepSemicolonStoDeclEps() {
		super(null, null);
	}
	
	public ch.fhnw.compiler.parser.abs.IAbs.IStoDecl toAbstrSyntax(){
		return null;
	}
}
