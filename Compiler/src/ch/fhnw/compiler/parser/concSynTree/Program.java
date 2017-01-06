package ch.fhnw.compiler.parser.concSynTree;


import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class Program implements IConcSyn.IProgram {
    TokenTupel ident;
    ProgParamList progParamList;
    OptGlobalCpsDecl optGlobalCpsDecl;
    CpsCmd cpsCmd;

    public Program(TokenTupel ident, ProgParamList progParamList, OptGlobalCpsDecl optGlobalCpsDecl, CpsCmd cpsCmd) {
        this.ident = ident;
        this.progParamList = progParamList;
        this.optGlobalCpsDecl = optGlobalCpsDecl;
        this.cpsCmd = cpsCmd;
    }

    @Override
    public IAbs.IProgram toAbstrSyntax() {
        return null;
    }
}
