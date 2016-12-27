package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepRecordData  implements IConcSynWrapper{
    Token comma;
    Token ident;
    Token colon;
    Token atomtype;
    RepRecordData repRecordData;

    public RepRecordData(Token comma, Token ident, Token colon, Token atomtype, RepRecordData repRecordData) {
        this.comma = comma;
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
