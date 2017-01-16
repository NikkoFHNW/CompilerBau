package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Operator;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class ExprMonadic implements IAbs.IExpr {
    TokenTupel operator;
    IExpr expr;

    public ExprMonadic(TokenTupel operator, IExpr expr) {
        this.operator = operator;
        this.expr = expr;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
        TokenTupel e = expr.checkR();
        TokenTupel res;
        switch(operator.getOp()){
        case PLUS:
        case MINUS:
            if (e.getType() == Type.INT32) {
            	res = new TokenTupel(Terminal.TYPE, Type.INT32);            			
                return res;
            } else {
                throw new ContextError(
                        "Type error in Operator "
                        + operator.getOp(),
                        operator.getLineNr());
            }
        case NOT:
	        if (e.getType() == Type.BOOL) {
	        	res = new TokenTupel(Terminal.TYPE, Type.BOOL);
	            return res;
	        } else {
	            throw new ContextError(
                        "Type error in Operator "
                        + operator.getOp(),
                        operator.getLineNr());
	        }
        default:    throw new ContextError(
                "Not a monadic Operator:  "
                + operator.getOp(),
                operator.getLineNr());
        }
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
        return null;
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        int loc1 = expr.code(loc);
        if (operator.getTerminal() == Terminal.ADDOPR) {
            if ((operator).getOp() == Operator.MINUS) {
                Compiler.getCodeArray().put(loc1, new IInstructions.NegInt());
                return loc1 + 1;
            } else {
                return loc1;
            }
        } else if (operator.getTerminal() == Terminal.NOT) {
            Compiler.getCodeArray().put(loc1++, new IInstructions.CondJump(loc1+2));
            Compiler.getCodeArray().put(loc1++, new IInstructions.LoadImInt(0));
            Compiler.getCodeArray().put(loc1++, new IInstructions.UncondJump(loc1+1));
            Compiler.getCodeArray().put(loc1++, new IInstructions.LoadImInt(1));
            return loc1;
        } else {
            throw new RuntimeException();
        }
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
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
        throw new ContextError(
                "Found operator " 
                + operator.getOp() 
                + "in the left part of an assignement",
                this.expr.getLine());
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
