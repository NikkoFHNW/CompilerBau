package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Parameter;
import ch.fhnw.compiler.context.RecordParameter;
import ch.fhnw.compiler.context.RecordStore;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.concSynTree.OptChangeMode;
import ch.fhnw.compiler.parser.concSynTree.OptFlowMode;
import ch.fhnw.compiler.parser.concSynTree.OptMechMode;
import ch.fhnw.compiler.parser.concSynTree.RecordParam;
import ch.fhnw.compiler.parser.concSynTree.TypedIdent;
import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class Param implements IAbs.IParam {
	
    TokenTupel optFlowMode;
    TokenTupel optMechMode;
    TokenTupel optChangeMode;
    IParam typedIdentOrRecParam;
	
	public Param(TokenTupel flow, TokenTupel mech, TokenTupel change, IParam typ) {
		// TODO Auto-generated constructor stub
		this.optFlowMode=flow;
		this.optMechMode=mech;
		this.optChangeMode=change;
		typedIdentOrRecParam=typ;
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
	public void check(Routine routine) throws ContextError {
		// TODO Auto-generated method stub
		
		
		//Erste variante, misachtet bisschen die struktur (ungebrauchte checks bei childs)
		//aber changemode wird contextuell gespeichert resp. beachtet.
		if(routine==null){//Progparams
			String ident ="";
			Type type = null;
			boolean isC =false;
			if(optChangeMode!=null)isC = optChangeMode.getMode().equals(Mode.CONST);
			
			if(typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent){
				ch.fhnw.compiler.parser.abs.TypedIdent ti = (ch.fhnw.compiler.parser.abs.TypedIdent) typedIdentOrRecParam;
				ident = ti.getIdent().toString();
				type = ti.getType().getType();
				
			}else if(typedIdentOrRecParam instanceof ParamRecord){
//in progparams keinde recidents
				throw new ContextError("no recidents as progparams", typedIdentOrRecParam.getLine());
			}
			
			
			Store sto = new Store(ident, type, isC);
			sto.setReference(optMechMode.getMode().equals(Mode.REF));
			
			if(!Compiler.getScope().getStoreTable().addStore(
					sto)){
				throw new ContextError("already declared parameter " + ident,optChangeMode.getLineNr() );
			}
		
		}else{

			String ident ="";
			Type type = null;
			boolean isC;
			isC=false;
			if(optChangeMode!=null)isC = optChangeMode.getMode().equals(Mode.CONST);
			
			if(typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent){
				ch.fhnw.compiler.parser.abs.TypedIdent ti = (ch.fhnw.compiler.parser.abs.TypedIdent) typedIdentOrRecParam;
				ident = ti.getIdent().toString();
				type = ti.getType().getType();
				
				routine.addParam(new Parameter(
			                optFlowMode.getMode(), 
			                optMechMode.getMode(), 
			                optChangeMode.getMode(),
			                type));
				

				
			}else if(typedIdentOrRecParam instanceof ParamRecord){
				ParamRecord pr = (ParamRecord) typedIdentOrRecParam;
				ident = pr.ident.toString();
				type = null;
				routine.addParam(new RecordParameter(optFlowMode.getMode(), 
		                optMechMode.getMode(), 
		                optChangeMode.getMode(),
		                pr.recident.toString()));
				
				if(Compiler.getRecordStoreTable().getTable().containsKey(pr.recident.toString())){
					RecordStore rs = Compiler.getRecordStoreTable().getRecordStore(pr.recident.toString());
					Compiler.getScope().getRecordStoreTable().addRecordStore(rs);
				}else{
					throw new ContextError("The used Recordtype " + pr.recident.toString() + " doesn't exist in this Programm.",
							optChangeMode.getLineNr());
				}
				
			}
			
			Store tS = new Store(ident, type, isC);
			tS.setReference(optMechMode.getMode().equals(Mode.REF));
			
			if(!Compiler.getScope().getStoreTable().addStore(//Type null heisst type-> recident
					tS)){
				throw new ContextError("no recidents as progparams", typedIdentOrRecParam.getLine());
			}
			
		}
		
		
		
		
		//Variante mit ched auf TypedIdent oder RecordPAram
		//Nachteil: changemode wird ignoriert.
	/*	typedIdentOrRecParam.check(routine);
		Type type =null;
		if(typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent){
		ch.fhnw.compiler.parser.abs.TypedIdent ti = (ch.fhnw.compiler.parser.abs.TypedIdent) typedIdentOrRecParam;
		type= ti.getType().getType();
		
	}else if(typedIdentOrRecParam instanceof ParamRecord){
		ParamRecord pr = (ParamRecord) typedIdentOrRecParam;
		type = pr.recident.getType();
		
		
				  routine.addParam(new Parameter(
	                optFlowMode.getMode(), 
	                optMechMode.getMode(), 
	                optChangeMode.getMode(),
	                type));
	}*/
		

	}

	@Override
	public void checkInit() throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculateAddress(int count, int locals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codeIn(int loc, int count, int locals) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codeOut(int loc, int count, int locals) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

}
