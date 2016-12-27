package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class OptInitOrExprList implements IConcSynWrapper{

    Token init;
    ExprList exprList;

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
