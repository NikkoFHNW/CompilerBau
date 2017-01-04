package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FunDecl implements IConcSyn.IFunDecl {
	TokenTupel ident;
	ParamList pList;
	OptGlobalglobImps optglobimps;
	OptLocalcpsStoDecl optLocalcpsStoDecl;
	CpsCmd cpscmd;


    public FunDecl(TokenTupel ident, ParamList pList, OptGlobalglobImps optglobimps, OptLocalcpsStoDecl optLocalcpsStoDecl, CpsCmd cpsCmd) {
    	this.ident=ident;
    	this.pList=pList;
    	this.optglobimps = optglobimps;
    	this.optLocalcpsStoDecl=optLocalcpsStoDecl;
    	this.cpscmd=cpsCmd;
    }

	@Override
	public IAbs.IDecl toAbstrSyntax() {
		return null;
	}
}
