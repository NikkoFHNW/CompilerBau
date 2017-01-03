package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepFactor implements IConcSynWrapper {
    AbstractFactor factor;
    RepFactor next;

    public RepFactor(AbstractFactor factor) {
        this.factor = factor;
    }

    public void setNext(RepFactor next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
