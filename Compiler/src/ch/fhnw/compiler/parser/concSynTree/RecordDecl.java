package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordDecl implements IConcSyn.IDecl {
    TokenTupel recident;
    RecordData recordData;

    public RecordDecl(TokenTupel recident, RecordData recordData) {
        this.recident = recident;
        this.recordData = recordData;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
