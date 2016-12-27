package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaGlobImpl implements IConcSynWrapper{
    Token comma;
    GlobImp globImp;
    RepCommaGlobImpl repCommaGlob;

    public RepCommaGlobImpl(Token comma, GlobImp globImp, RepCommaGlobImpl repCommaGlob) {
        this.comma = comma;
        this.globImp = globImp;
        this.repCommaGlob = repCommaGlob;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
