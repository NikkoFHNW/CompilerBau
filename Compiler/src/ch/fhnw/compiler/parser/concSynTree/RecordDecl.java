package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordDecl implements IConcSynWrapper{
    TokenTupel recident;
    RecordData recordData;

    public RecordDecl(TokenTupel recident, RecordData recordData) {
        this.recident = recident;
        this.recordData = recordData;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
