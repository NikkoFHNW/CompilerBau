package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.CmdOutput;
import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdDebugOut extends AbstractCmd{
    Expr expr;

    public CmdDebugOut(Expr expr) {
        this.expr = expr;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        return new CmdOutput(expr.toAbstrSyntax());
    }
}
