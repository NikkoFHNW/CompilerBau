package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class OptMechMode implements IConcSynWrapper{
    Token mechmode;

    public OptMechMode(Token mechmode) {
        this.mechmode = mechmode;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
