package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptProgParamRepCommaProgParam implements IConcSyn.IOptParamRepCommaParam {
    ProgramParam programParam;
    RepCommaProgParam repCommaProgParam;

    public OptProgParamRepCommaProgParam(ProgramParam programParam, RepCommaProgParam repCommaProgParam) {
        this.programParam = programParam;
        this.repCommaProgParam = repCommaProgParam;
    }


    @Override
    public IAbs.IParam toAbstrSyntax() {
        return null;
    }
}
