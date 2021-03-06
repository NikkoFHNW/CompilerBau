package ch.fhnw.compiler.context;

import java.util.Map;
import java.util.TreeMap;

public class RecordStoreTable {
	private Map<String, RecordStore> recordMap;
	
	public RecordStoreTable() {
		recordMap=new TreeMap<>();
	}
	
	public Map<String,RecordStore> getTable(){
		return recordMap;
	}
	
	public boolean addRecordStore(RecordStore rs){
		if(recordMap.containsKey(rs.getRecIdent()))
			return false;

		recordMap.put(rs.getRecIdent().toString(), rs);
		return true;
		
	}
	
	public RecordStore getRecordStore(String s){
		return recordMap.get(s);
	}

}
