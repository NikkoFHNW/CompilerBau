package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.parser.concSynTree.Program;
import ch.fhnw.compiler.scanner.data.Terminal;

public interface IParser {

	
	static class GrammarError extends Exception{
		GrammarError(String ms){
			super(ms);
		}
		
		GrammarError(Terminal actual, Terminal expexted){
			super("actual: " + actual + ", expected: "+expexted);
		}
	}
	
	Program parse() throws GrammarError;
}
