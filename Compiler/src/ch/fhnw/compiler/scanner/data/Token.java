package ch.fhnw.compiler.scanner.data;

public class Token {
	private final Terminal terminal;
	private int lineNr = -1;

	
	public Token(Terminal t){
		terminal=t;
	}

	public Token(Terminal t, int lineNr){
		terminal=t;
		this.lineNr = lineNr;
	}

	public int getLineNr() {
		return lineNr;
	}

	public Token setLineNr(int lineNr) {
		this.lineNr = lineNr;
        return this;
	}

	public Terminal getTerminal(){
		return terminal;
	}
	
	public String toString(){
		return terminal.toString()+'['+lineNr+']';
	}

    public String toStringNoLine(){
        return terminal.toString();

    }
	
	
	
	
	
	
	



	
	
	
	

	
	

}
