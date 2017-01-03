package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Expr implements IConcSynWrapper{
    Term1 term1;
    RepTerm1 next;

    public Expr(Term1 term1, RepTerm1 next) {
        this.term1 = term1;
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
