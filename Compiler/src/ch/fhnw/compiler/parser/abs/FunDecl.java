package ch.fhnw.compiler.parser.abs;


import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Function;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.concSynTree.*;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class FunDecl implements IAbs.IDecl {

	TokenTupel ident;
	IParam pListHead;

	IStoDecl stoDecl;
	IGlobImp globImps; //optional

	IDecl localCpsStoDecl;
	ICmd cpsCmd;
	
	public FunDecl(TokenTupel ident, IParam pListHead, IStoDecl iStoDecl, IGlobImp iGlobImp, IDecl iCpsDecl,ICmd iCmd) {
		this.ident=ident;
		this.pListHead=pListHead;
		this.stoDecl=iStoDecl;
		this.globImps=iGlobImp;
		this.localCpsStoDecl=iCpsDecl;
		this.cpsCmd=iCmd;
		
	}
	
	
	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return ident.toString();
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return ident.getLineNr();
	}

	@Override
	public void checkDeclaration() throws ContextError {
        Function func = new Function(ident.toString(), stoDecl.getType().getType());
		Compiler.setScope(func.getScope());
		if(!Compiler.getRoutineTable().addRoutine(func)){
			throw new ContextError("Function " + ident.toString() + " already declared", ident.getLineNr());
		}
		pListHead.check(func);
		
		if(stoDecl!=null)stoDecl.checkDeclaration();
		if(globImps!=null)globImps.check(func);
		if(localCpsStoDecl!=null)localCpsStoDecl.checkDeclaration();
		if(cpsCmd!=null)cpsCmd.check();
		
		
		Compiler.setScope(Compiler.getGlobalScope());
		
	}

	@Override
	public int check(int locals) throws ContextError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		int loc1 = loc;

		final int jumpLoc = loc++;
		final ICodeArray codeArray =  Compiler.getCodeArray();

		Routine routine = Compiler.getRoutineTable().getRoutine(ident.toString());
		Compiler.setScope(routine.getScope());
		routine.setAddress(loc1);

		codeArray.put(loc++, new IInstructions.Enter(0,0));

		loc = this.stoDecl.code(loc);

		Param currentParam = (Param) this.pListHead;
		int paramCount = 0;
		while (currentParam != null) {
			paramCount++;
			loc = currentParam.code(loc);
			currentParam = (Param) currentParam.next;
		}

		//TODO?
//		for(IGlobalImport g : globalImports)
//			loc = g.code(loc);

		CpsDecl currentCpsDecl = (CpsDecl) localCpsStoDecl;
		int stoDeclCount = 0;
		while (currentCpsDecl != null) {
			stoDeclCount++;
			loc = currentCpsDecl.code(loc);
			currentCpsDecl = (CpsDecl) currentCpsDecl.cpsDecl;
		}

		CmdCps currentCmd = (CmdCps) cpsCmd;
		int cmdCount = 0;
		while (currentCmd != null) {
			cmdCount++;
			loc = currentCmd.code(loc);
			currentCmd = currentCmd.next;
		}

		final int localVariableCount =
				Compiler.getScope().getVarCount() - 4
//				- globalImports.size()
				- stoDeclCount;


		final Store returnVal = Compiler.getScope().getStoreTable().getStore(stoDecl.toString());

		codeArray.put(loc++, new IInstructions.LoadAddrRel(returnVal.getRelAdress()));
		codeArray.put(loc++, new IInstructions.Deref());
		codeArray.put(loc++, new IInstructions.LoadAddrRel(-(paramCount+ 1)));
		codeArray.put(loc++, new IInstructions.Store());

		codeArray.put(loc++, new IInstructions.Return(localVariableCount));
		Compiler.returnToParentScope();

		// To jump over funDecl since it should not be executed until a Call to it
		codeArray.put(jumpLoc, new IInstructions.UncondJump(loc));

//		Routine routine = Compiler.getRoutineTable().getRoutine(ident.toString());
//		Compiler.setScope(routine.getScope());
//		routine.setAddress(loc1);
//
//		Compiler.getCodeArray().put(loc1++, new IInstructions.Store());
//
//		Compiler.getVM().Enter(
//				loc1++,
//				routine.getInOutCopyCount() + cpsDecl.getCount(),
//				0);
//
//		loc1 = param.codeIn(
//				loc1,
//				routine.getParamList().size(),
//				0);
//
//		loc1 = cmd.code(loc1);
//
//		loc1 = param.codeOut(loc1,
//				routine.getParamList().size(),
//				0);
//
//		IMLCompiler.getVM().Return(loc1++, 1);
//
//		IMLCompiler.setScope(null);

		return loc1;
	}

}
