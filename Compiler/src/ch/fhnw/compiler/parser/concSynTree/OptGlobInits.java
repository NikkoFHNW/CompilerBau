package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class OptGlobInits implements IConcSynWrapper{
    GlobInits globInits;

    public OptGlobInits(GlobInits globInits) {
        this.globInits = globInits;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
