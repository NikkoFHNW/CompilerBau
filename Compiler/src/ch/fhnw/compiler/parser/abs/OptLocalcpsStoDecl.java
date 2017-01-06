package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions.Store;

public class OptLocalcpsStoDecl implements IAbs.ICpsDecl {
	
	ICpsDecl stoDecl;
	
	public OptLocalcpsStoDecl(ICpsDecl stoDecl) {
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
	public void check(int locals) throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}



}
