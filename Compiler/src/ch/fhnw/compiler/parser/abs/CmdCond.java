package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

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
        int loc1 = expr.code(loc);
        int loc2 = ifCmd.code(loc1 + 1);
        Compiler.getCodeArray().put(loc1, new IInstructions.CondJump(loc2 + 1));
        int loc3 = elseCmd.code(loc2 + 1);
        Compiler.getCodeArray().put(loc2, new IInstructions.UncondJump(loc3));
        return loc3;
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
		if(!expr.checkR().getType().equals(Type.BOOL))
		throw new ContextError("need a bool value for if comands!", expr.getLine());
		ifCmd.check();
		elseCmd.check();
		
		
		
	}
}
