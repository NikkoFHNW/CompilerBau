package ch.fhnw.compiler.parser.abs;

import java.lang.reflect.Parameter;
import java.util.List;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class CmdProcCall implements IAbs.ICmd {
//    TokenTupel ident; in routineCall enthalten
    RoutineCall routineCall;
    IGlobInit globalInit;

    public CmdProcCall(RoutineCall routineCall, IGlobInit globalInit) {
        this.routineCall = routineCall;
        this.globalInit = globalInit;
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
		List<IExpr> li =routineCall.exprList;
		
		Routine r =Compiler.getRoutineTable().getRoutine(routineCall.ident.toString());
		if(r==null)
			throw new ContextError("no routine called " + routineCall.ident, routineCall.getLine());
		
		List<ch.fhnw.compiler.context.Parameter> pList =r.getParamList();
		
		if(pList.size()!=li.size())
			throw new ContextError("missing parameter.", routineCall.getLine());
		
		for(int x=0;x<pList.size();x++){
			Type needed = pList.get(x).getType();
			Type have = li.get(x).checkR().getType();
			
			if(!needed.equals(have))
				throw new ContextError("Parameter missmatch. should be " +needed+ " but is "+have, routineCall.getLine());
		}
		
		

		if(globalInit!=null)
			globalInit.check();
		
	}
}
