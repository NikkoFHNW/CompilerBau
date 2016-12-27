package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class OptGlobalglobImps implements IConcSynWrapper {
    Token global;
    GlobImps globImps;

    public OptGlobalglobImps(Token global, GlobImps globImps) {
        this.global = global;
        this.globImps = globImps;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
