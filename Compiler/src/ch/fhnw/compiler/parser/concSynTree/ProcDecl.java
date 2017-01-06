package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class ProcDecl implements IConcSyn.IProcDecl {
    TokenTupel ident;
    ParamList param;
    OptGlobalglobImps optGlobalglobImps;
    OptLocalcpsStoDecl optLocalcpsStoDecl;
    CpsCmd cpsCmd;

    public ProcDecl(TokenTupel ident, ParamList param, OptGlobalglobImps optGlobalglobImps, OptLocalcpsStoDecl optLocalcpsStoDecl, CpsCmd cpscmd) {
        this.ident = ident;
        this.param = param;
        this.optGlobalglobImps = optGlobalglobImps;
        this.optLocalcpsStoDecl = optLocalcpsStoDecl;
        this.cpsCmd = cpscmd;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.ProcDecl( ident, param.toAbstrSyntax(), optGlobalglobImps.toAbstrSyntax(), optLocalcpsStoDecl.toAbstrSyntax(),cpsCmd.toAbstrSyntax());
    }
}
