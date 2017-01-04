package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordData implements IConcSyn.IDecl {
    TokenTupel ident;
    RepRecordData repRecordData;

    public RecordData(TokenTupel ident, RepRecordData repRecordData) {
        this.ident = ident;
        this.repRecordData = repRecordData;
    }


    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
