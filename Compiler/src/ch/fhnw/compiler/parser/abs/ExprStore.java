package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;

public class ExprStore implements IAbs.IExpr {
    String ident;
    boolean isInitialization;

    public ExprStore(String ident, boolean isInitialization) {
        this.ident = ident;
        this.isInitialization = isInitialization;
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
    public int code(final int loc) throws ICodeArray.CodeTooSmallError {
        Store store = Compiler.getScope().getStoreTable().getStore(ident);
        return store.codeLoad(loc);
    }

    public int codeRef(final int loc) throws ICodeArray.CodeTooSmallError {
        Store store = Compiler.getScope().getStoreTable().getStore(ident);
        return store.codeRef(loc);
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
		return null;
	}

	@Override
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
