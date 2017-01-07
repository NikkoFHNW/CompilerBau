package ch.fhnw.compiler.scanner;

import ch.fhnw.compiler.scanner.data.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Scanner {

	private static Map<String, Token> keywords;
    private static StringBuffer lexAccu;
    private static int numAccu;
    private static int state;



	private static void initKeywords() {

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
        keywords.put("int64", new TokenTupel(Terminal.TYPE, Type.INT64));
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

    public static ITokenList scan(String file) {
        initKeywords();

//        StringBuilder code = new StringBuilder();
        int lineNr = 0;
        ITokenList result = new TokenList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
//            int i = (char)br.read();
            String line = br.readLine();
            while(line != null){
                lineNr++;
                ITokenList lineTokens = scanLine(line, lineNr);
                result.add(lineTokens);
                line = br.readLine();
            }
            br.close();
            result.add(new Token(Terminal.SENTINEL, lineNr));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

	public static ITokenList scanLine(CharSequence cs, int lineNr) throws Exception {
        cs = cs + " ";
        TokenList tList = new TokenList();
        numAccu = 0;
        lexAccu = new StringBuffer();
        state = 0;
        assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';

		for (int i = 0; i < cs.length(); i++) {
			char c = cs.charAt(i);

			switch (state) {
			case 0:
				if (Character.isLetter(c) && Character.isUpperCase(c)) {
					state = 5;
					lexAccu.append(c);
				} else if (Character.isLetter(c)) {
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
					tList.add(new Token(Terminal.LPAREN, lineNr));
				}else if(c==')'){
					tList.add(new Token(Terminal.RPAREN, lineNr));
				}else if(c == '{'){
					tList.add(new Token(Terminal.LCURL, lineNr));
				}else if(c=='}'){
					tList.add(new Token(Terminal.RCURL, lineNr));
				}else if(c=='*'){
					tList.add(new TokenTupel(Terminal.MULTOPR, Operator.TIMES, lineNr));
				}else if(c=='+'){
					tList.add(new TokenTupel(Terminal.ADDOPR, Operator.PLUS, lineNr));
				}else if(c=='-'){
					tList.add(new TokenTupel(Terminal.ADDOPR, Operator.MINUS, lineNr));
				}else if(c==','){
					tList.add(new Token(Terminal.COMMA, lineNr));
				}else if(c=='.'){
					tList.add(new Token(Terminal.DOT, lineNr));
				}else if(c==';'){
					tList.add(new Token(Terminal.SEMICOLON, lineNr));
				}else if(c=='^'){
					tList.add(new TokenTupel(Terminal.MULTOPR,Operator.POW, lineNr));
				}else if(c=='='){
					tList.add(new TokenTupel(Terminal.RELOPR,Operator.EQ, lineNr));
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
						tList.add(keywords.get(lexAccu.toString()).setLineNr(lineNr));
					}else{
						tList.add(new TokenTupel(Terminal.IDENT, lexAccu.toString(), lineNr));
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
					tList.add(new TokenTupel(Terminal.LITERAL, numAccu, lineNr));
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
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.LE, lineNr));
						clearLexAccu();
						state = 0;
						break;
					case '>':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.GE, lineNr));
						clearLexAccu();
						state = 0;
						break;
					case ':':
						tList.add(new Token(Terminal.BECOMES, lineNr));
						clearLexAccu();
						state = 0;
						break;
					case '/':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.NE, lineNr));
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
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.LT, lineNr));
						clearLexAccu();
						state = 0;
						i=i-1;
						break;
					case '>':
						tList.add(new TokenTupel(Terminal.RELOPR, Operator.GT, lineNr));
						clearLexAccu();
						state = 0;
						i=i-1;
						break;
					case ':':
						tList.add(new Token(Terminal.COLON, lineNr));
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
							tList.add(new TokenTupel(Terminal.BOOLOPR, Operator.CAND, lineNr));
							clearLexAccu();
							state = 0;
							break;

						case '|':
							tList.add(new TokenTupel(Terminal.BOOLOPR, Operator.COR, lineNr));
							clearLexAccu();
							state = 0;
							break;
					}
				} else {
					throw new LexicalError("no such symbol & or |");

				}
				break;

			case 5:
				if (Character.isLetter(c) || Character.isDigit(c) || c=='\'') {
					lexAccu.append(c);
				} else {
					if (keywords.containsKey(lexAccu.toString())) {
						tList.add(keywords.get(lexAccu.toString()));
					}else{
						tList.add(new TokenTupel(Terminal.RECIDENT, lexAccu.toString(), lineNr));
					}
					clearLexAccu();
					i = i - 1;
					state = 0;
				}
				break;
			default:
				throw new Exception("Default in Scanner");
			}

		}
        assert state == 0;

		return tList;

	}

	private static void clearLexAccu() {
        lexAccu = new StringBuffer();
	}

}
