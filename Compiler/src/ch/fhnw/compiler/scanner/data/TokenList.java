package ch.fhnw.compiler.scanner.data;

import java.util.ArrayList;

public class TokenList implements ITokenList{

	private ArrayList<Token> list = new ArrayList<Token>();
	private int index=0;
	


	@Override
	public void add(Token token) {
		list.add(token);
		
	}

	@Override
	public void reset() {
		index=0;
	}

	@Override
	public Token nextToken() {
		return list.get(index++);
	}
	


	
	
	
}
