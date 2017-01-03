package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CpsCmd implements IConcSynWrapper {
    AbstractCmd cmd;
    CpsCmd next;

    public CpsCmd(AbstractCmd cmd) {
        this.cmd = cmd;
    }

    public void setNext(CpsCmd next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
