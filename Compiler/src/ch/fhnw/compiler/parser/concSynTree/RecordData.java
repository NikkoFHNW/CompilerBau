package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordData implements IConcSynWrapper{
    TokenTupel ident;
    RepRecordData repRecordData;

    public RecordData(TokenTupel ident, RepRecordData repRecordData) {
        this.ident = ident;
        this.repRecordData = repRecordData;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
