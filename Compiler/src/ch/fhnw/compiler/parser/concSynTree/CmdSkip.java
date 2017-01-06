package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CmdSkip extends AbstractCmd {
    public CmdSkip() {
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.CmdSkip();
    }
}