package ch.fhnw.compiler;

public interface ITokenList {

	void add(IToken.Base token);
	void reset();
	IToken.Base nextToken();
	String toString();
}
