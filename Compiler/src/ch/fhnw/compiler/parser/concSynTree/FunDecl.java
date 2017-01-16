package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FunDecl implements IConcSyn.IFunDecl {
	TokenTupel ident;
	Param pList;
	StoDecl stoDecl;
	OptGlobalglobImps optglobimps;
	IDecl optLocalcpsStoDecl;
	CpsCmd cpscmd;


	public FunDecl(TokenTupel ident, Param pListHead, StoDecl stoDecl, OptGlobalglobImps optglobimps, IDecl optLocalcpsStoDecl, CpsCmd cpscmd) {
		this.ident = ident;
		this.pList = pListHead;
		this.stoDecl = stoDecl;
		this.optglobimps = optglobimps;
		this.optLocalcpsStoDecl = optLocalcpsStoDecl;
		this.cpscmd = cpscmd;
	}

	@Override
	public IAbs.IDecl toAbstrSyntax() throws GrammarError {
		return new ch.fhnw.compiler.parser.abs.FunDecl(ident,pList.toAbstrSyntax(),stoDecl.toAbstrSyntax(),optglobimps.toAbstrSyntax(),optLocalcpsStoDecl.toAbstrSyntax(),cpscmd.toAbstrSyntax());
	}
}
