package ch.fhnw.compiler.scanner.data;

import java.util.ArrayList;

public class TokenList implements ITokenList{

	private ArrayList<Token> list = new ArrayList<Token>();
	private int index=0;
	


	@Override
	public void add(Token token) {
		list.add(token);
		
	}

	public void add(ITokenList tokenList) {
		for (Token t : tokenList.getList())
			list.add(t);
	}

	public ArrayList<Token> getList() {
		return list;
	}

	@Override
	public void reset() {
		index=0;
	}

	@Override
	public Token nextToken() {
		return list.get(index++);
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		int c =0;
		for(Token t : list){
			if(c==5){
				sb.append('\n');
				c=-1;
			}
			sb.append(t.toString()+",");
			c++;
			
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	


	
	
	
}
