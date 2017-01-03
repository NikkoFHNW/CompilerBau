package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CmdDebugIn extends AbstractCmd {
    Expr expr;

    public CmdDebugIn(Expr expr) {
        this.expr = expr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
