package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepRecordData  implements IConcSyn.IDecl {
    TokenTupel ident;
    RepRecordData next;

    public RepRecordData(TokenTupel ident) {
        this.ident = ident;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
