package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class GlobImp implements IConcSyn.IGlobImp {
    OptFlowMode optFlowMode;
    OptChangeMode optChangeMode;
    Token ident;

    public GlobImp(OptFlowMode optFlowMode, OptChangeMode optChangeMode, Token ident) {
        this.optFlowMode = optFlowMode;
        this.optChangeMode = optChangeMode;
        this.ident = ident;
    }

    @Override
    public IAbs.IGlobImp toAbstrSyntax(IRepCommaGlobImp repGlobImp) {
        return null;
    }
}
