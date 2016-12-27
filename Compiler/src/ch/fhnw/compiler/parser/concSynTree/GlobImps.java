package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class GlobImps implements IConcSynWrapper {
    GlobImp globImps;
    RepCommaGlobImpl repCommaGlobImpl;

    public GlobImps(GlobImp globImps, RepCommaGlobImpl repCommaGlobImpl) {
        this.globImps = globImps;
        this.repCommaGlobImpl = repCommaGlobImpl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
