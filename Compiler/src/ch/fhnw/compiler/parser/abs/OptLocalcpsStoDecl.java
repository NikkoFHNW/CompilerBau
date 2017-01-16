package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions.Store;

public class OptLocalcpsStoDecl implements IAbs.IStoDecl {
	
	IStoDecl stoDecl;
	
	public OptLocalcpsStoDecl(IStoDecl stoDecl) {
		// TODO Auto-generated constructor stub
		this.stoDecl=stoDecl;
		
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void checkDeclaration() throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int check(int locals) throws ContextError {
		return 0;
	}


	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public TokenTupel getType() {
		return null;
	}

	@Override
	public String getIdent() {
		return null;
	}

	@Override
	public Store check() throws ContextError {
		return null;
	}
}
