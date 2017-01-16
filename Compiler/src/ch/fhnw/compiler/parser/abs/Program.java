package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Scope;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

import java.util.Map;

public class Program implements IAbs.IProgram {

    TokenTupel ident;
    IParam params;  //optional
    IDecl cpsDecl;  //optional
    ICmd cmd;

    public Program(TokenTupel ident, IDecl cpsDecl, ICmd cmd, IParam params) {
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
    	
    	if(params!=null)
    	    params.check(null);

    	if(cpsDecl!=null)
    	    cpsDecl.checkDeclaration();

    	cmd.check();
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        System.out.println("code prog");
        int loc1 = cmd.code(loc);
        Compiler.getCodeArray().put(loc1, new IInstructions.Stop());

        if (params!= null) {
            loc1 = params.code(loc1);
        }

        if(cpsDecl != null)
            loc1 = cpsDecl.code(loc1 + 1);

        Map<String, Routine> i = Compiler.getRoutineTable().getTable();
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
