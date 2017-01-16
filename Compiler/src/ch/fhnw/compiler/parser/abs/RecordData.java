package ch.fhnw.compiler.parser.abs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.concSynTree.OptChangeMode;
import ch.fhnw.compiler.parser.concSynTree.RepRecordData;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class RecordData implements IAbs.IRecData {
	
    TokenTupel ident;
    TokenTupel type;
    
//Versuch mit rekursiven recorddata
    IRecData repRecData;
    TokenTupel cm;
    
    
	public RecordData(TokenTupel ident ,TokenTupel type, TokenTupel cm, IRecData rd) {
		// TODO Auto-generated constructor stub
		this.ident=ident;
		this.type=type;
		this.cm=cm;
		this.repRecData=rd;

	}
	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void checkDeclaration() throws ContextError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int check(int locals) throws ContextError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<String,Type> getCompleteData() {
		Map<String,Type> res =  new TreeMap<String, Type>();
		this.getData(res);
		return res;
	}

	@Override
	public void getData(Map<String,Type> res) {
		// TODO Auto-generated method stub
		res.put(ident.getStringVal(), type.getType());
		if(repRecData!=null
				)this.repRecData.getData(res);
	}

}
