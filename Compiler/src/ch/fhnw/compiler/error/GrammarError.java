package ch.fhnw.compiler.error;

import ch.fhnw.compiler.scanner.data.Terminal;

public class GrammarError extends Exception{

	/**
	 * 
	 */
//	private static final long serialVersionUID = -2309179205864805296L;
	
	private final int lineNumber;
	
	private final String message;
	
	private final Terminal actual;
	private final Terminal expected;
	
	public GrammarError(String message, int lineNumber){
		super();
		actual=null;
		expected=null;
		this.lineNumber = lineNumber;
		this.message = message;
	}
	
	
	public GrammarError(Terminal actual, Terminal expected){
		super();
		message = "";
		lineNumber=0;
		this.actual=actual;
		this.expected = expected;
		
	}
	@Override
	public String getMessage(){
		if(!message.equals(""))
		return message + " at line " + lineNumber + ".";
		else
		return "expected: " + expected.toString() + ", actual: " + actual.toString();
	}

}