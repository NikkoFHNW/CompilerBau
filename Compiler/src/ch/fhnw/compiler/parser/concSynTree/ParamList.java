package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class ParamList implements IConcSyn.IParamList {
    OptParamRepCommaParam optParamRepCommaParam;

    public ParamList( OptParamRepCommaParam optParamRepCommaParam) {
        this.optParamRepCommaParam = optParamRepCommaParam;
    }


    @Override
    public IAbs.IParam toAbstrSyntax() {
        return null;
    }
}
