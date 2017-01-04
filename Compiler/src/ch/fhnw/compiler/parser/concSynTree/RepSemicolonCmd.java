package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepSemicolonCmd implements IConcSyn.ICmd {
    AbstractCmd cmd;
    RepSemicolonCmd repSemicolonCmd;

    public RepSemicolonCmd(AbstractCmd cmd, RepSemicolonCmd repSemicolonCmd) {
        this.cmd = cmd;
        this.repSemicolonCmd = repSemicolonCmd;
    }


    @Override
    public IAbs.ICmd toAbstrSyntax(IAbs.ICmd repCmd) {
        return null;
    }
}
