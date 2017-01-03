package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class FactorParen extends AbstractFactor implements IConcSynWrapper {
    Expr expr;

    public FactorParen(Expr expr) {
        this.expr = expr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
