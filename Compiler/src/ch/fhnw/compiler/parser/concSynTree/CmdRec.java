package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

import java.util.List;

public class CmdRec extends AbstractCmd {
    TokenTupel recident;
    TokenTupel ident;
    List<TokenTupel> recConstr;

    public CmdRec(TokenTupel recident, TokenTupel ident, List<TokenTupel> recConstr) {
        this.recident = recident;
        this.ident = ident;
        this.recConstr = recConstr;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.CmdRec(recident, ident, recConstr);
    }
}
