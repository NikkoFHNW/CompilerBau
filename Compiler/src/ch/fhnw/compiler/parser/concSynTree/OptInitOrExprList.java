package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptInitOrExprList implements IConcSyn.IExprList {
    ExprList exprList;

    public OptInitOrExprList(ExprList exprList) {
        this.exprList = exprList;
    }

    @Override
    public IAbs.IExpr toAbstrSyntax() {
        if (exprList != null) {
            return exprList.toAbstrSyntax();
        } else
            return null;
    }
}
