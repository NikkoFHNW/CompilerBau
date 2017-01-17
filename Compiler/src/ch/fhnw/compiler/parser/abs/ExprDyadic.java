package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Operator;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;
//import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

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
    public int code(final int loc) throws ICodeArray.CodeTooSmallError {
        ICodeArray codeArray = Compiler.getCodeArray();
        int loc1 = expr1.code(loc);
        if (operator.getOp() != Operator.CAND
                && operator.getOp() != Operator.COR) {
            loc1 = expr2.code(loc1);
            switch (operator.getOp()) {
                case PLUS:
                    codeArray.put(loc1, new IInstructions.AddInt());
                    break;
                case MINUS:
                    codeArray.put(loc1, new IInstructions.SubInt());
                    break;
                case TIMES:
                    codeArray.put(loc1, new IInstructions.MultInt());
                    break;
                case DIV:
                    codeArray.put(loc1, new IInstructions.DivTruncInt());
                    break;
                case MOD:
                    codeArray.put(loc1, new IInstructions.ModTruncInt());
                    break;
                case EQ:
                    codeArray.put(loc1, new IInstructions.EqInt());
                    break;
                case NE:
                    codeArray.put(loc1, new IInstructions.NeInt());
                    break;
                case GT:
                    codeArray.put(loc1, new IInstructions.GtInt());
                    break;
                case LT:
                    codeArray.put(loc1, new IInstructions.LtInt());
                    break;
                case GE:
                    codeArray.put(loc1, new IInstructions.GeInt());
                    break;
                case LE:
                    codeArray.put(loc1, new IInstructions.LeInt());
                    break;
                default:
                    throw new RuntimeException();
            }
            return loc1 + 1;
        } else if (operator.getOp() == Operator.CAND) {
            int loc2 = expr2.code(loc1 + 1);
            codeArray.put(loc2++, new IInstructions.UncondJump(loc2+1));
            codeArray.put(loc1, new IInstructions.CondJump(loc2));
            codeArray.put(loc2++, new IInstructions.LoadImInt(0));
            return loc2;
        } else {
            int loc2 = expr2.code(loc1 + 2);
            codeArray.put(loc2++, new IInstructions.UncondJump(loc2+1));
            codeArray.put(loc1, new IInstructions.CondJump(loc2+2));
            codeArray.put(loc2++, new IInstructions.LoadImInt(1));
            return loc2;
        }
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return expr1.getLine();
    }

	@Override
	public TokenTupel checkL() throws ContextError {
		// TODO Auto-generated method stub
		throw new ContextError("should be called as rightexpr", this.getLine());
	}

	@Override
	public TokenTupel check() throws ContextError {
        return null;
	}
}
