package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.abs.IAbs.IProgram;
import ch.fhnw.compiler.parser.concSynTree.CpsDecl;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class Programm implements IProgram{

	TokenTupel ident;
//	ch.fhnw.compiler.parser.abs.CpsDecl cpsDecl;
	ICpsDecl cpsDecl;
	ICmd cmd;
	
	public Programm(TokenTupel ident, ICpsDecl cpsDecl, ICmd cmd ){
		this.ident=ident;
		this.cpsDecl=cpsDecl;
		this.cmd = cmd;
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
	public void check() throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
