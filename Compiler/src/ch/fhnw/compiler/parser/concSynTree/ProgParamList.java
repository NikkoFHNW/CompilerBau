package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.scanner.data.Terminal;

public class ProgParamList implements IConcSynWrapper{

	Terminal lparen;
	Terminal rparen;
	OptProgParamRepCommaProgParam opro;
	
	public ProgParamList(Terminal lp, Terminal rp, OptProgParamRepCommaProgParam opr) {
		// TODO Auto-generated constructor stub
		this.lparen=lp;
		this.rparen=rp;
		this.opro=opr;
	}
	
	
}
