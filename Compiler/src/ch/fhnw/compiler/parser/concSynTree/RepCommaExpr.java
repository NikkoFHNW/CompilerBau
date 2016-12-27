package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class RepCommaExpr implements IConcSynWrapper{
    Token comma;
    Expr expr;
    RepCommaExpr repCommaExpr;

    public RepCommaExpr(Token comma, Expr expr, RepCommaExpr repCommaExpr) {
        this.comma = comma;
        this.expr = expr;
        this.repCommaExpr = repCommaExpr;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
