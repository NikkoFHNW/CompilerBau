package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptTerm2Eps implements IConcSyn{

	IAbs toAbstrSyntax(){
		return new ch.fhnw.compiler.parser.abs.OptTerm2Eps();
	}
}
