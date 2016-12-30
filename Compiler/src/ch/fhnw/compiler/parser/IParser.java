package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.concSynTree.Program;
import ch.fhnw.compiler.scanner.data.Terminal;

public interface IParser {


	
	Program parse() throws GrammarError;
}
