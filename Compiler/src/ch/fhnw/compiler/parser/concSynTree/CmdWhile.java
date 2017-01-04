package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdWhile extends AbstractCmd {
    Expr expr;
    CpsCmd cpsCmd;

    public CmdWhile(Expr expr, CpsCmd cpsCmd) {
        this.expr = expr;
        this.cpsCmd = cpsCmd;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax(IAbs.ICmd repCmd) {
        return null;
    }
}
