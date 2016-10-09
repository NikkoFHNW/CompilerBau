package ch.fhnw.compiler.scanner.data;

public class TokenTupel extends Token {

	private Operator op;
	private Type typ;
	private boolean bVal;
	private Mode m;
	private int iVal;
	private String sVal;

    private enum ConcreteTyp {
		OPERATOR,TYPE,BOOLEAN,MODE,STRING,INT
	}

	private ConcreteTyp conc;

    private TokenTupel(Terminal t) {
        super(t);
        op=null;
        typ=null;
        bVal=false;
        m=null;
        iVal=0;
        sVal=null;
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

    public TokenTupel(Terminal t, boolean o){
		this(t);
        conc = ConcreteTyp.BOOLEAN;
        bVal=o;
	}

    public TokenTupel(Terminal t, Mode o){
        this(t);
        conc = ConcreteTyp.MODE;
		m=o;
	}

    public TokenTupel(Terminal t, int o){
        this(t);
        conc = ConcreteTyp.INT;
		iVal=o;
	}

    public TokenTupel(Terminal t, String o){
        this(t);
        conc = ConcreteTyp.STRING;
		sVal=o;
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
