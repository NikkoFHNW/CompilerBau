package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CpsCmd implements IConcSynWrapper {
    Cmd cmd;
    RepSemicolonCmd repSemicolonCmd;

    public CpsCmd(Cmd cmd, RepSemicolonCmd repSemicolonCmd) {
        this.cmd = cmd;
        this.repSemicolonCmd = repSemicolonCmd;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
