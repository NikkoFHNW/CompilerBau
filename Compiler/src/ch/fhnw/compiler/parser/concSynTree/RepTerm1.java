package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepTerm1 implements IConcSynWrapper{
    Token bool;

    public RepTerm1(Token bool) {
        this.bool = bool;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
