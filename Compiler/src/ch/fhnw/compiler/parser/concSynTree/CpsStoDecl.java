package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CpsStoDecl implements IConcSynWrapper {
    StoDecl stoDecl;
    RepSemicolonStoDecl repSemicolonStoDecl;

    public CpsStoDecl(StoDecl stoDecl, RepSemicolonStoDecl repSemicolonStoDecl) {
        this.stoDecl = stoDecl;
        this.repSemicolonStoDecl = repSemicolonStoDecl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
