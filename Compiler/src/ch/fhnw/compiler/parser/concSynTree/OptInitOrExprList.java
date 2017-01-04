package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptInitOrExprList implements IConcSyn.IExprList {

    Token init;
    ExprList exprList;

    @Override
    public IAbs.IExprList toAbstrSyntax() {
        return null;
    }
}
