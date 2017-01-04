package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class GlobInits implements IConcSyn.IGlobInits {
    Idents idents;

    public GlobInits(Idents idents) {
        this.idents = idents;
    }


    @Override
    public IAbs.IGlobInit toAbstrSyntax() {
        return null;
    }
}
