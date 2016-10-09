package ch.fhnw.compiler.scanner;

import ch.fhnw.compiler.scanner.data.*;

import java.util.*;

public class Scanner {

	private Map<String, Token> keywords;
	private TokenList tList;
	private int numAccu = 0;
	private StringBuffer lexAccu = null;
	private int state = 0;

	public Scanner() {
		initKeywords();
	}

	private void initKeywords() {

        // create map entries for ALL tupel terminals
        keywords = new HashMap<>();
		keywords.put("bool", new TokenTupel(Terminal.TYPE, Type.BOOL));
		keywords.put("const", new TokenTupel(Terminal.CHANGEMODE, Mode.CONST));
		keywords.put("copy", new TokenTupel(Terminal.MECHMODE, Mode.COPY));
		keywords.put("divE", new TokenTupel(Terminal.MULTOPR, Operator.DIV));
        keywords.put("false", new TokenTupel(Terminal.LITERAL, false));
        keywords.put("in", new TokenTupel(Terminal.FLOWMODE, Mode.IN));
        keywords.put("inout", new TokenTupel(Terminal.FLOWMODE, Mode.INOUT));
        keywords.put("int32", new TokenTupel(Terminal.TYPE, Type.INT32));
        keywords.put("modE", new TokenTupel(Terminal.MULTOPR, Operator.MOD));
        keywords.put("out", new TokenTupel(Terminal.FLOWMODE, Mode.OUT));
        keywords.put("ref", new TokenTupel(Terminal.MECHMODE, Mode.REF));
        keywords.put("true", new TokenTupel(Terminal.LITERAL, true));
        keywords.put("var", new TokenTupel(Terminal.CHANGEMODE, Mode.VAR));

        // create list with tupel terminals
        LinkedList<Terminal> tupelTokens = new LinkedList<>();
        for (Object o : keywords.entrySet()) {
            Map.Entry e = (Map.Entry) o;
            TokenTupel t = (TokenTupel) e.getValue();
            if (!tupelTokens.contains(t.getTerminal()))
                tupelTokens.add(t.getTerminal());
        }

        // create map entries for all single terminals (remaining entries in Terminal)
        for (Terminal t : Terminal.values()) {
            if (!tupelTokens.contains(t)) {
                keywords.put(t.toString().toLowerCase(), new Token(t));
            }
        }


	}

	public ITokenList scan(CharSequence cs) throws Exception {

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
					tList.add(new TokenTupel(Terminal.IDENT, lexAccu.toString()));
					lexAccu = new StringBuffer();
					i = i - 1;
					state = 0;
				}
				break;
			case 2:
				if (Character.isDigit(c)) {
					numAccu = numAccu * 10 + Character.getNumericValue(c);
				} else {
					tList.add(new TokenTupel(Terminal.LITERAL, numAccu));
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
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.LE));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					case '>':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.GE));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					case ':':
						tList.add(new Token(Terminal.BECOMES));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					case '/':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.NE));
						lexAccu = new StringBuffer();
						state = 0;
						break;
					}
				}else{
					char tempc = lexAccu.charAt(0);
					switch (tempc) {
					case '<':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.LT));
						lexAccu = new StringBuffer();
						state = 0;
						i=i-1;
						break;
					case '>':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.GT));
						lexAccu = new StringBuffer();
						state = 0;
						i=i-1;
						break;
					case ':':
						tList.add(new Token(Terminal.COLON));
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
                // TODO state 4
			    break;

			default:
				throw new Exception("Default in Scanner");
			}

		}

		return tList;

	}

}
