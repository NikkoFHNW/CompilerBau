package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Scope;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

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
    	
    	if(params!=null)params.check(null);
    	if(cpsDecl!=null)cpsDecl.checkDeclaration();
    	cmd.check();
    	
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        int loc1 = cmd.code(loc);
        Compiler.getCodeArray().put(loc1, new IInstructions.Stop());
        if(cpsDecl != null)
            loc1 = cpsDecl.code(loc1 + 1);
        for (Routine routine : Compiler.getRoutineTable().getTable().values()) {
            routine.codeCalls();
        }
        return loc1;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return ident.getLineNr();
    }
}
