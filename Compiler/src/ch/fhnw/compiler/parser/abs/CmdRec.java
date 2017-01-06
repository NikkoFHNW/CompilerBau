package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.concSynTree.IConcSyn;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdRec implements IAbs.ICmd {
    TokenTupel recident;
    TokenTupel ident;
    ICmd recConstr;

    public CmdRec(TokenTupel recident, TokenTupel ident, ICmd recConstr) {
        this.recident = recident;
        this.ident = ident;
        this.recConstr = recConstr;
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
