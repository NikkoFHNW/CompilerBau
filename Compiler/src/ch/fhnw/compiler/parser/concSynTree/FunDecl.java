package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class FunDecl implements IConcSynWrapper {
    Token fun;
    Token ident;
    ParamList paramList;
    Token returns;
    StoDecl stoDecl;
    OptGlobalglobImps optGlobalglobImps;
    OptLocalcpsStoDecl optLocalcpsStoDecl;
    Token _do;
    CpsCmd cpsCmd;
    Token endfun;

    public FunDecl(Token fun, Token ident, ParamList paramList, Token returns, StoDecl stoDecl, OptGlobalglobImps optGlobalglobImps, OptLocalcpsStoDecl optLocalcpsStoDecl, Token _do, CpsCmd cpsCmd, Token endfun) {
        this.fun = fun;
        this.ident = ident;
        this.paramList = paramList;
        this.returns = returns;
        this.stoDecl = stoDecl;
        this.optGlobalglobImps = optGlobalglobImps;
        this.optLocalcpsStoDecl = optLocalcpsStoDecl;
        this._do = _do;
        this.cpsCmd = cpsCmd;
        this.endfun = endfun;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
