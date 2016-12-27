package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class GlobImp implements IConcSynWrapper{
    OptFlowMode optFlowMode;
    OptChangeMode optChangeMode;
    Token ident;

    public GlobImp(OptFlowMode optFlowMode, OptChangeMode optChangeMode, Token ident) {
        this.optFlowMode = optFlowMode;
        this.optChangeMode = optChangeMode;
        this.ident = ident;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
