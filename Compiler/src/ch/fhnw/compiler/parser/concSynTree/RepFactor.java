package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class RepFactor implements IConcSyn.IRepFactor {
    AbstractFactor factor;
    RepFactor next;

    public RepFactor(AbstractFactor factor) {
        this.factor = factor;
    }

    public void setNext(RepFactor next) {
        this.next = next;
    }


    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) {
        return null;
    }
}
