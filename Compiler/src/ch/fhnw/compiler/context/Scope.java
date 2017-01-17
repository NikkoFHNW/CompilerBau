package ch.fhnw.compiler.context;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Type;

public class Scope {
    int startPos;
    private StoreTable storeTable;
    private RecordStoreTable recStoTable;

    private Scope parent;

	public Scope() {
        this(new StoreTable(),new RecordStoreTable(), 0);
    }
    
    public Scope( StoreTable storeTable, RecordStoreTable recst, int startPos) {
        this.storeTable = storeTable;
        this.recStoTable=recst;
    }
    
    public RecordStoreTable getRecordStoreTable(){
    	return recStoTable;
    }
    
    public RecordStore getRecordStore(String s){
    	return this.recStoTable.getRecordStore(s);
    }
    
    public void addRecordStore(RecordStore rs){
    	this.recStoTable.addRecordStore(rs);
    }
    
    public StoreTable getStoreTable() {
        return storeTable;
    }

    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public Type getType(String ident) {
        return storeTable.getType(ident);
    }
    
    public boolean addStore(Store store){

        store.setRelAdress(this.storeTable.getCount());
        store.setAddress(this.startPos+storeTable.getCount());
    	return storeTable.addStore(store);
    }
    
    public boolean addStore(final StoreTable stores) {
        for (Store symbol : stores.getTable().values()) {
            if (!storeTable.addStore(symbol)) {
                return false;
            }
        }
        return true;
    }

    public void returnToParentScope() {
        Compiler.setScope(parent);
    }

    public int getVarCount() {
        return storeTable.getCount();
    }

    public int getStartPos() {
        return startPos;
    }
}
