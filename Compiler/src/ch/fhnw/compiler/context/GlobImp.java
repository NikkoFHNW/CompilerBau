package ch.fhnw.compiler.context;

import ch.fhnw.compiler.scanner.data.Mode;

public class GlobImp {

    private final Mode flowMode;
    private final Mode changeMode;
    private final String ident;
    
    public Mode getFlowMode() {
        return flowMode;
    }

    public Mode getChangeMode() {
        return changeMode;
    }

    public String getIdent() {
        return ident;
    }

    public GlobImp(
            final Mode flowMode,
            final Mode changeMode,
            final String ident) {
        this.flowMode = flowMode;
        this.changeMode = changeMode;
        this.ident = ident;
    } 
}
