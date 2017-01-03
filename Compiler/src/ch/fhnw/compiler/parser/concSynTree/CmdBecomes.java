package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CmdBecomes extends Cmd {
    Expr expr1;
    Expr expr2;

    public CmdBecomes(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
