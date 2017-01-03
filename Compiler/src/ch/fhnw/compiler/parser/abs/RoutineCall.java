package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class RoutineCall implements IAbs.IExpr {
    TokenTupel ident;
    IExpr expr;
    IExpr nextExpression;

    public RoutineCall(TokenTupel ident, IExpr expr, IExpr nextExpression) {
        this.ident = ident;
        this.expr = expr;
        this.nextExpression = nextExpression;
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
