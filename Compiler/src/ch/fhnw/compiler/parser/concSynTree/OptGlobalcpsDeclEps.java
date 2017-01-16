package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptGlobalcpsDeclEps extends OptGlobalCpsDecl implements IConcSyn {
	
	public OptGlobalcpsDeclEps() {
		super(null);
	}
	
	public IAbs.IDecl toAbstrSyntax(){
		return null;
	}

}
