package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptGlobalglobImpsEps implements IConcSyn{

	IAbs toAbstrSyntax(){
		return new ch.fhnw.compiler.parser.abs.OptGlobalglobImpsEps();
	}
}
