package ch.fhnw.compiler.scanner.data;

import java.util.ArrayList;

public interface ITokenList {

	void add(Token token);
	void add(ITokenList tokenList);
	void reset();
	Token nextToken();
	String toString();
	ArrayList<Token> getList();
}
