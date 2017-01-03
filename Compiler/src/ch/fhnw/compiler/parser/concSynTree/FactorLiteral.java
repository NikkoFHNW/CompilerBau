package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FactorLiteral extends AbstractFactor {
    TokenTupel literal;

    public FactorLiteral(TokenTupel literal) {
        this.literal = literal;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
