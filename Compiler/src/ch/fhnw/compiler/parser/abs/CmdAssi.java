package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.CodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class CmdAssi implements IAbs.ICmd {

    //BECOMES

    IExpr destination;
    IExpr source;

    public CmdAssi(IExpr source, IExpr destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void check(boolean canInit) throws ContextError {

    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
//        System.out.println("code assi");
        CodeArray codeArray = Compiler.getCodeArray();

        int loc1 = loc;

        loc1 = this.destination.code(loc1);
        loc1 = this.source.code(loc1);
        codeArray.put(loc1++, new IInstructions.Store());

        return loc1;
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
        TokenTupel dest = destination.checkL();
        Type tS = null, tD = null;
        if (dest != null)
		     tS= dest.getType();
        TokenTupel sour = source.checkR();
        if(sour != null) {
            tD = sour.getType();

        }
		if(tS != null && tD != null && !tS.equals(tD))
			throw new ContextError("Types of become assignment must match. expected: "
					+tS.toString()+ " actual: " + tD.toString(), source.getLine());
		
		
	}
}
