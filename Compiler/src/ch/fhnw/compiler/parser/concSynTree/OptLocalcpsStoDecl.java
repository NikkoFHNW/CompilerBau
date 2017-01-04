package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptLocalcpsStoDecl implements IConcSyn.ICpsDecl {
    Token local;
    CpsStoDecl cpsStoDecl;

    public OptLocalcpsStoDecl(Token local, CpsStoDecl cpsStoDecl) {
        this.local = local;
        this.cpsStoDecl = cpsStoDecl;
    }


    @Override
    public IAbs.ICpsDecl toAbstrSyntax() {
        return null;
    }
}
