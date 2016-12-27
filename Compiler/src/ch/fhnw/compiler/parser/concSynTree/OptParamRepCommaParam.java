package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class OptParamRepCommaParam implements IConcSynWrapper{
    Param param;
    RepCommaParam repCommaParam;

    public OptParamRepCommaParam(Param param, RepCommaParam repCommaParam) {
        this.param = param;
        this.repCommaParam = repCommaParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
