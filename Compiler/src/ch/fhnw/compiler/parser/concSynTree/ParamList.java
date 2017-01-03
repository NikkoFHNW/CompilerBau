package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class ParamList implements IConcSynWrapper{
    OptParamRepCommaParam optParamRepCommaParam;

    public ParamList( OptParamRepCommaParam optParamRepCommaParam) {
        this.optParamRepCommaParam = optParamRepCommaParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
