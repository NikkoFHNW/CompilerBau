package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.context.Routine;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class ParamList implements IAbs.IParam {
	
	IParam param;
	IParam next;

	/*
	* Obsolete!! Param hat next
	*
	* */

	


	public ParamList(ch.fhnw.compiler.parser.abs.IAbs.IParam param,
			ch.fhnw.compiler.parser.abs.IAbs.IParam next) {
		// TODO Auto-generated constructor stub
		this.param = param;
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
		param.check(routine);
		if(next!=null)
			next.check(routine);
		
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
		return 0;
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
