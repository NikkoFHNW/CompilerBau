package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.CmdAssi;
import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdBecomes extends AbstractCmd {
    Expr exprL;
    Expr exprR;

    public CmdBecomes(Expr exprL, Expr exprR) {
        this.exprL = exprL;
        this.exprR = exprR;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() throws GrammarError {
        return new CmdAssi(exprR.toAbstrSyntax(), exprL.toAbstrSyntax());
    }
}
