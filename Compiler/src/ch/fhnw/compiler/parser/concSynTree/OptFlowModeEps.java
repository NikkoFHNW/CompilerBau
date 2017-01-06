package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class OptFlowModeEps extends OptFlowMode implements IConcSyn{

	public OptFlowModeEps() {
		super(null);
	}
	
	public TokenTupel toAbstrSyntax(){
		return null;
	}
}
