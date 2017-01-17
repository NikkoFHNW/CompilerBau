package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.concSynTree.FactorLiteral;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.CodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public class CmdInput implements IAbs.ICmd {
    IExpr expr;

    public CmdInput(IExpr expr) {
        this.expr = expr;
    }

    @Override
    public void check(boolean canInit) throws ContextError {

    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        ExprStore exprStore = (ExprStore) this.expr;
        CodeArray codeArr = Compiler.getCodeArray();

        Store store = Compiler.getScope().getStoreTable().getStore(exprStore.ident);

        if (store.getType() == Type.BOOL)
            codeArr.put(loc++, new IInstructions.InputBool(store.getIdent()));
        else
            codeArr.put(loc++, new IInstructions.InputInt(store.getIdent()));


        return loc;
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
		expr.checkL();
	}
}
