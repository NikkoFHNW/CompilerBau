package ch.fhnw.compiler;

import ch.fhnw.compiler.context.RecordStoreTable;
import ch.fhnw.compiler.context.RoutineTable;
import ch.fhnw.compiler.context.Scope;
import ch.fhnw.compiler.context.StoreTable;
import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.Parser;
import ch.fhnw.compiler.parser.abs.IAbs.ContextError;
import ch.fhnw.compiler.parser.concSynTree.Program;
import ch.fhnw.compiler.scanner.Scanner;
import ch.fhnw.compiler.scanner.data.*;
import ch.fhnw.lederer.virtualmachineFS2015.CodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IVirtualMachine;
import ch.fhnw.lederer.virtualmachineFS2015.VirtualMachine;

public class Compiler {

	private static int CODE_SIZE = 1000;
	private static int STORE_SIZE = 1000;

	private static RoutineTable routineTable = new RoutineTable();
	private static StoreTable globalStoreTable = new StoreTable();
	private static RecordStoreTable recordStoreTable = new RecordStoreTable();
    private static Scope scope = null;

    private static CodeArray codeArray = new CodeArray(CODE_SIZE);

    public static CodeArray getCodeArray() {
        return codeArray;
    }

	public static void setRecordStoreTable(RecordStoreTable recordStoreTable) {
		Compiler.recordStoreTable = recordStoreTable;
	}

	public static RecordStoreTable getRecordStoreTable() {
		return recordStoreTable;
	}

	public static RoutineTable getRoutineTable() {
	    return routineTable;
    }

    public static void setRoutineTable(RoutineTable routineTable) {
        Compiler.routineTable = routineTable;
    }

    public static StoreTable getGlobalStoreTable() {
        return globalStoreTable;
    }

    public static void setGlobalStoreTable(StoreTable globalStoreTable) {
        Compiler.globalStoreTable = globalStoreTable;
    }

    public static Scope getScope() {
        return scope;
    }

    public static Scope getGlobalScope(){
        return new Scope(globalStoreTable,recordStoreTable);
    }

    public static void setScope(Scope scope) {
        Compiler.scope = scope;
    }

	public void compile(String filename){
    	 ITokenList tList = Scanner.scan("Compiler/imlCodes/"+filename);
         System.out.println(tList.toString());

 		Parser parser = new Parser(tList);
 		try {
 			Program prog = parser.parse();
 			ch.fhnw.compiler.parser.abs.IAbs.IProgram absProg = prog.toAbstrSyntax();
 			absProg.check();
 		} catch (GrammarError e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (ContextError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    
    //------------MAIN------------
    public static void main(String[] args) {
    	Compiler imlC = new Compiler();
    	imlC.compile("ourExample.iml");
       
    }
}
