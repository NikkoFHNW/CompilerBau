package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class ExprList implements IConcSyn.IExprList {
    OptExprRep optExprRep;

    public ExprList(OptExprRep optExprRep) {
        this.optExprRep = optExprRep;
    }


    @Override
    public IAbs.IExprList toAbstrSyntax() {
        return optExprRep.toAbstrSyntax();
    }
}
