package ch.fhnw.compiler;

import java.util.HashMap;
import java.util.Map;

public class Scanner {
	
	private Map<String,Token> keywords;
	
	public Scanner(){
		
	}
	
	private void initKeywords(){
		keywords = new HashMap<String,Token>();
		keywords.put("bool", new TokenTupel(Terminals.TYPE,Types.BOOL));
		keywords.put("call", new Token(Terminals.CALL));
		keywords.put("const", new TokenTupel(Terminals.CHANGEMODE, Modes.CONST));
		keywords.put("copy", new TokenTupel(Terminals.MECHMODE,Modes.COPY));
		keywords.put("debugin", new Token(Terminals.DEBUGIN));
		keywords.put("debugout", new Token(Terminals.DEBUGOUT));
		keywords.put("divE", new TokenTupel(Terminals.MULTOPR,Operators.DIV));
		keywords.put("do", new Token(Terminals.DO));
		keywords.put("else", new Token(Terminals.ELSE));
		keywords.put("endfun", new Token(Terminals.ENDFUN));
		keywords.put("endif", new Token(Terminals.ENDIF));
	}
	

}
