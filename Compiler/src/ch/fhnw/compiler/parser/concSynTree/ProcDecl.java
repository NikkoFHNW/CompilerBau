package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class ProcDecl implements IConcSynWrapper {
    Token proc;
    Token ident;
    Param param;
    OptGlobalglobImps optGlobalglobImps;
    OptLocalcpsStoDecl optLocalcpsStoDecl;
    Token _do;
    CpsCmd cpsCmd;
    Token endproc;

    public ProcDecl(Token proc, Token ident, Param param, OptGlobalglobImps optGlobalglobImps, OptLocalcpsStoDecl optLocalcpsStoDecl, Token _do, CpsCmd cpsCmd, Token endproc) {
        this.proc = proc;
        this.ident = ident;
        this.param = param;
        this.optGlobalglobImps = optGlobalglobImps;
        this.optLocalcpsStoDecl = optLocalcpsStoDecl;
        this._do = _do;
        this.cpsCmd = cpsCmd;
        this.endproc = endproc;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
