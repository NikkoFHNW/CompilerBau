package ch.fhnw.compiler.parser.concSynTree;


import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class Program implements IConcSynWrapper {
    Terminal program;
    Terminal ident;
    ProgParamList progParamList;
    OptGlobalCpsDecl optGlobalCpsDecl;
    CpsCmd cpsCmd;
    Terminal _do;
    Terminal endProg;


    public Program(Terminal program, Terminal ident, ProgParamList progParamList, OptGlobalCpsDecl optGlobalCpsDecl, CpsCmd cpsCmd, Terminal _do, Terminal endProg) {
        this.program = program;
        this.ident = ident;
        this.progParamList = progParamList;
        this.optGlobalCpsDecl = optGlobalCpsDecl;
        this.cpsCmd = cpsCmd;
        this._do = _do;
        this.endProg = endProg;
    }



}
