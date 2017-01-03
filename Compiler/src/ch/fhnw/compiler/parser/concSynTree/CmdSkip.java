package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;

public class CmdSkip extends AbstractCmd {
    public CmdSkip() {
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}