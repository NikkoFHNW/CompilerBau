package ch.fhnw.compiler.parser.abs;

import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class CpsDecl implements IAbs.IDecl{
	
	IDecl decl;
	IDecl cpsDecl;
	
	public CpsDecl(IDecl decl, IDecl cpsDecl){
		this.decl=decl;
		this.cpsDecl=cpsDecl;
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
		decl.checkDeclaration();
        if (cpsDecl != null)
		    cpsDecl.checkDeclaration();
		
	}

	@Override
	public int check(int locals) throws ContextError {
		return 0;
	}


	@Override
	public int code(int loc) throws CodeTooSmallError {
//		System.out.println("code cpsDecl");

		int loc1 = decl.code(loc);
		if (cpsDecl == null)
			return loc1;

		return cpsDecl.code(loc1);
	}


}
