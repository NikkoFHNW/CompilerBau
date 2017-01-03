package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class CmdCall extends AbstractCmd {
    ExprList exprList;
    OptGlobInits optGlobInits;
    TokenTupel ident;

    public CmdCall(TokenTupel ident, ExprList exprList, OptGlobInits optGlobInits) {
        this.ident = ident;
        this.exprList = exprList;
        this.optGlobInits = optGlobInits;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}