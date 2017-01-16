package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepSemicolonDeclEps extends RepSemicolonDecl implements IConcSyn {

	public RepSemicolonDeclEps() {
		super(null, null);
	}
	
	public IAbs.IDecl toAbstrSyntax(){
		return null;
	}
}
