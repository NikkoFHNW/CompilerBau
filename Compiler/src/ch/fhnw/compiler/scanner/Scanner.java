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
		 lexAccu = new StringBuffer();
		 tList = new TokenList();
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
        assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';
       

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
				}else if(c == '('){
					tList.add(new Token(Terminal.LPAREN));
				}
				else if(c==')'){
					tList.add(new Token(Terminal.RPAREN));
				}else if(c=='*'){
					tList.add(new TokenTupel(Terminal.MULTOPR, Operator.TIMES));
				}else if(c=='+'){
					tList.add(new TokenTupel(Terminal.ADDOPR, Operator.PLUS));
				}else if(c=='-'){
					tList.add(new TokenTupel(Terminal.ADDOPR, Operator.MINUS));
				}else if(c==','){
					tList.add(new Token(Terminal.COMMA));
				}else if(c==';'){
					tList.add(new Token(Terminal.SEMICOLON));
				}else if(c=='^'){
					tList.add(new TokenTupel(Terminal.MULTOPR,Operator.POW));
				}else if(c=='='){
					tList.add(new TokenTupel(Terminal.RELOPR,Operator.EQ));
				}
				else if (!Character.isWhitespace(c)) {
					throw new LexicalError("state 0, other Input");
				}
				break;
			case 1:
				if (Character.isLetter(c) || Character.isDigit(c) || c=='\'') {
					lexAccu.append(c);
				} else {
					if (keywords.containsKey(lexAccu.toString())) {
						tList.add(keywords.get(lexAccu.toString()));
					}else{
						tList.add(new TokenTupel(Terminal.IDENT, lexAccu.toString()));
					}

					clearLexAccu();
					i = i - 1;
					state = 0;
				}
				break;
			case 2:
				if (Character.isDigit(c)) {
					numAccu = numAccu * 10 + Character.getNumericValue(c);
				} else if(c!='\''){
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
						clearLexAccu();
						state = 0;
						break;
					case '>':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.GE));
						clearLexAccu();
						state = 0;
						break;
					case ':':
						tList.add(new Token(Terminal.BECOMES));
						clearLexAccu();
						state = 0;
						break;
					case '/':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.NE));
						clearLexAccu();
						state = 0;
						break;
					}
				}else if(c=='/'){
					while(c!='\n'){
						i++;
						c=cs.charAt(i);
					}
					state=0;
				}				
				else{
					char tempc = lexAccu.charAt(0);
					switch (tempc) {
					case '<':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.LT));
						clearLexAccu();
						state = 0;
						i=i-1;
						break;
					case '>':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.GT));
						clearLexAccu();
						state = 0;
						i=i-1;
						break;
					case ':':
						tList.add(new Token(Terminal.COLON));
						clearLexAccu();
						state = 0;
						i=i-1;
						break;
					case '/':
						throw new LexicalError("no such symbol '/' ");
					}
				}
				break;
			case 4:
                if (c == '?') {
					char tempc = lexAccu.charAt(0);
					switch (tempc) {
						case '&':
							tList.add(new TokenTupel(Terminal.BOOLOPR, Operator.CAND));
							clearLexAccu();
							state = 0;
							break;

						case '|':
							tList.add(new TokenTupel(Terminal.BOOLOPR, Operator.COR));
							clearLexAccu();
							state = 0;
							break;
					}
				} else {
					throw new LexicalError("no such symbol & or |");

				}

				break;

			default:
				throw new Exception("Default in Scanner");
			}

		}
        assert state == 0;

		tList.add(new Token(Terminal.SENTINEL));
		return tList;

	}

	private void clearLexAccu() {
		lexAccu = new StringBuffer();
	}

}
