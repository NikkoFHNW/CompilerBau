package ch.fhnw.compiler.parser.concSynTree;


import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class Program implements IConcSyn.IProgram {
    TokenTupel ident;
    ProgParamList progParamList;
    IDecl optGlobalCpsDecl;
    CpsCmd cpsCmd;

    public Program(TokenTupel ident, ProgParamList progParamList, IDecl optGlobalCpsDecl, CpsCmd cpsCmd) {
        this.ident = ident;
        this.progParamList = progParamList;
        this.optGlobalCpsDecl = optGlobalCpsDecl;
        this.cpsCmd = cpsCmd;
    }

    @Override
    public IAbs.IProgram toAbstrSyntax() throws GrammarError {
        return new ch.fhnw.compiler.parser.abs.Program(ident, optGlobalCpsDecl.toAbstrSyntax(), cpsCmd.toAbstrSyntax(), progParamList.toAbstrSyntax());
    }
}
