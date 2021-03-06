package ch.fhnw.compiler.parser.abs;

import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdCps implements IAbs.ICmd {
    ICmd cmd;
    CmdCps next;

    public CmdCps(ICmd cmd, CmdCps next) {
        this.cmd = cmd;
        this.next = next;
    }

    @Override
    public void check(boolean canInit) throws ContextError {
        cmd.check();
        if (next != null)
            next.check();
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
//        System.out.println("code cpscmd");

        loc = cmd.code(loc);

        if (next == null)
            return loc;

        return next.code(loc);
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

    	cmd.check();
    	if(next!=null)next.check();
	}
}
