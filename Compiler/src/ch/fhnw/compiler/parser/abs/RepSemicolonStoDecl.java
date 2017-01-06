package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.abs.IAbs.IStoDecl;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions.Store;

public class RepSemicolonStoDecl implements IStoDecl{
	
	IStoDecl stoDecl;
	IStoDecl repStoD;
	
	public  RepSemicolonStoDecl(IStoDecl stoDe, IStoDecl rep) {
		// TODO Auto-generated constructor stub
		this.stoDecl=stoDe;
		this.repStoD=rep;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TokenTupel getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

}
