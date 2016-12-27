package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class ProgParamList implements IConcSynWrapper{
	Token lparen;
	OptProgParamRepCommaProgParam optProgParamRepCommaProgParam;
	Token rparen;

	public ProgParamList(Token lp, Token rp, OptProgParamRepCommaProgParam opr) {
		this.lparen=lp;
		this.rparen=rp;
		this.optProgParamRepCommaProgParam=opr;
	}


	@Override
	public IAbstractSynTree toAbstractSynTree() {
		return null;
	}
}
