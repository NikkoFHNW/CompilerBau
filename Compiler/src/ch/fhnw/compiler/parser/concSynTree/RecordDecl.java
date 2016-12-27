package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RecordDecl implements IConcSynWrapper{
    Token rec;
    Token ident;
    Token colon;
    Token lcurl;
    RecordData recordData;
    Token rcurl;

    public RecordDecl(Token rec, Token ident, Token colon, Token lcurl, RecordData recordData, Token rcurl) {
        this.rec = rec;
        this.ident = ident;
        this.colon = colon;
        this.lcurl = lcurl;
        this.recordData = recordData;
        this.rcurl = rcurl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
