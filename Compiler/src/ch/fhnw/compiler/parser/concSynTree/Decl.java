package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class Decl implements IConcSyn.IDecl {
    StoDecl stoDecl;
    FunDecl funDecl;
    ProcDecl procDecl;

    public Decl(StoDecl stoDecl, FunDecl funDecl, ProcDecl procDecl) {
        this.stoDecl = stoDecl;
        this.funDecl = funDecl;
        this.procDecl = procDecl;
    }

    @Override
    public IAbs.IDecl toAbstrSyntax() {
        return null;
    }
    
}
