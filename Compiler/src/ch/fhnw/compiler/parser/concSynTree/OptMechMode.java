package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

public class OptMechMode implements IConcSyn.IOptMechMode {

	TokenTupel mech;
    public OptMechMode(TokenTupel mech) {
    	this.mech =mech;
    }

    @Override
    public TokenTupel toAbstrSyntax() {
        return mech;
    }
}
