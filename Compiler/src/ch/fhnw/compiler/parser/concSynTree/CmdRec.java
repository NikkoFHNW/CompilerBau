package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class CmdRec extends AbstractCmd {
    TokenTupel ident;
    RecConstrIdentFirst recConstr;

    public CmdRec(TokenTupel ident, RecConstrIdentFirst recConstr) {
        this.ident = ident;
        this.recConstr = recConstr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
