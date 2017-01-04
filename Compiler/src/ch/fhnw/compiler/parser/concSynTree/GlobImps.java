package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class GlobImps implements IConcSyn.IGlobImps {
    GlobImp globImps;
    RepCommaGlobImp repCommaGlobImpl;

    public GlobImps(GlobImp globImp, RepCommaGlobImp repCommaGlobImpl) {
        this.globImps = globImps;
        this.repCommaGlobImpl = repCommaGlobImpl;
    }

    @Override
    public IAbs.IGlobImp toAbstrSyntax() {
        return null;
    }
}
