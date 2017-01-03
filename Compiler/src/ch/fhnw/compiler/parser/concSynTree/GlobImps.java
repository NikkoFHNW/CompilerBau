package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class GlobImps implements IConcSynWrapper {
    GlobImp globImps;
    RepCommaGlobImp repCommaGlobImpl;

    public GlobImps(GlobImp globImp, RepCommaGlobImp repCommaGlobImpl) {
        this.globImps = globImps;
        this.repCommaGlobImpl = repCommaGlobImpl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
