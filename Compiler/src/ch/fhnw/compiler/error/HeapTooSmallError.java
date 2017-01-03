package ch.fhnw.compiler.error;

public class HeapTooSmallError extends Exception{

	/**
	 * 
	 */
//	private static final long serialVersionUID = -2309179205864805296L;
	
	private final int lineNumber;
	
	private final String message;
	
	public HeapTooSmallError(String message, int lineNumber){
		super();
		this.lineNumber = lineNumber;
		this.message = message;
	}
	@Override
	public String getMessage(){
		return message + " at line " + lineNumber + ".";
	}

}