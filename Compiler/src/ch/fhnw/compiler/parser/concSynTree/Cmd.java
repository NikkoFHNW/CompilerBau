package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class Cmd implements IConcSynWrapper {
    AbstractCmd cmd;

    public Cmd(AbstractCmd cmd) {
        this.cmd = cmd;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
