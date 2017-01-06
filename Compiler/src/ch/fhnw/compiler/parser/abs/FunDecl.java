package ch.fhnw.compiler.parser.abs;


import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class FunDecl implements IAbs.IDecl {

	TokenTupel ident;
	IParam pList;
	IStoDecl stoDecl;
	IGlobImp globImps;
	ICpsDecl localCpsStoDecl;
	ICmd cpsCmd;
	
	public FunDecl(TokenTupel ident, IParam iParam, IStoDecl iStoDecl, IGlobImp iGlobImp, ICpsDecl iCpsDecl,ICmd iCmd) {
		// TODO Auto-generated constructor stub
		this.ident=ident;
		this.pList=iParam;
		this.stoDecl=iStoDecl;
		this.globImps=iGlobImp;
		this.localCpsStoDecl=iCpsDecl;
		this.cpsCmd=iCmd;
		
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

}