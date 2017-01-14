package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdProcCall implements IAbs.ICmd {
//    TokenTupel ident; in routineCall enthalten
    RoutineCall routineCall;
    IGlobInit globalInit;

    public CmdProcCall(RoutineCall routineCall, IGlobInit globalInit) {
        this.routineCall = routineCall;
        this.globalInit = globalInit;
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
		routineCall.c
		
	}
}
