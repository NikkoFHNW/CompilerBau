package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepRecordData  implements IConcSyn.IDecl {
    TokenTupel ident;
    RepRecordData next;

    public RepRecordData(TokenTupel ident) {
        this.ident = ident;
    }

    public void setNext(RepRecordData next) {
        if (next == null) {
            this.next = next;
        } else {
            next.setNext(next);
        }

    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
