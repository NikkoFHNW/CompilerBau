package ch.fhnw.compiler;

public class TokenTupel extends Token {

	private Operators op;
	private Types typ;
	private boolean bVal;
	private Modes m;
	private int iVal;
	private String sVal;
	private ConcreteTyp conc;
	
	
	TokenTupel(Terminals t,Operators o){
		super(t);
		op=o;
		typ=null;
		bVal=false;
		m=null;
		iVal=0;
		sVal=null;
		conc = ConcreteTyp.OPERATOR;
	}
	
	TokenTupel(Terminals t,Types o){
		super(t);
		op=null;
		typ=o;
		bVal=false;
		m=null;
		iVal=0;
		sVal=null;
		conc = ConcreteTyp.TYPE;
	}
	
	TokenTupel(Terminals t,boolean o){
		super(t);
		op=null;
		typ=null;
		bVal=o;
		m=null;
		iVal=0;
		sVal=null;
		conc = ConcreteTyp.BOOLEAN;
	}
	
	TokenTupel(Terminals t,Modes o){
		super(t);
		op=null;
		typ=null;
		bVal=false;
		m=o;
		iVal=0;
		sVal=null;
		conc = ConcreteTyp.MODE;
	}
	
	TokenTupel(Terminals t,int o){
		super(t);
		op=null;
		typ=null;
		bVal=false;
		m=null;
		iVal=o;
		sVal=null;
		conc = ConcreteTyp.INT;
	}
	
	TokenTupel(Terminals t,String o){
		super(t);
		op=null;
		typ=null;
		bVal=false;
		m=null;
		iVal=0;
		sVal=o;
		conc = ConcreteTyp.STRING;
	}
	
	public String toString(){
		
		String res;
		switch(conc){
		case BOOLEAN: res = Boolean.toString(bVal);
			break;
		case TYPE: res = typ.toString();
			break;
		case OPERATOR: res = op.toString();
		break;
		case MODE: res = m.toString();
		break;
		case INT: res = Integer.toString(iVal);
		break;
		case STRING: res = sVal;
		break;
		default: res = null;
		break;
		}
		
		
		return "("+super.toString()+","+res+")";
	}

}
