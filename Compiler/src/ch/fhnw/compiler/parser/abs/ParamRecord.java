package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class ParamRecord implements IAbs.IParam {
    TokenTupel ident;
    TokenTupel recident;

    public ParamRecord(TokenTupel ident1, TokenTupel ident2) {
        this.ident = ident1;
        this.recident = ident2;
    }

    @Override
    public void check(Object routine) throws ContextError {

    }

    @Override
    public void checkInit() throws ContextError {

    }

    @Override
    public int calculateAddress(int count, int locals) {
        return 0;
    }

    @Override
    public int codeIn(int loc, int count, int locals) throws ICodeArray.CodeTooSmallError {
        return 0;
    }

    @Override
    public int codeOut(int loc, int count, int locals) throws ICodeArray.CodeTooSmallError {
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
