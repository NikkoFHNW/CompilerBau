package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;

public class ProgParamList implements IConcSynWrapper{
	OptProgParamRepCommaProgParam optProgParamRepCommaProgParam;

	public ProgParamList(OptProgParamRepCommaProgParam rp) {
		this.optProgParamRepCommaProgParam=rp;
	}


	@Override
	public IAbstractSynTree toAbstractSynTree() {
		return null;
	}
}
