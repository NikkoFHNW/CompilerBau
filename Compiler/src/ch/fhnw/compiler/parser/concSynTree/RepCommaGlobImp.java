package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaGlobImp implements IConcSynWrapper{
    GlobImp globImp;
    RepCommaGlobImp repCommaGlob;

    public RepCommaGlobImp(GlobImp globImp, RepCommaGlobImp repCommaGlob) {
        this.globImp = globImp;
        this.repCommaGlob = repCommaGlob;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
