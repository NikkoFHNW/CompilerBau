package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class TypedIdent implements IAbs.IExpr {

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
	public TokenTupel checkR() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenTupel checkL(boolean canInit) throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

}
