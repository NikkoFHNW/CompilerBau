package ch.fhnw.compiler.context;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

public abstract class Routine extends Symbol {
    
    private Scope scope;
    private RoutineTypes routineType;
    private List<Parameter> paramList = new ArrayList<Parameter>();
    private List<GlobImp> globImpList = new ArrayList<GlobImp>();
    private List<Integer> calls = new ArrayList<Integer>();
    private int address;
    
    protected Routine(
            final String ident, 
            final Type type, 
            final RoutineTypes routineType) {
        super(ident, type);
        this.routineType = routineType;
        this.scope = new Scope();
    }
    
    public final void setAddress(final int address) {
        this.address = address;
    }
    
    public final void addCall(final int loc) {
        calls.add(loc);
    }
    
    public final void codeCalls() throws ICodeArray.CodeTooSmallError {
        for (int loc : calls) {
            Compiler.getCodeArray().put(loc, new IInstructions.Call(address));
        }
    }
    
    public final Scope getScope() {
        return scope;
    }
    
    public final RoutineTypes getRoutineType() {
        return routineType;
    }
    
    public final List<Parameter> getParamList() {
        return paramList;
    }
    
    public final int getInOutCopyCount() {
        int count = 0;
        for (Parameter param : paramList) {
            if (param.getMechMode() == Mode.COPY
                    && param.getFlowMode() != Mode.IN) {
                count++;
            }
        }
        return count;
    }
    
    public final List<GlobImp> getGlobImpList() {
        return globImpList;
    }
    
    public final void addParam(final Parameter param) {
        paramList.add(param);
    }
    
    public final void addGlobImp(final GlobImp globImp) {
        globImpList.add(globImp);
    }
    
    public enum RoutineTypes {
        FUNCTION,
        PROCEDURE
    }
    }
