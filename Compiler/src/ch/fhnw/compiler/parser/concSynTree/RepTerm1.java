package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class RepTerm1 implements IConcSynWrapper{
    Term1 term1;
    RepTerm1 next;

    public RepTerm1(Term1 term1) {
        this.term1 = term1;
    }

    public void setNext(RepTerm1 next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
