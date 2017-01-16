package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.abs.IAbs.ICpsDecl;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class CpsStoDecl implements IAbs.IStoDecl{
	
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

		stoDecl.checkDeclaration();
		if (repStoDecl != null)
			repStoDecl.checkDeclaration();
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
	public IInstructions.Store check() throws ContextError {
		return null;
	}
}
