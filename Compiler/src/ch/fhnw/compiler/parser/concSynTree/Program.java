package ch.fhnw.compiler.parser.concSynTree;


import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class Program implements IConcSyn.IProgram {
    Token program;
    Token ident;
    ProgParamList progParamList;
    OptGlobalCpsDecl optGlobalCpsDecl;
    CpsCmd cpsCmd;
    Token _do;
    Token endProg;

    public Program(Token program, Token ident, ProgParamList progParamList, OptGlobalCpsDecl optGlobalCpsDecl, CpsCmd cpsCmd, Token _do, Token endProg) {
        this.program = program;
        this.ident = ident;
        this.progParamList = progParamList;
        this.optGlobalCpsDecl = optGlobalCpsDecl;
        this.cpsCmd = cpsCmd;
        this._do = _do;
        this.endProg = endProg;
    }


    @Override
    public IAbs.IProgram toAbstrSyntax() {
        return null;
    }
}
