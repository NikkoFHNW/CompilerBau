package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.RecordStore;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

import java.util.List;

public class CmdRec implements IAbs.ICmd {
    TokenTupel recident;
    TokenTupel ident;
    List<TokenTupel> recConstr;

    public CmdRec(TokenTupel recident, TokenTupel ident, List<TokenTupel> recConstr) {
        this.recident = recident;
        this.ident = ident;
        this.recConstr = recConstr;
    }

    @Override
    public void check(boolean canInit) throws ContextError {

    	
    	
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
	public void check() throws ContextError {
		// TODO Auto-generated method stub
		RecordStore rs=Compiler.getScope().getRecordStoreTable().getRecordStore(recident.toString());
//		if(rs==null)throw new ContextError("Rectype " + recident+" doesn't exist.", recConstr.getLine());
		
		Store sto = new Store(ident.toString(), null, false);
		sto.setRecType(recident.toString());
		if(Compiler.getScope().getStoreTable().addStore(sto)){
			throw new ContextError("already declared " + ident +".", ident.getLineNr());
		}
		
		recConstr.
//		recConstr.g
//		recConstr.g
	}
}
