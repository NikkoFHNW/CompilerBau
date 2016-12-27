package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;

public class StoDecl implements IConcSynWrapper{
    OptChangeMode optChangeMode;
    TypedIdent typedIdent;
    RecordDecl recordDecl;

    public StoDecl(OptChangeMode optChangeMode, TypedIdent typedIdent, RecordDecl recordDecl) {
        this.optChangeMode = optChangeMode;
        this.typedIdent = typedIdent;
        this.recordDecl = recordDecl;
    }
    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
