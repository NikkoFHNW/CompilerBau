package ch.fhnw.compiler.scanner.data;

public class TokenTupel extends Token {

	private Operator op;
	private Type typ;
	private boolean boolVal;
	private Mode m;
	private int intVal;
	private String stringVal;

    public enum ConcreteTyp {
		OPERATOR,TYPE,BOOLEAN,MODE,STRING,INT
	}

	private ConcreteTyp conc;

    public ConcreteTyp getConcType() {
        return conc;
    }

    private TokenTupel(Terminal t) {
        super(t, -1);
        op=null;
        typ=null;
        boolVal=false;
        m=null;
        intVal=0;
        stringVal=null;
    }
	
	public TokenTupel(Terminal t, Operator o){
        this(t);
        conc = ConcreteTyp.OPERATOR;
        op=o;
	}

    public TokenTupel(Terminal t, Type o){
        this(t);
        conc = ConcreteTyp.TYPE;
        typ=o;
	}

    public TokenTupel(Terminal t,  boolean o){
		this(t);
        conc = ConcreteTyp.BOOLEAN;
        boolVal=o;
	}

    public TokenTupel(Terminal t, Mode o){
        this(t);
        conc = ConcreteTyp.MODE;
		m=o;
	}

    public TokenTupel(Terminal t, int o){
        this(t);
        conc = ConcreteTyp.INT;
        intVal=o;
	}

    public TokenTupel(Terminal t,  String o){
        this(t);
        conc = ConcreteTyp.STRING;
		stringVal=o;
	}

    public TokenTupel(Terminal t, Operator o, int lineNr){
        this(t);
        setLineNr(lineNr);
        conc = ConcreteTyp.OPERATOR;
        op=o;
    }

    public TokenTupel(Terminal t, Type o, int lineNr){
        this(t);
        setLineNr(lineNr);
        conc = ConcreteTyp.TYPE;
        typ=o;
    }

    public TokenTupel(Terminal t,  boolean o, int lineNr){
        this(t);
        setLineNr(lineNr);
        conc = ConcreteTyp.BOOLEAN;
        boolVal=o;
    }

    public TokenTupel(Terminal t, Mode o, int lineNr){
        this(t);
        setLineNr(lineNr);
        conc = ConcreteTyp.MODE;
        m=o;
    }

    public TokenTupel(Terminal t, int o, int lineNr){
        this(t);
        setLineNr(lineNr);
        conc = ConcreteTyp.INT;
        intVal=o;
    }

    public TokenTupel(Terminal t,  String o, int lineNr){
        this(t);
        setLineNr(lineNr);
        conc = ConcreteTyp.STRING;
        stringVal=o;
    }

    public int getIntVal() {
        return intVal;
    }

    public boolean getBoolVal() {
        return boolVal;
    }

    public Operator getOp() {
        return op;
    }
    
    public Mode getMode(){
    	return m;
    }

    public Type getType(){
    	return typ;
    }

    public String getStringVal() {
        return stringVal;
    }


    public String toString(){
		
		String res;
        switch(conc){
            case BOOLEAN: res = Boolean.toString(boolVal);
                break;
            case TYPE: res = typ.toString();
                break;
            case OPERATOR: res = op.toString();
                break;
            case MODE: res = m.toString();
                break;
            case INT: res = Integer.toString(intVal);
                break;
            case STRING: res = stringVal;
                break;
            default: res = null;
                break;
        }
		
		
		return "("+toStringNoLine()+","+res+")"+'['+getLineNr()+']';
	}


}
