package ch.fhnw.compiler.parser;

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
	
	IConcSyn.IProgram parse() throws GrammarError;
}
