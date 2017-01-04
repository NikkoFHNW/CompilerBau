package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.abs.ExprDyadic;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class RepTerm1 implements IConcSyn.IRepTerm1 {
    TokenTupel boolOpr;
    Term1 term1;
    RepTerm1 next;

    public RepTerm1(TokenTupel boolOpr, Term1 term1) {
        this.boolOpr = boolOpr;
        this.term1 = term1;
    }

    public void setNext(RepTerm1 next) {
        this.next = next;
    }


    public IAbs toAbstractSynTree(ch.fhnw.compiler.parser.abs.IAbs.IExpr expr) {
        ExprDyadic exprDyadic = new ExprDyadic(boolOpr, expr, (IAbs.IExpr) term1.toAbstrSyntax());
        return null;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) {
        return null;
    }
}
