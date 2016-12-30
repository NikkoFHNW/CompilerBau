package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;

public class StoDecl implements IConcSynWrapper{
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;

    public StoDecl(OptChangeMode optChangeMode, TypedIdent typedIdent) {
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
    }
    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
