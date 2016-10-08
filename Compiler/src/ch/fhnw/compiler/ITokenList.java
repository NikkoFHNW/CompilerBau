package ch.fhnw.compiler;

public interface ITokenList {

	void add(Token token);
	void reset();
	Token nextToken();
	String toString();
}
