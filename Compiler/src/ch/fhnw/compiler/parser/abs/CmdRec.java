package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.context.RecordStore;
import ch.fhnw.compiler.context.Scope;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CmdRec implements IAbs.ICmd {
    TokenTupel recident;
    TokenTupel ident;
    List<TokenTupel> recConstr;

    public CmdRec(TokenTupel recident, TokenTupel ident, List<TokenTupel> recConstr) {
        this.recident = recident;
        this.ident = ident;
        this.recConstr = recConstr;
    }

    @Override
    public void check(boolean canInit) throws ContextError {


    }

    @Override
    public int code(int loc) throws ICodeArray.CodeTooSmallError {
        int loc1 = loc;
        Store store = Compiler.getGlobalStoreTable().getStore(ident.getStringVal());
        RecordStore recordStore = Compiler.getRecordStoreTable().getRecordStore(recident.getStringVal());

        loc1 = store.codeLoad(loc1);
        Compiler.getCodeArray().put(loc1++, new IInstructions.Store());
        return loc1;

    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public int getLine() {
        return recident.getLineNr();
    }

	@Override
	public void check() throws ContextError {
		RecordStore rs=Compiler.getScope().getRecordStoreTable().getRecordStore(recident.getStringVal());
		if(rs==null)
			throw new ContextError("Rectype " + recident+" doesn't exist.", this.ident.getLineNr());
		
		Store sto = new Store(ident.getStringVal(), null, false);
		sto.initialize();
		sto.setRecType(recident.getStringVal());
		if(!Compiler.getScope().getStoreTable().addStore(sto)){
			throw new ContextError("already declared " + ident +".", ident.getLineNr());
		}
		
		List<TokenTupel> recCons = recConstr;
		List<Type> usedTypes = new ArrayList<Type>();
		for(int x =0;x<recCons.size();x++){
			switch(recCons.get(x).getConcType()){
				case BOOLEAN: usedTypes.add(Type.BOOL);
				break;
			case INT: usedTypes.add(Type.INT32);
				break;
			case STRING:
				String tS = recCons.get(x).getStringVal();
				Type t = Compiler.getScope().getStoreTable().getType(tS);
				Scope l = Compiler.getScope();
				Scope g = Compiler.getGlobalScope();
				if(t==null)
					throw new ContextError("no variable called " +tS, ident.getLineNr());
				usedTypes.add(t);
				break;
			default:
				throw
					new ContextError("unsupported type in Recconstr", ident.getLineNr());

			}
		}

		Map<String,Type> fieldList =rs.getFieldListMap();
		if(fieldList.size()!=usedTypes.size())
			throw new ContextError("number of fields used doesn't match the record constructor", ident.getLineNr());

		Collection<Type> expectedTypesC = fieldList.values();
		Type[] expectedTypes = new Type[expectedTypesC.size()];
		expectedTypesC.toArray(expectedTypes);

		Type[] tArr = new Type[expectedTypes.length];
		for (int i = 0; i < expectedTypes.length; i++) {
			tArr[i] = expectedTypes[expectedTypes.length-1-i];
		}

		if(expectedTypesC.size()!=usedTypes.size())
			throw new ContextError("number of fields used doesn't match the record constructor (2)", ident.getLineNr());

		for(int x=0;x<usedTypes.size();x++){
			if(!usedTypes.get(x).equals(tArr[x])){
				throw new ContextError("type missmatch in record constructor"
						+"expected: "+tArr[x]+" actual: " + usedTypes.get(x), ident.getLineNr());
			}
		}

	}
}
