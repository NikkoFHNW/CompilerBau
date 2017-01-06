package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptGlobalcpsDeclEps implements IConcSyn {
	
	public IAbs toAbstrSyntax(){
		return new ch.fhnw.compiler.parser.abs.OptGlobalcpsDeclEps();
	}

}
