package ch.fhnw.compiler.context;

import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.Type;

public class Parameter {
    private  Mode flowMode;
    private  Mode mechMode;
    private  Mode changeMode;
    private  Type type;
    
    
    public Parameter(
             Mode flowMode, 
             Mode mechMode, 
             Mode changeMode,
             Type type) {
        this.flowMode = flowMode;
        this.mechMode = mechMode;
        this.changeMode = changeMode;
        this.type = type;
    }

    public Mode getFlowMode() {
        return flowMode;
    }

    public Mode getMechMode() {
        return mechMode;
    }

    public Mode getChangeMode() {
        return changeMode;
    }
    
    public Type getType() {
        return type;
    }
}