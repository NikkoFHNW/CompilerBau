package ch.fhnw.compiler.context;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;
public class Store extends Symbol {
    private boolean writeable;
    private boolean initialized;
    private boolean isConst;
    private int address;
    private boolean relative = false; //wof�r relative? => Frag big L, 2 verschiedene calls auf VM
    private boolean reference = false;
    private String recType;
    private int relAdress;
    

	public Store(
            final String ident, 
            final Type type, 
            final boolean isConst) {
        super(ident, type);
        this.writeable = true;
        this.initialized = false;
        this.isConst = isConst;
    }
	
    public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}
    
    public boolean isConst() {
        return isConst;
    }

    public boolean isWriteable() {
        return writeable;
    }

    public boolean isInitialized() {
        return initialized;
    }
    
    public void initialize() { 
        initialized = true;
        if (isConst) {
            writeable = false;
        }
    }

    public void setRelAdress(int relAdress) {
        this.relAdress = relAdress;
    }

    public int getRelAdress() {
        return relAdress;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(final int address) {
        this.address = address;
    }

    public void setRelative(final boolean relative) {
        this.relative = relative;
    }
    
    public void setReference(final boolean reference) {
        this.reference = reference;
    }
    
    public boolean getReference(){
    	return reference;
    }

    public int codeLoad(final int loc) throws ICodeArray.CodeTooSmallError {
        int loc1 = codeRef(loc);
        Compiler.getCodeArray().put(loc1++, new IInstructions.Deref());
        return loc1;
    }
    
    public int codeRef(final int loc) throws ICodeArray.CodeTooSmallError {
        int loc1 = loc;
        if (relative) {
            Compiler.getCodeArray().put(loc1++, new IInstructions.LoadAddrRel(relAdress));
        } else {
            Compiler.getCodeArray().put(loc1++, new IInstructions.LoadImInt(address));
        }

        if (reference) {
            Compiler.getCodeArray().put(loc1++, new IInstructions.Deref());
        }

        return loc1;
    }
    
    public Store clone() {
        Store store = new Store(
                this.getIdent(),
                this.getType(),
                this.isConst);
        store.address = this.address;
        store.initialized = this.initialized;
        store.writeable = this.writeable;
        return store;
    }}
    
