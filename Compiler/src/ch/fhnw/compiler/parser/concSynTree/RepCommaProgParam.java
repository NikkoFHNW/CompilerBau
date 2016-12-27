package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaProgParam implements IConcSynWrapper{
    Token comma;
    ProgramParam programParam;
    RepCommaProgParam repCommaProgParam;

    public RepCommaProgParam(Token comma, ProgramParam programParam, RepCommaProgParam repCommaProgParam) {
        this.comma = comma;
        this.programParam = programParam;
        this.repCommaProgParam = repCommaProgParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
