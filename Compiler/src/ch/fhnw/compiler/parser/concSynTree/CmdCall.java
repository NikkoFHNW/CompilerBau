package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.CmdProcCall;
import ch.fhnw.compiler.parser.abs.GlobalInit;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.RoutineCall;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class CmdCall extends AbstractCmd {
    TokenTupel ident;
    ExprList exprList;
    OptGlobInits optGlobInits;

    public CmdCall(TokenTupel ident, ExprList exprList, OptGlobInits optGlobInits) {
        this.ident = ident;
        this.exprList = exprList;
        this.optGlobInits = optGlobInits;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        RoutineCall routineCall = new RoutineCall(ident, exprList.toAbstrSyntax());
        return new CmdProcCall(routineCall, optGlobInits.toAbstrSyntax());
    }
}