package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class Value implements IAbs.IExpr {
    Boolean boolValue;
    Integer intValue;

    public Value(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    public Value(Integer intValue) {
        this.intValue = intValue;
    }

    public boolean getBoolValue() {
        return boolValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public boolean isBool() {
        return boolValue != null;
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
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        return 0;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return 0;
    }

	@Override
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
