package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.CmdCond;
import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdIf extends AbstractCmd {
    Expr expr1;
    CpsCmd cpsCmd1;
    CpsCmd cpsCmd2;

    public CmdIf(Expr expr1, CpsCmd cpsCmd1, CpsCmd cpsCmd2) {
        this.expr1 = expr1;
        this.cpsCmd1 = cpsCmd1;
        this.cpsCmd2 = cpsCmd2;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() throws GrammarError {
        return new CmdCond(expr1.toAbstrSyntax(), cpsCmd1.toAbstrSyntax(), cpsCmd2.toAbstrSyntax());
    }
}
