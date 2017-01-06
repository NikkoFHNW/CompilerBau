package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FunDecl implements IConcSyn.IFunDecl {
	TokenTupel ident;
	ParamList pList;
	StoDecl stoDecl;
	OptGlobalglobImps optglobimps;
	OptLocalcpsStoDecl optLocalcpsStoDecl;
	CpsCmd cpscmd;


	public FunDecl(TokenTupel ident, ParamList pList, StoDecl stoDecl, OptGlobalglobImps optglobimps, OptLocalcpsStoDecl optLocalcpsStoDecl, CpsCmd cpscmd) {
		this.ident = ident;
		this.pList = pList;
		this.stoDecl = stoDecl;
		this.optglobimps = optglobimps;
		this.optLocalcpsStoDecl = optLocalcpsStoDecl;
		this.cpscmd = cpscmd;
	}

	@Override
	public IAbs.IDecl toAbstrSyntax() {
		return null;
	}
}
