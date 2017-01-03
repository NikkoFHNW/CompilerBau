package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;

public class MonadicOpr implements IConcSynWrapper {
    Terminal opr;

    public MonadicOpr(Terminal opr) {
        this.opr = opr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
