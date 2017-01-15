package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class ExprStore implements IAbs.IExpr {
    String ident;
    IsInitialization isInitialization;

    public ExprStore(String ident, IsInitialization isInitialization) {
        this.ident = ident;
        this.isInitialization = isInitialization;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
    	TokenTupel res=null;
    	if(isInitialization.equals(IsInitialization.INITIALIZATION)){
    		throw new ContextError("cannot initialise here", 0);
    	}
    	Store sto = Compiler.getScope().getStoreTable().getStore(ident);
    	if(sto==null)throw new ContextError(ident + " wasn't declared.", 0);
    	if(!sto.isInitialized())throw new ContextError(ident +"hasn't been initialised yet", 0);
    	Type t = sto.getType();
    	
    	res = new TokenTupel(Terminal.TYPE, t);
    	
        return res;
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
    	TokenTupel res=null;
    	if(isInitialization.equals(IsInitialization.INITIALIZATION)){
    		Store sto = Compiler.getScope().getStoreTable().getStore(ident);
        	if(sto==null)throw new ContextError(ident + " wasn't declared.", 0);
        	sto.initialize();
        	Type t = sto.getType();
        	res = new TokenTupel(Terminal.TYPE,t);
        	return res;
    	}
    	else{
    		Store sto = Compiler.getScope().getStoreTable().getStore(ident);
        	if(sto==null)throw new ContextError(ident + " wasn't declared.", 0);
        	if(!sto.isInitialized())throw new ContextError(ident +"hasn't been initialised yet", 0);
        	Type t = sto.getType();
        	res = new TokenTupel(Terminal.TYPE,t);
        	return res;
    	}
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

	@Override
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
