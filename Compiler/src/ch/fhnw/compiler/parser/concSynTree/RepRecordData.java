package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.RecordData;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepRecordData  implements IConcSyn.IRepRecData {
    TokenTupel ident;
    TokenTupel type;
    RepRecordData next;
    OptChangeMode opc;
    

    public RepRecordData(TokenTupel ident,TokenTupel type,OptChangeMode opc) {
        this.ident = ident;
        this.type=type;
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
	public IAbs.IRecData toAbstrSyntax() {
        if(next != null){
//    		StoDecl sd = new StoDecl(cm, typedId)
//    		RecordDecl rd = new RecordDecl(ident, next.toAbstrSyntax());
//    		RecordData rd =
            return new RecordData(ident, type, opc.toAbstrSyntax(), next.toAbstrSyntax());
//    		return next.toAbstrSyntax(rd);
        }else{
            return new RecordData(ident,type,opc.toAbstrSyntax(),null);
        }
	}

}
