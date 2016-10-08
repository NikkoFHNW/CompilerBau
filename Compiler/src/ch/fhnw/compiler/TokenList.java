package ch.fhnw.compiler;

public class TokenList implements ITokenList{

	


	@Override
	public void add(Token token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Token nextToken() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	public static class Literals extends Token{
		private final int value;

		Literals(Terminals t) {
			super(Terminals.LITERAL);
			value=0;
		}
		
		Literals(Terminals t, int val){
			super(Terminals.LITERAL);
			value=val;
		}
		
		int getValue(){
			return value;
		}
		
		public String toString(){
			return "("+super.toString()+","+value+")";
		}
		
	}
	
	public static class AddOpr extends Token{
		private final Operators o;

		AddOpr(Terminals t) {
			super(Terminals.ADDOPR);
			this.o=null;
			// TODO Auto-generated constructor stub
		}
		
		AddOpr(Terminals t, Operators o){
			super(Terminals.ADDOPR);
			this.o=o;
		}
		
		Operators getOperator(){
			return o;
		}
		
		public String toString(){
			return "("+super.toString()+","+o.toString()+")";
		}
		
	}

	public static class Ident extends Token{
		private final String ident;
		
		Ident(Terminals t,String ident){
			super(Terminals.IDENT);
			this.ident=ident;
		}
		
		String getIdent(){
			return ident;
		}
		
		public String toString(){
			return "("+super.toString()+","+ident+")";
		}
		
	}
	
	
	public static class RelOpr extends Token{
		private final Operators o;
		
		RelOpr( Operators o){
			super(Terminals.RELOPR);
			this.o=o;
		}
		
		
		Operators getOperator(){
			return o;
		}
		
		public String toString(){
			return "("+super.toString()+","+o.toString()+")";
		}
		
		
	}
	
	public static class MultOpr extends Token{
		private final Operators o;

		MultOpr(Terminals t) {
			super(Terminals.MULTOPR);
			this.o=null;
			// TODO Auto-generated constructor stub
		}
		
		MultOpr(Terminals t, Operators o){
			super(Terminals.MULTOPR);
			this.o=o;
		}
		
		
		Operators getOperator(){
			return o;
		}
		
		public String toString(){
			return "("+super.toString()+","+o.toString()+")";
		}
		
		
	}
	
	
	
}
