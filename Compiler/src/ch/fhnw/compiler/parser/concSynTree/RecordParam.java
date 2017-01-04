package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordParam implements IConcSyn.IParam {
    TokenTupel ident;
    TokenTupel recident;

    public RecordParam(TokenTupel ident, TokenTupel recIdent) {
        this.ident = ident;
        this.recident = recIdent;
    }

    @Override
    public IAbs.IParam toAbstrSyntax(IRepCommaParam repParam) {
        return null;
    }
}
