package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;

import java.util.List;

public class ExprList implements IConcSyn.IExprList {
    OptExprRep optExprRep;

    public ExprList(OptExprRep optExprRep) {
        this.optExprRep = optExprRep;
    }


    @Override
    public List<IAbs.IExpr> toAbstrSyntax() throws GrammarError {
        return optExprRep.toAbstrSyntax();
    }
}
