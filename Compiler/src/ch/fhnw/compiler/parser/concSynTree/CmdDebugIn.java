package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdDebugIn extends AbstractCmd {
    Expr expr;

    public CmdDebugIn(Expr expr) {
        this.expr = expr;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax(IAbs.ICmd repCmd) {
        return null;
    }

}
