package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepSemicolonCmd implements IConcSynWrapper {
    AbstractCmd cmd;
    RepSemicolonCmd repSemicolonCmd;

    public RepSemicolonCmd(AbstractCmd cmd, RepSemicolonCmd repSemicolonCmd) {
        this.cmd = cmd;
        this.repSemicolonCmd = repSemicolonCmd;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
