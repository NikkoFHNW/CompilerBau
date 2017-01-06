package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;

public class StoDecl {
	
//	ChangeMode cm;
	
	TokenTupel cm;
	TokenTupel ident;
	TokenTupel type;
	
	public StoDecl(TokenTupel cm, TokenTupel ident, TokenTupel type){
		this.cm=cm;
		this.ident=ident;
		this.type=type;
	}
}
