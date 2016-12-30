package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.parser.concSynTree.*;
import ch.fhnw.compiler.error.*;
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
	public Program parse() throws ch.fhnw.compiler.error.GrammarError {
		// TODO Auto-generated method stub
		
		Program program = program();
		consume(Terminal.SENTINEL);
		return program;

	}
	
	private Program program() throws ch.fhnw.compiler.error.GrammarError{
		// TODO Auto-generated method stub
			consume(Terminal.PROGRAM);
			Token t =consume(Terminal.IDENT);
			//FOR next ones we need the wrappers.
			
			
		
		throw new ch.fhnw.compiler.error.GrammarError(terminal,Terminal.PROGRAM);
	}


	private Token consume(Terminal expectedTerm) throws ch.fhnw.compiler.error.GrammarError{

		if(terminal==expectedTerm){
			Token consumedToken = token;
			if(terminal!=Terminal.SENTINEL){
				token = tokenList.nextToken();
				terminal = token.getTerminal();
			}
			return consumedToken;
		}else{
			throw new ch.fhnw.compiler.error.GrammarError(terminal,expectedTerm);
		}
	}
	
	
	private Decl decl() throws GrammarError {
		switch(terminal) {
			case FUN:
				System.out.println("decl ::= funDecl");
				return funDecl();
				break;
			case PROC:
				System.out.println("decl ::= procDecl");
				return procDecl();
				break;
			case CHANGEMODE:
			case IDENT:
				System.out.println("decl ::= storeDecl");
				return storeDecl();
				break;
			default:
				throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
				break;
		}
	}
	
	
	private StoDecl stoDecl() throws GrammarError {
		switch(terminal) {
		case REC: System.out.println("stoDecl ::= recordDecl");
		return recordDecl();
		break;
		default: System.out.println("stoDecl ::= OptChangeMode Ident");
		OptChangeMode optChangeMode = optChangeMode();
		TypedIdent ident = typedIdent();
		return new StoDecl(optChangeMode,ident);
		break;
		}
	}
	
	
	private FunDecl funDecl() throws ch.fhnw.compiler.error.GrammarError{
		switch(terminal){
		case FUN:
			consume(Terminal.FUN);
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			ParamList paramList = ParamList();
			consume(Terminal.RETURNS);
			StoDecl stoDecl = stoDecl();
			OptGlobalglobImps optGlobalglobImps = OptGlobalglobImps();
			OptLocalcpsStoDecl optLocalcpsStoDecl = optLocalcpsStoDecl();
			consume(Terminal.DO);
			CpsCmd cpsCmd = cpsCmd();
			consume(Terminal.ENDFUN);
			
			return new FunDecl(ident, paramList, optGlobalglobImps, optLocalcpsStoDecl, cpsCmd);
			break;
			
		default: throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
		}
	}
	
	
	

}
