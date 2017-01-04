package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;

public class ProgParamList implements IConcSyn.IParamList {
	OptProgParamRepCommaProgParam optProgParamRepCommaProgParam;

	public ProgParamList(OptProgParamRepCommaProgParam rp) {
		this.optProgParamRepCommaProgParam=rp;
	}


	@Override
	public IAbs.IParam toAbstrSyntax() {
		return null;
	}
}
