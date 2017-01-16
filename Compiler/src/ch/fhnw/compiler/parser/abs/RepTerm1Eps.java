package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class RepTerm1Eps implements IAbs.IExpr {

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
		return null;
	}

	@Override
	public TokenTupel checkL(boolean canInit) throws ContextError {
		return null;
	}

	@Override
	public TokenTupel checkL() throws ContextError {
		return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		return null;
	}

	@Override
	public int code(int loc) throws ICodeArray.CodeTooSmallError {
		return 0;
	}
}
