package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class OptLocalcpsStoDecl implements IConcSynWrapper {
    Token local;
    CpsStoDecl cpsStoDecl;

    public OptLocalcpsStoDecl(Token local, CpsStoDecl cpsStoDecl) {
        this.local = local;
        this.cpsStoDecl = cpsStoDecl;
    }

    @Override
    public IAbstractSynTree toAbstractSynTree() {
        return null;
    }
}
