package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepRecordData  implements IConcSyn.IDecl {
    TokenTupel ident;
    RepRecordData next;
    OptChangeMode opc;
    

    public RepRecordData(TokenTupel ident,OptChangeMode opc) {
        this.ident = ident;
        this.opc = opc;
    }

    public void setNext(RepRecordData next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }

    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
