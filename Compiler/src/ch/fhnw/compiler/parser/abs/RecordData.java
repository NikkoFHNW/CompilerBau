package ch.fhnw.compiler.parser.abs;

import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class RecordData implements IAbs.IDecl {
	
	IDecl data;
	RecordData recData;

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