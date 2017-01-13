package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Scope;
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
    	
//    	cpsDecl.checkDeclaration();
//    	cpsDecl.check(-1);
    	Compiler.setScope(new Scope(Compiler.getGlobalStoreTable(),Compiler.getRecordStoreTable()));
    	params.check(null);
    	cpsDecl.checkDeclaration();
    	cmd.check(false);
    	
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
