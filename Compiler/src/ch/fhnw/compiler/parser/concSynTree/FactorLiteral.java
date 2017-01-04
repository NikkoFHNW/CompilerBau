package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FactorLiteral extends AbstractFactor {
    TokenTupel literal;

    public FactorLiteral(TokenTupel literal) {
        this.literal = literal;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        return null;
    }
}
