package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn.IMonadicOpr;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class MonadicOpr implements IMonadicOpr{
    Terminal opr;

    public MonadicOpr(Terminal opr) {
        this.opr = opr;
    }

    @Override
    public Token toAbstrSyntax() {
        return null;
    }
}
