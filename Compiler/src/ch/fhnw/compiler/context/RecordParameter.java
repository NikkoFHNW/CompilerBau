package ch.fhnw.compiler.context;

import ch.fhnw.compiler.scanner.data.Mode;
import ch.fhnw.compiler.scanner.data.Type;

public class RecordParameter extends Parameter{

	String recIdent;
	
	public RecordParameter(Mode flowMode, Mode mechMode, Mode changeMode, String recIdent) {
		super(flowMode, mechMode, changeMode, null);
		this.recIdent=recIdent;
	}

}
