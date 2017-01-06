package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class RoutineCall implements IAbs.IExpr {
    TokenTupel ident;
    IExpr exprList;

    public RoutineCall(TokenTupel ident, IExpr exprList) {
        this.ident = ident;
        this.exprList = exprList;
    }

    public TokenTupel getIdent() {
        return ident;
    }

    public IExpr getExprList() {
        return exprList;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
        return null;
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
        return null;
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
