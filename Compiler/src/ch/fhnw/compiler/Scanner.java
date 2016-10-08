package ch.fhnw.compiler;

import java.util.HashMap;
import java.util.Map;

public class Scanner {

	private Map<String, Token> keywords;
	private TokenList tList;
	private int numAccu = 0;
	StringBuffer lexAccu = null;
	int state = 0;

	public Scanner() {
		initKeywords();
	}

	private void initKeywords() {
		keywords = new HashMap<String, Token>();
		keywords.put("bool", new TokenTupel(Terminals.TYPE, Types.BOOL));
		keywords.put("call", new Token(Terminals.CALL));
		keywords.put("const", new TokenTupel(Terminals.CHANGEMODE, Modes.CONST));
		keywords.put("copy", new TokenTupel(Terminals.MECHMODE, Modes.COPY));
		keywords.put("debugin", new Token(Terminals.DEBUGIN));
		keywords.put("debugout", new Token(Terminals.DEBUGOUT));
		keywords.put("divE", new TokenTupel(Terminals.MULTOPR, Operators.DIV));
		keywords.put("do", new Token(Terminals.DO));
		keywords.put("else", new Token(Terminals.ELSE));
		keywords.put("endfun", new Token(Terminals.ENDFUN));
		keywords.put("endif", new Token(Terminals.ENDIF));
	}

	public ITokenList scan(CharSequence cs) throws Exception, LexicalError {

		for (int i = 0; i < cs.length(); i++) {
			char c = cs.charAt(i);
			switch (state) {
			case 0:
				if (Character.isLetter(c)) {
					state = 1; // Ident
					lexAccu.append(c);
				} else if (Character.isDigit(c)) {
					state = 2; // Literal
					numAccu = Character.getNumericValue(c);
				} else if (c == '<' || c == '>' || c == ':' || c == '/') {
					state = 3; // Combines symbols with =
					lexAccu.append(c);
				} else if (c == '&' || c == '|') {
					state = 4; // Combines symbol with ?
					lexAccu.append(c);
				} else if (!Character.isWhitespace(c)) {
					throw new LexicalError("state 0, other Input");
				}
				break;
			case 1:
				if (Character.isLetter(c) || Character.isDigit(c)) {
					lexAccu.append(c);
				} else {
					if (keywords.containsKey(lexAccu.toString())) {
						tList.add(keywords.get(lexAccu.toString()));
					}
					tList.add(new TokenTupel(Terminals.IDENT, lexAccu.toString()));
					lexAccu = new StringBuffer();
					i = i - 1;
					state = 0;
				}
				break;
			case 2:
				if (Character.isDigit(c)) {
					numAccu = numAccu * 10 + Character.getNumericValue(c);
				} else {
					tList.add(new TokenTupel(Terminals.LITERAL, numAccu));
					i = i - 1;
					state = 0;
					numAccu = 0;
				}
				break;
			case 3:
				if (c == '=') {
					char tempc = lexAccu.charAt(0);
					switch (tempc) {
					case '<':
						tList.add(new TokenTupel(Terminals.RELOPR, Operators.LE));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					case '>':
						tList.add(new TokenTupel(Terminals.RELOPR, Operators.GE));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					case ':':
						tList.add(new Token(Terminals.BECOMES));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					case '/':
						tList.add(new TokenTupel(Terminals.RELOPR, Operators.NE));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					}
				}else{
					char tempc = lexAccu.charAt(0);
					switch (tempc) {
					case '<':
						tList.add(new TokenTupel(Terminals.RELOPR, Operators.LT));
						lexAccu = new StringBuffer();
						state = 0;
						i=i-1;
						break;
					case '>':
						tList.add(new TokenTupel(Terminals.RELOPR, Operators.GT));
						lexAccu = new StringBuffer();
						state = 0;
						i=i-1;
						break;
					case ':':
						tList.add(new Token(Terminals.COLON));
						lexAccu = new StringBuffer();
						state = 0;
						i=i-1;
						break;
					case '/':
						i=i-1;
						lexAccu = new StringBuffer();
						state = 0;
						throw new LexicalError("no such symbol '/' ");
					}
				}
				break;
			case 4:
				break;

			default:
				throw new Exception("Default in Scanner");
			}

		}

		return tList;

	}

}
