package ch.fhnw.compiler.parser.abs;

import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdCond implements IAbs.ICmd{
    IExpr expr;
    ICmd ifCmd;
    ICmd elseCmd;

    public CmdCond(IExpr expr, ICmd ifCmd, ICmd elseCmd) {
        this.expr = expr;
        this.ifCmd = ifCmd;
        this.elseCmd = elseCmd;
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
