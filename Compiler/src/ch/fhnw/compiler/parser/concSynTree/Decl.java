package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Decl implements IConcSynWrapper{
    StoDecl stoDecl;
    FunDecl funDecl;
    ProcDecl procDecl;

    public Decl(StoDecl stoDecl, FunDecl funDecl, ProcDecl procDecl) {
        this.stoDecl = stoDecl;
        this.funDecl = funDecl;
        this.procDecl = procDecl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
