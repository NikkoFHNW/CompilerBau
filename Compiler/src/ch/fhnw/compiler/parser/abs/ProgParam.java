package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.abs.IAbs.IParam;
import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class ProgParam implements IAbs.IParam{
	
    TokenTupel optFlowMode;
//    TokenTupel optMechMode;
    TokenTupel optChangeMode;
    IParam typedIdentOrRecParam;

    private Store store;

    IParam next;
    
    
    public ProgParam(TokenTupel optFlowMode,  TokenTupel optChangeMode, IParam typedIdentOrRecParam, IParam next) {
		// TODO Auto-generated constructor stub
        this.optFlowMode = optFlowMode;
//        this.optMechMode = optMechMode;
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
		
		if(routine !=null)
			throw new ContextError("No progparams allowed in a routine!", typedIdentOrRecParam.getLine());
		

		String ident ="";
		Type type = null;
		boolean isC =false;
		if(optChangeMode!=null)
		    isC = optChangeMode.getMode().equals(Mode.CONST);
		
		if(typedIdentOrRecParam instanceof ch.fhnw.compiler.parser.abs.TypedIdent){
			ch.fhnw.compiler.parser.abs.TypedIdent ti = (ch.fhnw.compiler.parser.abs.TypedIdent) typedIdentOrRecParam;
			ident = ti.getIdent().getStringVal();
			type = ti.getType().getType();
			
		}else if(typedIdentOrRecParam instanceof ParamRecord){
          //in progparams keinde recidents
			throw new ContextError("no recidents as progparams", typedIdentOrRecParam.getLine());
		}
		
		Store sto = new Store(ident, type, isC);
//		sto.setReference(optMechMode.getMode().equals(Mode.REF));
		
		if(!Compiler.getScope().getStoreTable().addStore(
				sto)){
			throw new ContextError("already declared parameter " + ident,optChangeMode.getLineNr() );
		}
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
	public int code(int i) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}

}
