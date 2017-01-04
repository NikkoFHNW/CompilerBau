package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptGlobalglobImps implements IConcSyn.IOptGlobalglobImps {
    Token global;
    GlobImps globImps;

    public OptGlobalglobImps(Token global, GlobImps globImps) {
        this.global = global;
        this.globImps = globImps;
    }

    @Override
    public IAbs.IGlobImp toAbstrSyntax() {
        return null;
    }
}
