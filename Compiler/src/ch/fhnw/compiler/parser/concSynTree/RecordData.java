package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordData implements IConcSyn.IDecl {
    TokenTupel ident;
    RepRecordData repRecordData;
    OptChangeMode optChangeMode;

    public RecordData(TokenTupel ident, RepRecordData repRecordData, OptChangeMode opc) {
        this.ident = ident;
        this.repRecordData = repRecordData;
        this.optChangeMode=opc;
    }


    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
}
