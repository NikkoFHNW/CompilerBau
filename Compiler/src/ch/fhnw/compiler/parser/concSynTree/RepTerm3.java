package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepTerm3 implements IConcSynWrapper{
    Token addopr;
    Term3 term3;
    RepTerm3 repTerm3;

    public RepTerm3(Token addopr, Term3 term3, RepTerm3 repTerm3) {
        this.addopr = addopr;
        this.term3 = term3;
        this.repTerm3 = repTerm3;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
