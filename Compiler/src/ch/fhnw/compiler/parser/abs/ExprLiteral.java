package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class ExprLiteral implements IAbs.IExpr {
    Value value;

    public ExprLiteral(Value value) {
        this.value = value;
    }

    @Override
    public TokenTupel checkR() throws ContextError {
    	TokenTupel res;
       if(value.isBool())res = new TokenTupel(Terminal.TYPE, Type.BOOL);
       else res = new TokenTupel(Terminal.TYPE,Type.INT32);
       return res;
    }

    @Override
    public TokenTupel checkL(boolean canInit) throws ContextError {
    	
    	return null;
    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        if (!value.isBool())
            Compiler.getCodeArray().put(loc, new IInstructions.LoadImInt(value.getIntValue()));
        else
            Compiler.getCodeArray().put(loc, new IInstructions.LoadImInt(value.getBoolAsInt()));

        return loc + 1;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return value.getLine();
    }

	@Override
	public TokenTupel checkL() throws ContextError {
		// TODO
//		String msg;
//    	if(value.isBool())msg=value.boolValue.toString();
//    	else msg = value.intValue.toString();
//
//        throw new ContextError("can't use Literal " + msg + " on left.", value.getLine());
        return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
