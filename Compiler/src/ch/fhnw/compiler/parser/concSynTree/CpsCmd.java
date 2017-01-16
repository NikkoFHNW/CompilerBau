package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.CmdCps;
import ch.fhnw.compiler.parser.abs.IAbs;

public class CpsCmd implements IConcSyn.ICmd {
    AbstractCmd cmd;
    CpsCmd next;

    public CpsCmd(AbstractCmd cmd) {
        this.cmd = cmd;
    }

    public void setNext(CpsCmd next) {
        if (this.next == null)
            this.next = next;
        else
            this.next.setNext(next);
    }

    @Override
    public IAbs.ICmd toAbstrSyntax() throws GrammarError {
        if (next != null) {
            return new CmdCps(cmd.toAbstrSyntax(), (CmdCps) next.toAbstrSyntax());
        }

        return new CmdCps(cmd.toAbstrSyntax(), null);
    }

}
