package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepRecordData  implements IConcSynWrapper{
    TokenTupel ident;
    RepRecordData next;

    public RepRecordData(TokenTupel ident) {
        this.ident = ident;
    }

    public void setNext(RepRecordData next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
