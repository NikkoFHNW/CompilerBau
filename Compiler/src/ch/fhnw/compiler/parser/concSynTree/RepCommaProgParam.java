package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaProgParam implements IConcSyn.IParamList {
    ProgramParam programParam;
    RepCommaProgParam repCommaProgParam;

    public RepCommaProgParam(ProgramParam programParam, RepCommaProgParam repCommaProgParam) {
        this.programParam = programParam;
        this.repCommaProgParam = repCommaProgParam;
    }


    @Override
    public IAbs.IParam toAbstrSyntax() {
        return null;
    }
}
