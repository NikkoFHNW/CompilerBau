package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaParam implements IConcSynWrapper {
    Param param;
    RepCommaParam repCommaParam;

    public RepCommaParam(Param param, RepCommaParam repCommaParam) {
        this.param = param;
        this.repCommaParam = repCommaParam;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
