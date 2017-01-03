package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdProcCall implements IAbs.ICmd {
    TokenTupel ident;
    RoutineCall routineCall;
    TokenTupel optIdent;

    public CmdProcCall(TokenTupel ident, RoutineCall routineCall, TokenTupel optIdent) {
        this.ident = ident;
        this.routineCall = routineCall;
        this.optIdent = optIdent;
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
}
