package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.scanner.data.Token;

public class ProgParamList implements IConcSynWrapper{

	Token lparen;
	Token rparen;
	OptProgParamRepCommaProgParam opro;
	
	public ProgParamList(Token lp, Token rp, OptProgParamRepCommaProgParam opr) {
		// TODO Auto-generated constructor stub
		this.lparen=lp;
		this.rparen=rp;
		this.opro=opr;
	}
	
	
}
