package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.CmdAssi;
import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdBecomes extends AbstractCmd {
    Expr expr1;
    Expr expr2;

    public CmdBecomes(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        return new CmdAssi(expr1.toAbstrSyntax(), expr2.toAbstrSyntax());
    }
}
