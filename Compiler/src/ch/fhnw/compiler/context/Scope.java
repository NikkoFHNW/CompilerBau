package ch.fhnw.compiler.context;

import ch.fhnw.compiler.scanner.data.Type;

public class Scope {
    private StoreTable storeTable;
    private RecordStoreTable recStoTable;

	public Scope() {
        this(new StoreTable(),new RecordStoreTable());
    }
    
    public Scope( StoreTable storeTable, RecordStoreTable recst) {
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
    
    public Type getType( String ident) {
        return storeTable.getType(ident);
    }
    
    public boolean addStore(Store store){
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
}
