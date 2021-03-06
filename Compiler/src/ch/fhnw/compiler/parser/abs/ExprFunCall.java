package ch.fhnw.compiler.parser.abs;

import java.util.List;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.RecordParameter;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Scope;
import ch.fhnw.compiler.parser.abs.IAbs.ContextError;
import ch.fhnw.compiler.parser.abs.IAbs.IExpr;
import ch.fhnw.compiler.parser.concSynTree.RecordParam;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class ExprFunCall implements IAbs.IExpr {
    RoutineCall routineCall;

    public ExprFunCall(RoutineCall routineCall) {
        this.routineCall = routineCall;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
        return check();
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
        return check();
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
//        System.out.println("code exprFunCall");

        return routineCall.code(loc);
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return routineCall.getLine();
    }

	@Override
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		TokenTupel res =null;
        List<IExpr> li =routineCall.exprList;
		
		Routine r =Compiler.getRoutineTable().getRoutine(routineCall.ident.getStringVal());
		if(r==null)
			throw new ContextError("no routine called " + routineCall.ident, routineCall.getLine());
		
		List<ch.fhnw.compiler.context.Parameter> pList =r.getParamList();
		
		if(pList.size()!=li.size())
			throw new ContextError("missing parameter.", routineCall.getLine());
		
		for(int x=0;x<pList.size();x++){
			Type needed = pList.get(x).getType();
			Type have = li.get(x).checkR().getType();

            if(needed==null) {
                RecordParameter rp = (RecordParameter) pList.get(x);
                String rtNeed = rp.getRecIdent();
                if (have != null)
                    throw new ContextError("Rec needed, not "+have.toString(), routineCall.getLine());

                ExprStore rp2 = (ExprStore) li.get(x);
                String rtActual =  Compiler.getScope().getStoreTable().getStore(rp2.ident).getRecType();

                if (!rtNeed.equals(rtActual))
                    throw new ContextError("two diff rec types. need: "+rtNeed+". actual: "+rtActual, routineCall.getLine());
            }
			
			else if(!needed.equals(have))
				throw new ContextError("Parameter missmatch. should be " +needed+ " but is "+have, routineCall.getLine());
		}
		
		res = new TokenTupel(Terminal.TYPE,r.getType());
		return res;
	}
}
