package ch.fhnw.compiler.parser.abs;

import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdWhile implements IAbs.ICmd {
    IExpr expr;
    ICmd cmd;

    public CmdWhile(IExpr expr, ICmd cmd) {
        this.expr = expr;
        this.cmd = cmd;
    }

    @Override
    public void check(boolean canInit) throws ContextError {

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
	public void check() throws ContextError {
		// TODO Auto-generated method stub
		
	}
}
