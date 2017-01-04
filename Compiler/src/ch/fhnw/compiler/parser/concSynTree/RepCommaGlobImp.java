package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaGlobImp implements IConcSyn.IRepCommaGlobImp {
    GlobImp globImp;
    RepCommaGlobImp repCommaGlob;

    public RepCommaGlobImp(GlobImp globImp, RepCommaGlobImp repCommaGlob) {
        this.globImp = globImp;
        this.repCommaGlob = repCommaGlob;
    }

    @Override
    public IAbs.IGlobImp toAbstrSyntax() {
        return null;
    }
}
