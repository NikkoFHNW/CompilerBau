package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepCommaParam implements IConcSyn.IParamList {
    Param param;
    RepCommaParam repCommaParam;

    public RepCommaParam(Param param, RepCommaParam repCommaParam) {
        this.param = param;
        this.repCommaParam = repCommaParam;
    }

    @Override
    public IAbs.IParam toAbstrSyntax() {
        return null;
    }
}
