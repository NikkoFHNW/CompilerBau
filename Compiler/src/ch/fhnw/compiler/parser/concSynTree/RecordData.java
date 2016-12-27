package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RecordData implements IConcSynWrapper{
    Token ident;
    Token colon;
    Token atomtype;
    RepRecordData repRecordData;

    public RecordData(Token ident, Token colon, Token atomtype, RepRecordData repRecordData) {
        this.ident = ident;
        this.colon = colon;
        this.atomtype = atomtype;
        this.repRecordData = repRecordData;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
