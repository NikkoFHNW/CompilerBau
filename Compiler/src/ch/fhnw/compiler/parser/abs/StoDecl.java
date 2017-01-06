package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parserNew.AbsTree.TypedIdent;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions.Store;

public class StoDecl implements IAbs.IStoDecl {
	
//	ChangeMode cm;
	
	TokenTupel cm;
	IAbs.IExpr typedId;
	
	public StoDecl(TokenTupel cm, IAbs.IExpr typedId){
		this.cm=cm;
//		this.ident=ident;
//		this.type=type;
		this.typedId=typedId;
	}

	@Override
	public void checkDeclaration() throws ContextError {
		// TODO Auto-generated method stub
		
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
	public TokenTupel getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
