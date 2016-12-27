package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class Factor implements IConcSynWrapper {
    AbstractFactor factor;

    public Factor(AbstractFactor factor) {
        this.factor = factor;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}

abstract class AbstractFactor {}

class FactorLiteral extends AbstractFactor implements IConcSynWrapper {
    Token literal;

    public FactorLiteral(Token literal) {
        this.literal = literal;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}

class FactorIdent extends AbstractFactor implements IConcSynWrapper {
    Token ident;
    OptInitOrExprList optInitOrExprList;

    public FactorIdent(Token ident, OptInitOrExprList optInitOrExprList) {
        this.ident = ident;
        ident.getTerminal()==Terminal.IDENT
        this.optInitOrExprList = optInitOrExprList;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}

class FactorMonad extends AbstractFactor implements IConcSynWrapper {
    MonadicOpr monadicOpr;
    Factor factor;

    public FactorMonad(MonadicOpr monadicOpr, Factor factor) {
        this.monadicOpr = monadicOpr;
        this.factor = factor;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}

class FactorParen extends AbstractFactor implements IConcSynWrapper {
    Token lparen;
    Expr expr;
    Token rparen;

    public FactorParen(Token lparen, Expr expr, Token rparen) {
        this.lparen = lparen;
        this.expr = expr;
        this.rparen = rparen;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}

class FactorRecord extends AbstractFactor implements IConcSynWrapper {
    Token dot;
    Token ident;
    Token dot2;
    Token ident2;

    public FactorRecord(Token dot, Token ident, Token dot2, Token ident2) {
        this.dot = dot;
        this.ident = ident;
        this.dot2 = dot2;
        this.ident2 = ident2;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}