package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaGlobImpEps implements IConcSyn {

	IAbs toAbstrSyntax(){
		return new ch.fhnw.compiler.parser.abs.RepCommaGlobImpEps();
	}
}
