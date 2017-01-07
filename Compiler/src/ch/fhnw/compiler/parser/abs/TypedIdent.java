package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class TypedIdent implements IAbs.IParam {

	TokenTupel ident;
	TokenTupel type;
	
	public TypedIdent(TokenTupel ident, TokenTupel type){
		this.ident=ident;
		this.type=type;
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
	public void check(Object routine) throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkInit() throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculateAddress(int count, int locals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codeIn(int loc, int count, int locals) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codeOut(int loc, int count, int locals) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

}
