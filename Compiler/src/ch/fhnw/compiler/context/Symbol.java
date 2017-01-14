package ch.fhnw.compiler.context;

import ch.fhnw.compiler.scanner.data.Type;

public abstract class Symbol {
    private String ident;
    private Type type;
    
    public final String getIdent() {
        return ident;
    }
    
    public final Type getType() {
        return type;
    }
    
    protected Symbol(final String ident, final Type type) {
        this.ident = ident;
        this.type = type;
    }
}
