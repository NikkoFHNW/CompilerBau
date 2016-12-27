package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class MonadicOpr implements IConcSynWrapper{
    Token notopr;

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
