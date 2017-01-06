package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.abs.IAbs.ICpsDecl;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class CpsStoDecl implements ICpsDecl {
	
	IStoDecl stoDecl;
	IStoDecl repStoDecl;
	
	public CpsStoDecl(IStoDecl stod, IStoDecl repS){
		this.stoDecl=stod;
		this.repStoDecl=repS;
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
