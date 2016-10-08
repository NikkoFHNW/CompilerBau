package ch.fhnw.compiler;

public class Token {
	private final Terminals terminal;
	
	Token(Terminals t){
		terminal=t;
	}
	
	Terminals getTerminal(){
		return terminal;
	}
	
	public String toString(){
		return terminal.toString();
	}
	
	
	
	
	



	
	
	
	

	
	

}
