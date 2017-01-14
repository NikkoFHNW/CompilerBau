package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdAssi implements IAbs.ICmd {

    //BECOMES

    IExpr source;
    IExpr destination;

    public CmdAssi(IExpr source, IExpr destination) {
        this.source = source;
        this.destination = destination;
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
		Type tS =source.checkL().getType();
		Type tD = destination.checkR().getType();
		if(!tS.equals(tD))
			throw new ContextError("Types of become assignment must match. expected: "
					+tS.toString()+ " actual: " + tD.toString(), source.getLine());
		
		
	}
}
