package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Token;

public class ExprList implements IConcSynWrapper {
    Token lparen;
    OptExprRepCommaExpr optExprRepCommaExpr;
    Token rparen;

    public ExprList(Token lparen, OptExprRepCommaExpr optExprRepCommaExpr, Token rparen) {
        this.lparen = lparen;
        this.optExprRepCommaExpr = optExprRepCommaExpr;
        this.rparen = rparen;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
