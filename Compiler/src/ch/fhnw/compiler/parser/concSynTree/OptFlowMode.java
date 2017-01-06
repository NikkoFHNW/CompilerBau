package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class OptFlowMode implements IConcSyn.IOptFlowMode {
    TokenTupel flowMode;

    public OptFlowMode(TokenTupel flowMode) {
        this.flowMode = flowMode;
    }

    @Override
    public TokenTupel toAbstrSyntax() {
        return flowMode;
    }
}
