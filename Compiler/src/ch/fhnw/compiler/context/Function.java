package ch.fhnw.compiler.context;

import ch.fhnw.compiler.scanner.data.Type;

public final class Function extends Routine {
    
    public Function(final String ident, final Type type) {
        super(ident, type, RoutineTypes.FUNCTION);
    }
    
}
