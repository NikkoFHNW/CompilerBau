package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class RepTerm3 implements IConcSynWrapper{
    Term3 term3;
    RepTerm3 next;

    public RepTerm3(Term3 term3) {
        this.term3 = term3;
    }

    public void setNext(RepTerm3 next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
