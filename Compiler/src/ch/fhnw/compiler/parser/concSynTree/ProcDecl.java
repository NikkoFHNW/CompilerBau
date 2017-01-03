package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class ProcDecl implements IConcSynWrapper {
    Token proc;
    Token ident;
    Param param;
    OptGlobalglobImps optGlobalglobImps;
    OptLocalcpsStoDecl optLocalcpsStoDecl;
    Token _do;
    CpsCmd cpsCmd;
    Token endproc;

    public ProcDecl(TokenTupel proc, TokenTupel ident, Param param, OptGlobalglobImps optGlobalglobImps, OptLocalcpsStoDecl optLocalcpsStoDecl, CpsCmd cpscmd) {
        this.proc = proc;
        this.ident = ident;
        this.param = param;
        this.optGlobalglobImps = optGlobalglobImps;
        this.optLocalcpsStoDecl = optLocalcpsStoDecl;
        this.cpsCmd = cpscmd;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
