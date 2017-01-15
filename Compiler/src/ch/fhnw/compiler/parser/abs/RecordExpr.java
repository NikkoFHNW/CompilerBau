package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.RecordStore;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class RecordExpr implements IAbs.IExpr{
    TokenTupel ident1;
    TokenTupel ident2;

    public RecordExpr(TokenTupel ident1, TokenTupel ident2) {
        this.ident1 = ident1;
        this.ident2 = ident2;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
    	return check();
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
        return null;
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
		return check();
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
    	TokenTupel res=null;
    	Store s1 =Compiler.getScope().getStoreTable().getStore(ident1.toString());
    	if(s1.getType()!=null)throw new ContextError(ident1.toString() + " is not of a Rectype.",ident1.getLineNr());
    	if(s1.getRecType()==null)throw new ContextError("store missing rectype (RecordExpr error)",ident1.getLineNr());
    	RecordStore rs2 = Compiler.getScope().getRecordStoreTable().getRecordStore(s1.getRecType());
        if(rs2 == null) throw new ContextError("Recordtype " +s1.getRecType()+" not defined here", ident1.getLineNr());
    	Type t=rs2.getFieldType(ident2.toString());
    	if(t==null){
    		throw new ContextError(rs2.getRecIdent() + " has no field named "+ident2.toString(), ident2.getLineNr());
    	}
    	res = new TokenTupel(Terminal.TYPE, t);
        
    	return res;
	}
}
