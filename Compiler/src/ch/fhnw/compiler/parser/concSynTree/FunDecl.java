package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.IAbstractSynTree;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class FunDecl implements IConcSynWrapper {
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
    public IAbstractSynTree toAbstractSynTree() {
		return null;
        
    }
}
