package ch.fhnw.compiler.scanner;

class LexicalError extends RuntimeException{

	 LexicalError(String s) {
		super(s);
	}
}
