package ch.fhnw.compiler.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.fhnw.compiler.scanner.data.Type;

public class RecordStore{
	private String recIdent;
	private Map<String, Type> fieldListMap;
	  
	  public RecordStore(String recIdent, Map<String,Type> fields){
		  this(recIdent);
		  
		  fieldListMap = fields;
	
	  }
	  
	  public String getRecIdent() {
		return recIdent;
	}

	public void setRecIdent(String recIdent) {
		this.recIdent = recIdent;
	}

	public RecordStore(String recIdent){
		this.recIdent=recIdent;  
		this.fieldListMap = new TreeMap<String, Type>();
	  }

	  
	  public void addRecField(String s,Type t){
		  fieldListMap.put(s, t);
	  }
	  
	 public Type getFieldType(String s){
		  return fieldListMap.get(s);
	  }
	  
	
	
}
