package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepSemicolonStoDecl implements  IConcSynWrapper {
    StoDecl stoDecl;
    RepSemicolonStoDecl repSemicolonStoDecl;

    public RepSemicolonStoDecl(StoDecl stoDecl, RepSemicolonStoDecl repSemicolonStoDecl) {
        this.stoDecl = stoDecl;
        this.repSemicolonStoDecl = repSemicolonStoDecl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
