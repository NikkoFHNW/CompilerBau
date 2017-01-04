package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsCmd implements IConcSyn.ICmd {
    AbstractCmd cmd;
    CpsCmd next;

    public CpsCmd(AbstractCmd cmd) {
        this.cmd = cmd;
    }

    public void setNext(CpsCmd next) {
        this.next = next;
    }

    @Override
    public IAbs.ICmd toAbstrSyntax(IAbs.ICmd repCmd) {
        return null;
    }
}
