package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.Compiler;
import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions.Store;

public class StoDecl implements IAbs.IStoDecl {
	
//	ChangeMode cm;
	
	TokenTupel cm;
	IAbs.IParam typedId;
	
	public StoDecl(TokenTupel cm, IAbs.IParam typedId){
		this.cm=cm;
		this.typedId=typedId;
	}

	
	ch.fhnw.compiler.context.Store getStore(){
		TypedIdent temp = (TypedIdent) typedId;
		boolean isC = false;
		if(cm!=null)cm.getMode().equals(Mode.CONST);
		return new ch.fhnw.compiler.context.Store(temp.getIdent().toString(), temp.getType().getType(),isC );
	}
	
	@Override
	public void checkDeclaration() throws ContextError {
		// TODO Auto-generated method stub
		TypedIdent temp = (TypedIdent) typedId;
		ch.fhnw.compiler.context.Store sto = getStore();
		if(!Compiler.getScope().addStore(sto)){
			throw new ContextError("already declared " + temp.getIdent().toString(), typedId.getLine());
		}
//        if (temp.getType().getType() == Type.BOOL) {
//            sto.setAddress(Compiler.getVM().BoolInitHeapCell());
//            sto.setRelative(false);
//        } else {
//            sto.setAddress(Compiler.getVM().IntInitHeapCell());
//            sto.setRelative(false);
//        }
		
		
	}

	@Override
	public int check(int locals) throws ContextError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
//		int loc1 = loc;
		Compiler.getCodeArray().put(loc++, new IInstructions.AllocBlock(1));
		return loc;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return typedId.toString();
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TokenTupel getType() {
		// TODO Auto-generated method stub
		TypedIdent typedIdent = (TypedIdent) typedId;
		return typedIdent.getType();
	}

	@Override
	public String getIdent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store check() throws ContextError {
		// TODO Auto-generated method stub
		return null;
	}
}
