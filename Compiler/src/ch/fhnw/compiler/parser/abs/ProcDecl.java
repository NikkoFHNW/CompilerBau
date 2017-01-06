package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.abs.IAbs.IDecl;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class ProcDecl implements IDecl {
	 TokenTupel ident;
	 IParam param;
	 IGlobImp globImp;
	 ICpsDecl cpsDecl;
	 ICmd cmd;
	public ProcDecl(TokenTupel tt, IParam param, IGlobImp globImp, ICpsDecl cpsd, ICmd cmd){
		ident=tt;
		this.param=param;
		this.globImp=globImp;
		this.cpsDecl=cpsd;
		this.cmd=cmd;
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

}
