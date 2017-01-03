package ch.fhnw.compiler.parser.abs;

import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdEps implements IAbs.ICmd {

    @Override
    public void check(boolean canInit) throws ContextError {
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        return loc;
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
