package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class OptChangeMode implements IConcSyn.IOptChangeMode {
    TokenTupel changeMode;

    public OptChangeMode(TokenTupel changeMode) {
        this.changeMode = changeMode;
    }

    @Override
    public TokenTupel toAbstrSyntax() {
        return changeMode;
    }
}
