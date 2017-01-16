package ch.fhnw.compiler.parser.abs;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.RecordStore;
import ch.fhnw.compiler.parser.abs.IAbs.ContextError;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;

public class RecordDecl implements IAbs.IDecl {

	TokenTupel recIdent;
	IRecData recData;
	
	public RecordDecl(TokenTupel ri, IRecData rd) {
		// TODO Auto-generated constructor stub
		super();
		recIdent=ri;
		recData=rd;
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
		
		
		Map<String,Type> fields;
		fields = recData.getCompleteData();
		
		RecordStore recSto = new RecordStore(recIdent.getStringVal(),fields);
		if(!Compiler.getScope().getRecordStoreTable().addRecordStore(recSto)){
			throw new ContextError("Recordtype" + recIdent+"already declared", recIdent.getLineNr());
		}
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

}
