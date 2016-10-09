package ch.fhnw.compiler.scanner.data;

public interface ITokenList {

	void add(Token token);
	void reset();
	Token nextToken();
	String toString();
}
