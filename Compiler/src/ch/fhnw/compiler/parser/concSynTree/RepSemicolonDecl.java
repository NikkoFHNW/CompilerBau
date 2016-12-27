package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepSemicolonDecl implements IConcSynWrapper {
    Token semicolon;
    Decl decl;
    RepSemicolonDecl repSemicolonDecl;

    public RepSemicolonDecl(Token semicolon, Decl decl, RepSemicolonDecl repSemicolonDecl) {
        this.semicolon = semicolon;
        this.decl = decl;
        this.repSemicolonDecl = repSemicolonDecl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
