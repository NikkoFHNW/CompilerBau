package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.Operator;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class ExprMonadic implements IAbs.IExpr {
    Operator operator;
    IExpr expr;

    public ExprMonadic(Operator operator, IExpr expr) {
        this.operator = operator;
        this.expr = expr;
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
