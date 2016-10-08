package ch.fhnw.compiler;

public interface ITokenList {

	void add(TokenList.Base token);
	void reset();
	TokenList.Base nextToken();
	String toString();
}
