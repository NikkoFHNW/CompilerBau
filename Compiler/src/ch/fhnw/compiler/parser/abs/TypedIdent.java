package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class TypedIdent implements IAbs.IParam {

	TokenTupel ident;
	TokenTupel type;
	
	public TokenTupel getIdent() {
		return ident;
	}

	public void setIdent(TokenTupel ident) {
		this.ident = ident;
	}

	public TokenTupel getType() {
		return type;
	}

	public void setType(TokenTupel type) {
		this.type = type;
	}

	public TypedIdent(TokenTupel ident, TokenTupel type){
		this.ident=ident;
		this.type=type;
	}
	
	@Override
	public String toString() {
		return ident.getStringVal();
	}

	@Override
	public String toString(String indent) {
		return null;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void check(Routine routine) throws ContextError {
		Store sto = new Store(ident.toString(), type.getType(), false);

		if(!Compiler.getScope().addStore(sto)){
			throw new ContextError("already declared "+ident.toString(), 0);
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
		int loc = i;
		Store store = Compiler.getGlobalStoreTable().getStore(ident.toString());
		Compiler.getCodeArray().put(loc++, new IInstructions.LoadAddrRel(store.getRelAdress()));
		Compiler.getCodeArray().put(loc++, new IInstructions.Store());

		return loc;
	}

//	@Override
//	public int codeIn(int loc, int count, int locals) throws CodeTooSmallError {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int codeOut(int loc, int count, int locals) throws CodeTooSmallError {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
