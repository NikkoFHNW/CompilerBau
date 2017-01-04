package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptGlobInits implements IConcSyn.IOptGlobInits {
    GlobInits globInits;

    public OptGlobInits(GlobInits globInits) {
        this.globInits = globInits;
    }


    @Override
    public IAbs.IGlobInit toAbstrSyntax() {
        return null;
    }
}
