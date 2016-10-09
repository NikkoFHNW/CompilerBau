package ch.fhnw.compiler.scanner.data;

public class Token {
	private final Terminal terminal;
	
	public Token(Terminal t){
		terminal=t;
	}
	
	public Terminal getTerminal(){
		return terminal;
	}
	
	public String toString(){
		return terminal.toString();
	}
	
	
	
	
	



	
	
	
	

	
	

}
