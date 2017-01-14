package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RecordData implements IConcSyn.IRecData {
    TokenTupel ident;
    TokenTupel type;
    RepRecordData repRecordData;
    OptChangeMode optChangeMode;

    public RecordData(TokenTupel ident, TokenTupel type,RepRecordData repRecordData, OptChangeMode opc) {
        this.ident = ident;
        this.type=type;
        this.repRecordData = repRecordData;
        this.optChangeMode=opc;
    }


    @Override
    public IAbs.IRecData toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.RecordData(ident,
        		type,optChangeMode.toAbstrSyntax(),repRecordData.toAbstrSyntax());
    }
}
