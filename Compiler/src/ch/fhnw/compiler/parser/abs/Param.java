package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.*;
import ch.fhnw.compiler.parser.concSynTree.OptChangeMode;
import ch.fhnw.compiler.parser.concSynTree.OptFlowMode;
import ch.fhnw.compiler.parser.concSynTree.OptMechMode;
import ch.fhnw.compiler.parser.concSynTree.RecordParam;
import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class Param implements IAbs.IParam {
	
    TokenTupel optFlowMode;
    TokenTupel optMechMode;
    TokenTupel optChangeMode;
    IParam typedIdentOrRecParam;
    private Store store;
    IParam next;

    boolean isProgParam = false;

    public Param(TokenTupel optFlowMode, TokenTupel optMechMode, TokenTupel optChangeMode, IParam typedIdentOrRecParam, IParam next) {
        this.optFlowMode = optFlowMode;
        this.optMechMode = optMechMode;
        this.optChangeMode = optChangeMode;
        this.typedIdentOrRecParam = typedIdentOrRecParam;
        this.next = next;
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
        String rectype = null;
		//Erste variante, misachtet bisschen die struktur (ungebrauchte checks bei childs)
		//aber changemode wird contextuell gespeichert resp. beachtet.
		if(routine==null){//Progparams
            isProgParam = true;

			String ident ="";
			Type type = null;
			boolean isC =false;
			if(optChangeMode!=null)
			    isC = optChangeMode.getMode().equals(Mode.CONST);
			
			if(typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent){
				ch.fhnw.compiler.parser.abs.TypedIdent ti = (ch.fhnw.compiler.parser.abs.TypedIdent) typedIdentOrRecParam;
				ident = ti.getIdent().toString();
				type = ti.getType().getType();
				
			}else if(typedIdentOrRecParam instanceof ParamRecord){
                //in progparams keinde recidents
				throw new ContextError("no recidents as progparams", typedIdentOrRecParam.getLine());
			}
			
			Store sto = new Store(ident, type, isC);
			if (optMechMode != null)
                sto.setReference(optMechMode.getMode().equals(Mode.REF));
            else
                sto.setReference(false);
			
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
				ident = ti.getIdent().getStringVal();
				type = ti.getType().getType();
				
				routine.addParam(new Parameter(
			                optFlowMode.getMode(), 
			                optMechMode.getMode(), 
			                optChangeMode.getMode(),
			                type));
				
			}else if(typedIdentOrRecParam instanceof ParamRecord){
                Mode optCM = null;
                if (optChangeMode != null){
                    optCM = this.optChangeMode.getMode();
                }

				ParamRecord pr = (ParamRecord) typedIdentOrRecParam;
				ident = pr.ident.getStringVal();
				type = null;
				routine.addParam(new RecordParameter(optFlowMode.getMode(), 
		                optMechMode.getMode(),
                        optCM,
		                pr.recident.getStringVal()));

				if(Compiler.getRecordStoreTable().getTable().containsKey(pr.recident.getStringVal())){
					RecordStore rs = Compiler.getRecordStoreTable().getRecordStore(pr.recident.getStringVal());
//                    rs.setRecIdent(pr.recident.getStringVal());
					Compiler.getScope().getRecordStoreTable().addRecordStore(rs);
                    rectype = rs.getRecIdent();
				}else{
					throw new ContextError("The used Recordtype " + pr.recident.toString() + " doesn't exist in this Programm.",
							optChangeMode != null ? optChangeMode.getLineNr() : 0);
				}
				
			}
			
			Store tS = new Store(ident, type, isC);
            if (rectype != null)
                tS.setRecType(rectype);
			tS.setReference(optMechMode.getMode().equals(Mode.REF));
			
			if(!Compiler.getScope().getStoreTable().addStore(//Type null heisst type-> recident
					tS)){
				throw new ContextError("no recidents as progparams", typedIdentOrRecParam.getLine());
			}

			if (next != null)
			    next.check(routine);
			
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
        int locals1 = locals;
        if (optFlowMode.getMode() == Mode.IN
                || optMechMode.getMode() == Mode.REF) {
            store.setAddress(-count);
            store.setRelative(true);
            if (optMechMode.getMode() == Mode.REF) {
                store.setReference(true);
            } else {
                store.setReference(false);
            }
        } else {
            store.setAddress(2 + ++locals1);
            store.setRelative(true);
            store.setReference(false);
        }

        return next.calculateAddress(count -1, locals1);
	}

    @Override
    public int code(int i) throws CodeTooSmallError {
        ICodeArray codeArr = Compiler.getCodeArray();
        int loc = i;
        Store store = null;

        if(isProgParam || typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent) {
            TypedIdent typedIdent = (TypedIdent) typedIdentOrRecParam;
            store = Compiler.getGlobalStoreTable().getStore(typedIdent.toString());


        } else if (typedIdentOrRecParam instanceof ParamRecord) {
                ParamRecord paramRecord = (ParamRecord) typedIdentOrRecParam;
                store = Compiler.getGlobalStoreTable().getStore(paramRecord.toString());
        }

        codeArr.put(loc++, new IInstructions.AllocBlock(1));
        codeArr.put(loc++, new IInstructions.LoadAddrRel(-store.getAddress()));
        codeArr.put(loc++, new IInstructions.Deref());
        codeArr.put(loc++, new IInstructions.LoadAddrRel(store.getAddress()));
        codeArr.put(loc++, new IInstructions.Store());

        return loc;
    }

//    @Override
//	public int codeIn(int loc, int count, int locals) throws CodeTooSmallError {
//
//        if (typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent) {
//            int locals1 = locals;
//            int loc1 = loc;
//            Mode flow = optFlowMode.getMode();
//            Mode mech = optMechMode.getMode();
//            if (flow != Mode.IN && mech == Mode.COPY) {
//                if (flow == Mode.INOUT) {
//                    Compiler.getCodeArray().put(loc1++, new In);
//
//            }
//
//            }
//
//        } else if (typedIdentOrRecParam instanceof ParamRecord) {
//
//        }
//
//		return 0;
//	}
//
//	@Override
//	public int codeOut(int loc, int count, int locals) throws CodeTooSmallError {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
