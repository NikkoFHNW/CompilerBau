package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class Expr implements IConcSynWrapper{
    Term1 term1;
    RepTerm1 repTerm1;

    public Expr(Term1 term1, RepTerm1 repTerm1) {
        this.term1 = term1;
        this.repTerm1 = repTerm1;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
