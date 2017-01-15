package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.parser.concSynTree.IConcSyn;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class GlobalInit implements IAbs.IGlobInit{
    TokenTupel ident;
    IGlobInit next;

    public GlobalInit(TokenTupel ident, IGlobInit next) {
        this.ident = ident;
        this.next = next;
    }

    @Override
    public Object check(Object initList) throws ContextError {
        return null;
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
	public TokenTupel check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
