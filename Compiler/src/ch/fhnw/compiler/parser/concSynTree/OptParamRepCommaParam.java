package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class OptParamRepCommaParam implements IConcSyn.IOptParamRepCommaParam {
    Param param;
    RepCommaParam repCommaParam;

    public OptParamRepCommaParam(Param param, RepCommaParam repCommaParam) {
        this.param = param;
        this.repCommaParam = repCommaParam;
    }


    @Override
    public IAbs.IParam toAbstrSyntax() {
        return null;
    }
}
