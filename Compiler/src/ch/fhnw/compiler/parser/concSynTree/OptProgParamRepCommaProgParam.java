package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class OptProgParamRepCommaProgParam implements IConcSynWrapper {
    ProgramParam programParam;
    RepCommaProgParam repCommaProgParam;

    public OptProgParamRepCommaProgParam(ProgramParam programParam, RepCommaProgParam repCommaProgParam) {
        this.programParam = programParam;
        this.repCommaProgParam = repCommaProgParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
