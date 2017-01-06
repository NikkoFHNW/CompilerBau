package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaGlobImpl implements IConcSyn{
    Token comma;
    GlobImp globImp;
    RepCommaGlobImp repCommaGlob;

    public RepCommaGlobImpl(Token comma, GlobImp globImp, RepCommaGlobImp repCommaGlob) {
        this.comma = comma;
        this.globImp = globImp;
        this.repCommaGlob = repCommaGlob;
    }
}
