package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class RepSemicolonCmd implements IConcSynWrapper {
    Token semicolon;
    Cmd cmd;
    RepSemicolonCmd repSemicolonCmd;

    public RepSemicolonCmd(Token semicolon, Cmd cmd, RepSemicolonCmd repSemicolonCmd) {
        this.semicolon = semicolon;
        this.cmd = cmd;
        this.repSemicolonCmd = repSemicolonCmd;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
