package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CmdDebugOut extends AbstractCmd{
    Expr expr;

    public CmdDebugOut(Expr expr) {
        this.expr = expr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
