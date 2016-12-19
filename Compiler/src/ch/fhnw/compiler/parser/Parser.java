package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.parser.IConcSyn.IProgram;
import ch.fhnw.compiler.scanner.data.ITokenList;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;


public class Parser implements IParser {

	private ITokenList tokenList;
	private Token token;
	private Terminal terminal;
	private ConcSyn concSyn;
	
	public Parser(ITokenList tl){
	this.tokenList=tl;
	this.tokenList.reset();
	
	token = tokenList.nextToken();
	terminal = token.getTerminal();
	concSyn = new ConcSyn();
	}
	
	
	@Override
	public IProgram parse() throws GrammarError {
		// TODO Auto-generated method stub
//		ConcSyn.IProgram  program = program();
//		ConcSyn.consume(Terminal.SENTINEL);
//		return program;
		ConcSyn.IProgram program = program();
		consume(Terminal.SENTINEL);
		return program;

	}
	
	private IProgram program() throws GrammarError{
		// TODO Auto-generated method stub
			consume(Terminal.PROGRAM);
			Token t =consume(Terminal.IDENT);
			//FOR next ones we need the wrappers.
			
			
		
		throw new GrammarError(terminal,Terminal.PROGRAM);
	}


	private Token consume(Terminal expectedTerm) throws GrammarError{
	
		
		if(terminal==expectedTerm){
			Token consumedToken = token;
			if(terminal!=Terminal.SENTINEL){
				token = tokenList.nextToken();
				terminal = token.getTerminal();
			}
			return consumedToken;
		}else{
			throw new GrammarError(terminal,expectedTerm);
		}
	}
	

}
