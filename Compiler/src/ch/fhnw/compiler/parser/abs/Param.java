package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.concSynTree.OptChangeMode;
import ch.fhnw.compiler.parser.concSynTree.OptFlowMode;
import ch.fhnw.compiler.parser.concSynTree.OptMechMode;
import ch.fhnw.compiler.parser.concSynTree.TypedIdent;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class Param implements IAbs.IParam {
	
    TokenTupel optFlowMode;
    TokenTupel optMechMode;
    TokenTupel optChangeMode;
    IExpr typedIdent;
	
	public Param(TokenTupel flow, TokenTupel mech, TokenTupel change, IExpr typ) {
		// TODO Auto-generated constructor stub
		this.optFlowMode=flow;
		this.optMechMode=mech;
		this.optChangeMode=change;
		typedIdent=typ;
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
	public void check(Object routine) throws ContextError {
		// TODO Auto-generated method stub
		
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
