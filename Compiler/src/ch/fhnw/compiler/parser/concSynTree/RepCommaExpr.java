package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaExpr implements IConcSynWrapper{
    Expr expr;
    RepCommaExpr next;

    public RepCommaExpr(Expr expr) {
        this.expr = expr;
    }

    public void setNext(RepCommaExpr next) {
        this.next = next;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
