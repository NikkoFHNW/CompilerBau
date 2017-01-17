package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

import java.util.List;

public class RoutineCall implements IAbs.IExpr {
    TokenTupel ident;
    List<IExpr> exprList;

    public RoutineCall(TokenTupel ident, List<IExpr> exprList) {
        this.ident = ident;
        this.exprList = exprList;
    }

    public TokenTupel getIdent() {
        return ident;
    }

    public List<IExpr> getExprList() {
        return exprList;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
        return null;
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
        return null;
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        int loc1 = loc;
        int size = 0;

        if (Compiler.getRoutineTable().getRoutine(ident.getStringVal()).getRoutineType()
                == Routine.RoutineTypes.FUNCTION) {
            size = 1;
        }

        Compiler.getCodeArray().put(loc1++, new IInstructions.AllocBlock(size)); //Block vs stack
        for (IExpr e : exprList) {
//            System.out.println("exprCall");
            loc1 = e.code(loc1);

        }
        Compiler.getRoutineTable().getRoutine(ident.getStringVal()).addCall(loc1++);
        return loc1;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return ident.getLineNr();
    }

	@Override
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
