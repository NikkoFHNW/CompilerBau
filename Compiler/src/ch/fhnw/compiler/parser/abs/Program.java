package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class Program implements IAbs.IProgram {

    TokenTupel ident;
    ICpsDecl cpsDecl;
    ICmd cmd;
    IParam params;

    public Program(TokenTupel ident, ICpsDecl cpsDecl, ICmd cmd, IParam params) {
        this.ident = ident;
        this.cpsDecl = cpsDecl;
        this.cmd = cmd;
        this.params = params;
    }

    @Override
    public void check() throws ContextError {

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
