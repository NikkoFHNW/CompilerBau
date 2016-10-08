package ch.fhnw.compiler;

import java.util.ArrayList;
import java.util.LinkedList;

public class TokenList implements ITokenList{

	private ArrayList<Token> list = new ArrayList<Token>();
	private int index=0;
	


	@Override
	public void add(Token token) {
		// TODO Auto-generated method stub
		list.add(token);
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		index=0;
	}

	@Override
	public Token nextToken() {
		// TODO Auto-generated method stub
		return list.get(index++);
	}
	


	
	
	
}
