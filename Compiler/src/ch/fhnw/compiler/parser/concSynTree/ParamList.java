package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class ParamList implements IConcSynWrapper{
    Token lparen;
    OptParamRepCommaParam optParamRepCommaParam;

    public ParamList(Token lparen, OptParamRepCommaParam optParamRepCommaParam) {
        this.lparen = lparen;
        this.optParamRepCommaParam = optParamRepCommaParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
