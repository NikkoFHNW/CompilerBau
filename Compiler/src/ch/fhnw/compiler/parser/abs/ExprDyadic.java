package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.Operator;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class ExprDyadic implements IAbs.IExpr {
    TokenTupel operator;
    IExpr expr1;
    IExpr expr2;

    public ExprDyadic(TokenTupel operator, IExpr expr1, IExpr expr2) {
        this.operator = operator;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
        TokenTupel e1 = expr1.checkL();
        TokenTupel e2 = expr2.checkR();
        TokenTupel res;
        
        switch(operator.getOp()){
        case PLUS:
        case MINUS:
        case TIMES:
        case DIV:
        case MOD:
            if (e1.getType()==Type.INT32 
            && e2.getType() == Type.INT32) {
            res= new TokenTupel(Terminal.TYPE, Type.INT32); 
            return res;
        } else {
            throw new ContextError(
                    "Type error in Operator "
                    + operator.getOp(),
                    operator.getLineNr());
        }
        case EQ:
        case NE:
            if (e1.getType() == Type.BOOL
                && e2.getType() == Type.BOOL) {
            	res = new TokenTupel(Terminal.TYPE, Type.BOOL);
                return res;
            }else {
                throw new ContextError(
                        "Type error in Operator "
                        + operator.getOp(),
                        operator.getLineNr());
            }
        case GT:
        case LT:
        case GE:
        case LE:
            if (e1.getType() == Type.INT32 
            && e2.getType() == Type.INT32) {
            	res = new TokenTupel(Terminal.TYPE, Type.BOOL);
            return res;
        } else {
            throw new ContextError(
                    "Type error in Operator "
                    + operator.getOp(),
                    operator.getLineNr());
        }
        case CAND:
        case COR:
            if (e1.getType() == Type.BOOL
                && e2.getType() == Type.BOOL) {
            	res = new TokenTupel(Terminal.TYPE, Type.BOOL);
                return res;
            } else {
                throw new ContextError(
                        "Type error in Operator "
                        + operator.getOp(),
                        operator.getLineNr());
            }
        default:  throw new ContextError(
                "Type error in Operator "
                + operator.getOp(),
                operator.getLineNr());
    }
    }
        
        
        
    	
    	
    	
    	

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
        throw new ContextError(
                "Found operator " 
                + operator.getOp() 
                + "in the left part of an assignement",
                operator.getLineNr());
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
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
		throw new ContextError("should be called as rightexpr", this.expr1.getLine());
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
