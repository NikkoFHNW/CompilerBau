package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

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
