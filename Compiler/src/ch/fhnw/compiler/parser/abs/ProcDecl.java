package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Function;
import ch.fhnw.compiler.context.Proc;
import ch.fhnw.compiler.parser.abs.IAbs.ContextError;
import ch.fhnw.compiler.parser.abs.IAbs.IDecl;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class ProcDecl implements IDecl {
	 TokenTupel ident;
	 IParam param;
	 IGlobImp globImp;
	 IDecl cpsDecl;
	 ICmd cmd;
	public ProcDecl(TokenTupel tt, IParam param, IGlobImp globImp, IDecl cpsd, ICmd cmd){
		ident=tt;
		this.param=param;
		this.globImp=globImp;
		this.cpsDecl=cpsd;
		this.cmd=cmd;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void checkDeclaration() throws ContextError {
		// TODO Auto-generated method stub
		
		Proc proc = new Proc(ident.toString());
		Compiler.setScope(proc.getScope());
		if(!Compiler.getRoutineTable().addRoutine(proc)){
			throw new ContextError("Process " + ident.toString() + " already declared", ident.getLineNr());
			
		}
		param.check(proc);
		
		if(globImp!=null)globImp.check(proc);
		if(cpsDecl!=null)cpsDecl.checkDeclaration();
		cmd.check();
		Compiler.setScope(Compiler.getGlobalScope());
		
		
	}

	@Override
	public int check(int locals) throws ContextError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

}
