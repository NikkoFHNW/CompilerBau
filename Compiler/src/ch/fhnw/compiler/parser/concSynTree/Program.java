package ch.fhnw.compiler.parser.concSynTree;


import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class Program implements IConcSynWrapper {
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
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
