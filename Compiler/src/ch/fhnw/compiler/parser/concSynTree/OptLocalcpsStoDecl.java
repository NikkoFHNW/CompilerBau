package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.CpsStoDecl;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.Token;

public class OptLocalcpsStoDecl implements IConcSyn.ICpsDecl {
    Token local;
    ch.fhnw.compiler.parser.concSynTree.CpsStoDecl cpsStoDecl;

    public OptLocalcpsStoDecl(Token local, ch.fhnw.compiler.parser.concSynTree.CpsStoDecl cpsStoDecl) {
        this.local = local;
        this.cpsStoDecl = cpsStoDecl;
    }


    @Override
    public IAbs.ICpsDecl toAbstrSyntax() {
        return new ch.fhnw.compiler.parser.abs.OptLocalcpsStoDecl(cpsStoDecl.toAbstrSyntax());
    }
}
