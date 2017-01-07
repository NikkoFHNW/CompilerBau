package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.parser.concSynTree.*;
import ch.fhnw.compiler.error.*;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn.ICpsDecl;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn.IDecl;
import ch.fhnw.compiler.parser.concSynTree.IConcSyn.IParam;
import ch.fhnw.compiler.scanner.data.*;


public class Parser implements IParser {

	private ITokenList tokenList;
	private Token token;
	private Terminal terminal;
	int consCount=0;
	public Parser(ITokenList tl){
	this.tokenList=tl;
	this.tokenList.reset();
	
	token = tokenList.nextToken();
	terminal = token.getTerminal();
	
	}
	
	
	@Override
	public Program parse() throws ch.fhnw.compiler.error.GrammarError {
		// TODO Auto-generated method stub
		
		Program program = program();
		consume(Terminal.SENTINEL);
		return program;

	}
	
	private Program program() throws ch.fhnw.compiler.error.GrammarError{
        if (terminal == Terminal.PROGRAM) {
            consume(Terminal.PROGRAM);
            TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
            ProgParamList progParamList = (ProgParamList) progParamList();
//            OptGlobalCpsDecl optGlobalCpsDecl = (OptGlobalCpsDecl) optGlobalcpsDecl();
            ICpsDecl optGlobalCpsDecl = (ICpsDecl) optGlobalcpsDecl();
            consume(Terminal.DO);
            CpsCmd cpsCmd = (CpsCmd) cpsCmd();
            consume(Terminal.ENDPROGRAM);
            return new Program(ident, progParamList, optGlobalCpsDecl, cpsCmd);
        }

        else
		    throw new ch.fhnw.compiler.error.GrammarError(terminal,Terminal.PROGRAM);
	}


	private Token consume(Terminal expectedTerm) throws ch.fhnw.compiler.error.GrammarError{
     consCount++;
		if(terminal==expectedTerm){
			Token consumedToken = token;
			if(terminal!=Terminal.SENTINEL){
				token = tokenList.nextToken();
				terminal = token.getTerminal();
			}
			return consumedToken;
		}else{
			System.out.println("expected: "+ expectedTerm + " actual: " + terminal + "consume count: "+consCount + " linenr: "+ token.getLineNr());
			throw new ch.fhnw.compiler.error.GrammarError(terminal,expectedTerm);
		}
	}
	
	
	private IConcSyn decl() throws GrammarError {
		switch(terminal) {
			case FUN:
				System.out.println("decl ::= funDecl");
				return funDecl();
			case PROC:
				System.out.println("decl ::= procDecl");
				return procDecl();
			case CHANGEMODE:
			case IDENT:
				System.out.println("decl ::= storeDecl");
				return stoDecl();
			case REC:
				return recordDecl();
			default:
				throw new ch.fhnw.compiler.error.GrammarError("decl got "+ terminal,token.getLineNr());
		}
	}
	
	
	private IConcSyn stoDecl() throws GrammarError {
		switch(terminal) {
		case REC: System.out.println("stoDecl ::= recordDecl");
		return recordDecl();
		default: System.out.println("stoDecl ::= OptChangeMode Ident");
		OptChangeMode optChangeMode = (OptChangeMode) optChangeMode();
		TypedIdent ident = (TypedIdent) typedIdent();
		return new StoDecl(optChangeMode,ident);
		}
	}
	
	
	private IConcSyn funDecl() throws ch.fhnw.compiler.error.GrammarError{
		switch(terminal){
		case FUN:
			System.out.println("funDecl ::= FUN ident ParamList Returns StoDecl OptGlobalglobImps OptLocalcpsStoDecl");
			consume(Terminal.FUN);
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			ParamList paramList = (ParamList) paramList();
			consume(Terminal.RETURNS);
			StoDecl stoDecl = (StoDecl) stoDecl();
			OptGlobalglobImps optGlobalglobImps = (OptGlobalglobImps) optGlobalglobImps();
			ICpsDecl optLocalcpsStoDecl = (ICpsDecl) optLocalcpsStoDecl();
			consume(Terminal.DO);
			CpsCmd cpsCmd = (CpsCmd) cpsCmd();
			consume(Terminal.ENDFUN);
			
			return new FunDecl(ident, paramList, stoDecl, optGlobalglobImps, optLocalcpsStoDecl, cpsCmd);

		default: throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
		}
	}
	
	private IConcSyn optGlobalcpsDecl() throws GrammarError{

		switch(terminal){
		case GLOBAL:
			consume(Terminal.GLOBAL);
			return cpsDecl();
//			CpsDecl cps = cpsDecl();
//			return new OptGlobalCpsDecl(global, cpsDecl);

		default: return new OptGlobalcpsDeclEps(); //EPSILON

		}

	}

	private IConcSyn optChangeMode() throws GrammarError{

		switch(terminal){
		case CHANGEMODE:

			return new OptChangeMode((TokenTupel) consume(Terminal.CHANGEMODE));
			default: return new OptChangeModeEps(); //EPSILON


		}
	}

	private IConcSyn optGlobalglobImps()throws GrammarError{
		switch(terminal){
		case GLOBAL:
			consume(Terminal.GLOBAL);
			return globImps();

			default: return new OptGlobalglobImpsEps(); //EPSILON


		}

	}

	private IConcSyn optLocalcpsStoDecl() throws GrammarError{
		switch(terminal){
		case LOCAL:
			consume(Terminal.LOCAL);
			return cpsStoDecl();

			default: return new OptLocalcpsStoDeclEps(); //EPSILON


		}

	}
	private IConcSyn procDecl() throws GrammarError{

		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		ParamList paramList = (ParamList) paramList();
		OptGlobalglobImps optggi = (OptGlobalglobImps) optGlobalglobImps();
		OptLocalcpsStoDecl olcsd = (OptLocalcpsStoDecl) optLocalcpsStoDecl();
		consume(Terminal.DO);
		CpsCmd cpsCmd = (CpsCmd) cpsCmd();
		consume(Terminal.ENDPROC);
		return new ProcDecl(ident, paramList, optggi, olcsd,cpsCmd);
	}
	private IConcSyn globImps() throws GrammarError{

		GlobImp globImp = (GlobImp) globImp();
		RepCommaGlobImp repCom = (RepCommaGlobImp) repCommaGlobImp();
		return new GlobImps(globImp, repCom);


	}
	private IConcSyn repCommaGlobImp() throws GrammarError{
		switch(terminal){
		case COMMA:
			consume(Terminal.COMMA);
			GlobImp globImp = (GlobImp) globImp();
			RepCommaGlobImp repCommaGI = (RepCommaGlobImp) repCommaGlobImp();
			return  new RepCommaGlobImp(globImp, repCommaGI); //Hier gehts nicht ohne new return sonst geht globimp verloren

		default: return new RepCommaGlobImpEps(); //EPSILON

		}
	}
	private IConcSyn globImp() throws GrammarError{
//		[N optFlowMode, N optChangeMode, T IDENT]
		OptFlowMode optFlowMode = (OptFlowMode) optFlowMode();
		OptChangeMode optChangeMode = (OptChangeMode) optChangeMode();
		TokenTupel tt = (TokenTupel) consume(Terminal.IDENT);
		return new GlobImp(optFlowMode, optChangeMode, tt);
	}
	private IConcSyn optFlowMode() throws GrammarError{
// [[T FLOWMODE], []]
		switch(terminal){
		case FLOWMODE:
			 //Hier was returnen? die optklasse oder flowmode?
//			falls flowmode, token oder tokentupel. beide m�sste IConcSyn auch implementieren.
			return new OptFlowMode((TokenTupel) consume(Terminal.FLOWMODE));
		default: return new OptFlowModeEps(); //EPSILON
		}


	}
	private IConcSyn cpsDecl() throws GrammarError{
//[[N decl, N repSemicolonDecl]]
		IDecl decl = (IDecl) decl();
		RepSemicolonDecl repDecl = (RepSemicolonDecl) repSemicolonDecl();
		return new CpsDecl(decl, repDecl);
	}
	private IConcSyn repSemicolonDecl() throws GrammarError{
//[[T SEMICOLON, N decl, N repSemicolonDecl],[]]
		switch(terminal){
		case SEMICOLON:
			consume(Terminal.SEMICOLON);
			IDecl decl = (IDecl) decl();
			RepSemicolonDecl repDecl = (RepSemicolonDecl) repSemicolonDecl();
			return new RepSemicolonDecl(decl, repDecl);
		default: return new RepSemicolonDeclEps(); //EPSILON
		}
	}
	private IConcSyn cpsStoDecl() throws GrammarError{
//		[[N stoDecl, N repSemicolonStoDecl]]
		StoDecl stoDecl = (StoDecl) stoDecl();
		RepSemicolonStoDecl repSto= (RepSemicolonStoDecl) repSemicolonStoDecl();
		return new CpsStoDecl(stoDecl, repSto);
	}
	private IConcSyn repSemicolonStoDecl() throws GrammarError{
//[[T SEMICOLON, N stoDecl, N repSemicolonStoDecl],[]]
		switch(terminal){
		case SEMICOLON:
			consume(Terminal.SEMICOLON);
			StoDecl stoDecl = (StoDecl) stoDecl();
			RepSemicolonStoDecl repSto = (RepSemicolonStoDecl) repSemicolonStoDecl();
			return new RepSemicolonStoDecl( stoDecl, repSto);
		default: return new RepSemicolonStoDeclEps();		}
	}
	private IConcSyn progParamList() throws GrammarError{
//[[T LPAREN, N optProgParamRepCommaProgParam, T RPAREN]]
		consume(Terminal.LPAREN);
		OptProgParamRepCommaProgParam optPro = (OptProgParamRepCommaProgParam) optProgParamRepCommaProgParam();
		consume(Terminal.RPAREN);
		return new ProgParamList(optPro);
	}
	private IConcSyn optProgParamRepCommaProgParam() throws GrammarError{
//[N progParam, N repCommaProgParam], []]
		switch(terminal){
		case DOT: //dot musste zu terminal hinzugef�gt werden
		case FLOWMODE:
		case CHANGEMODE:
		case IDENT:
			ProgramParam progParam = (ProgramParam) progParam();
			RepCommaProgParam repPr = (RepCommaProgParam) repCommaProgParam();
			return new OptProgParamRepCommaProgParam(progParam, repPr);
		default: return new OptProgParamRepCommaProgParamEps(); //EPSILON

		}
	}
	private IConcSyn repCommaProgParam() throws GrammarError{
//[[T COMMA, N progParam, N repCommaProgParam], []]
		switch(terminal){
		case COMMA:
			consume(Terminal.COMMA);
			ProgramParam progParam = (ProgramParam) progParam();
			RepCommaProgParam repPr = (RepCommaProgParam) repCommaProgParam();
			return new RepCommaProgParam(progParam, repPr);
		default: return new RepCommaProgParamEps(); //EPSILON

		}
	}
	private IConcSyn progParam() throws GrammarError{
//[[N optFlowMode, N optChangeMode, N typedIdent],[N recordParam]]

		switch(terminal){
		case FLOWMODE:
		case CHANGEMODE:
		case IDENT:
			OptFlowMode optFlow = (OptFlowMode) optFlowMode();
			OptChangeMode optChange = (OptChangeMode) optChangeMode();
			TypedIdent tpyedIdent = (TypedIdent) typedIdent();
			return new ProgramParam(optFlow, optChange, tpyedIdent);
		case DOT:
			return recordParam();
		default: throw new GrammarError("progParam", 0);
		}
	}
	private IConcSyn paramList() throws GrammarError{
//[[T LPAREN, N optParamRepCommaParam, T RPAREN]]
		consume(Terminal.LPAREN);
		OptParamRepCommaParam optP = (OptParamRepCommaParam) optParamRepCommaParam();
		consume(Terminal.RPAREN);
		return new ParamList(optP);
	}
	private IConcSyn optParamRepCommaParam() throws GrammarError{
// [[N param, N repCommaParam], []]
		switch(terminal){
		case FLOWMODE:
		case MECHMODE:
		case CHANGEMODE:
		case DOT:
		case IDENT:
			Param p = (Param) param();
			RepCommaParam rep = (RepCommaParam) repCommaParam();
			return new OptParamRepCommaParam(p, rep);
		default: return new OptParamRepCommaParamEps(); //EPSILON
		}
	}
	private IConcSyn repCommaParam() throws GrammarError{
//[[T COMMA, N param, N repCommaParam], []]
		switch(terminal){
		case COMMA:
			consume(Terminal.COMMA);
			Param p = (Param) param();
			RepCommaParam rp = (RepCommaParam) repCommaParam();
			return new RepCommaParam(p, rp);
		default: return new RepCommaParamEps(); //EPSILON

		}

	}
	private IConcSyn param()throws GrammarError{
//		[[N optFlowMode, N optMechMode, N optChangeMode, N typedIdent],[N recordParam]]
//		switch(terminal){
//		case FLOWMODE:
//		case MECHMODE:
//		case CHANGEMODE:
//		case IDENT:
//			OptFlowMode optFl = (OptFlowMode) optFlowMode();
//			OptMechMode optM = (OptMechMode) optMechMode();
//			OptChangeMode optC = (OptChangeMode) optChangeMode();
//			TypedIdent tIdent = (TypedIdent) typedIdent();
//			return new Param(optFl, optM, optC, tIdent);
//		case DOT:
//			return recordParam();
//		default: throw new GrammarError("param", 0);
//		}
		
		OptFlowMode optFl = (OptFlowMode) optFlowMode();
		OptMechMode optM = (OptMechMode) optMechMode();
		OptChangeMode optC = (OptChangeMode) optChangeMode();
		IParam param = (IParam) typedIdentOrRecordParam();
		return new Param(optFl, optM, optC, param);
		
	}
	
	private IConcSyn typedIdentOrRecordParam() throws GrammarError{
		switch(terminal){
		case DOT: 

			return recordParam(); 
		case IDENT:
			return typedIdent();
		default: throw new GrammarError("tyoedIdentOrRecordParam", token.getLineNr());
		}
		
	}
	
	private OptMechMode optMechMode() throws GrammarError {
		// TODO Auto-generated method stub
		switch(terminal){
		case MECHMODE:

			return new OptMechMode((TokenTupel) consume(Terminal.MECHMODE));
			default: return new OptMechModeEps(); //EPSILON


		}
	}


	private IConcSyn recordParam() throws GrammarError{
//		 [[T DOT,T IDENT, T COLON, T RECIDENT]]
		consume(Terminal.DOT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		TokenTupel recIdent= (TokenTupel) consume(Terminal.RECIDENT); //Add scanner if starts with capital
		//RECIDENT zu terminal hinzugef�gt;
		return new RecordParam(ident, recIdent);
	}
	private IConcSyn typedIdent() throws GrammarError{
//		[[T IDENT, T COLON, T ATOMTYPE]]
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		TokenTupel aType = (TokenTupel) consume(Terminal.TYPE); //TYPE == ATOMTYPE??
		return new TypedIdent(ident, aType);
	}
	

	private IConcSyn cmd() throws GrammarError {
		AbstractCmd result;
        switch (terminal) {
            case SKIP:
                System.out.println("cmd ::= SKIP");
                consume(Terminal.SKIP);
				result = new CmdSkip();
				break;

			case IF:
				System.out.println("cmd ::= IF");
				consume(Terminal.IF);
				Expr expr = (Expr) expr();
				consume(Terminal.THEN);
				CpsCmd cpsCmd1 = (CpsCmd) cpsCmd();
				consume(Terminal.ELSE);
				CpsCmd cpsCmd2 = (CpsCmd) cpsCmd();
				consume(Terminal.ENDIF);
				result = new CmdIf(expr, cpsCmd1, cpsCmd2);
				break;

			case WHILE:
				System.out.println("cmd ::= WHILE");
				consume(Terminal.WHILE);
				expr = (Expr) expr();
				consume(Terminal.DO);
				CpsCmd cpsCmd = (CpsCmd) cpsCmd();
				consume(Terminal.ENDWHILE);
				result = new CmdWhile(expr, cpsCmd);
				break;

			case CALL:
				System.out.println("cmd ::= CALL");
				consume(Terminal.CALL);
				TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
				ExprList exprList = (ExprList) exprList();
				OptGlobInits optGlobInits = (OptGlobInits) optGlobInits();
				result = new CmdCall(ident, exprList, optGlobInits);
				break;

			case DEBUGIN:
				System.out.println("cmd ::= DEBUGIN");
				consume(Terminal.DEBUGIN);
				expr = (Expr) expr();
				result = new CmdDebugIn(expr);
				break;

			case DEBUGOUT:
				System.out.println("cmd ::= DEBUGOUT");
				consume(Terminal.DEBUGOUT);
				expr = (Expr) expr();
				result = new CmdDebugOut(expr);
				break;

            case RECIDENT:
                System.out.println("cmd ::= RECIDENT");
                TokenTupel recident = (TokenTupel) consume(Terminal.RECIDENT);
                ident = (TokenTupel) consume(Terminal.IDENT);
                consume(Terminal.BECOMES);
                consume(Terminal.LPAREN);
                AbstractRecConstr recconstr = (AbstractRecConstr) recConstr();
                consume(Terminal.RPAREN);
                result = new CmdRec(ident, recident, recconstr);
                break;

            default:
            	try{
            		Expr expr1 = (Expr) expr();
            		consume(Terminal.BECOMES);
            		Expr expr2 = (Expr) expr();
            		return new CmdBecomes(expr1, expr2);
            	}catch(GrammarError e){
            		throw new GrammarError("cmd()" + "term: "+terminal + "cons count: "+consCount, token.getLineNr());
            	}
            	
                
		}
		return result;
    }

    private IConcSyn recConstr() throws GrammarError {
		if (terminal == Terminal.IDENT) {
			System.out.println("recConstr ::= IDENT First");
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			RepCommaIdentLiteral repCommaIdentLiteral = (RepCommaIdentLiteral) repCommaIdentLiteral();
			return new RecConstrIdentFirst(ident, repCommaIdentLiteral);
		} else if (terminal == Terminal.LITERAL) {
			System.out.println("recConstr ::= LITERAL first");
			TokenTupel literal = (TokenTupel) consume(Terminal.LITERAL);
			RepCommaIdentLiteral repCommaIdentLiteral = (RepCommaIdentLiteral) repCommaIdentLiteral();
			return new RecConstrLiteralFirst(literal, repCommaIdentLiteral);
		} else
			throw new GrammarError("recConstr", 0);
	}

	private IConcSyn repCommaIdentLiteral() throws GrammarError {
		RepCommaIdentLiteral head = null, current;

		while (terminal == Terminal.COMMA) {
			consume(Terminal.COMMA);

			if (terminal == Terminal.IDENT) {
				System.out.println("repCommaIdentLiteral ::= IDENT");
				TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
				current = new RepCommaIdentLiteral(ident, null);
			} else if (terminal == Terminal.LITERAL) {
				System.out.println("repCommaIdentLiteral ::= LITERAL");
				TokenTupel literal = (TokenTupel) consume(Terminal.LITERAL);
				current = new RepCommaIdentLiteral(null, literal);
			}
			else
				throw new GrammarError("repCommaIdentLiteral", 0);

			if (head == null)
				head = current;
			else
				head.setNext(current);
		}
		return head;
	}

	private IConcSyn optGlobInits() throws GrammarError {
		if (terminal == Terminal.INIT) {
            GlobInits globInits = (GlobInits) globInits();
			return new OptGlobInits(globInits);
		} else
			return new OptGlobInitsEps();//OptGlobInitsEpsilon()
	}

    private IConcSyn cpsCmd() throws GrammarError {
		System.out.println("cpsCmd");
        AbstractCmd cmd = (AbstractCmd) cmd();

        CpsCmd head = new CpsCmd(cmd);

        if (terminal == Terminal.SEMICOLON) {
            consume(Terminal.SEMICOLON);
            CpsCmd next = (CpsCmd) cpsCmd();
            head.setNext(next);
        }
        return head;
	}

    private IConcSyn globInits() throws GrammarError {
        System.out.println("globInits");
        consume(Terminal.INIT);
        Idents idents = (Idents) idents();
        return new GlobInits(idents);
    }

    private IConcSyn idents() throws GrammarError {
        System.out.println("idents");
        TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);

        Idents head = new Idents(ident);

        if (terminal == Terminal.COMMA) {
            consume(Terminal.COMMA);
            Idents next = (Idents) idents();
            head.setNext(next);
        }
        return head;
    }

    private IConcSyn expr() throws GrammarError {
        System.out.println("expr");
        Term1 term1 = (Term1) term1();
        RepTerm1 repTerm1 = (RepTerm1) repTerm1();
        return new Expr(term1, repTerm1);
    }

    private IConcSyn repTerm1() throws GrammarError {
        if(terminal == Terminal.BOOLOPR) {
            System.out.println("expr := repterm1");
			TokenTupel boolOpr = (TokenTupel) consume(Terminal.BOOLOPR);
            Term1 term1 = (Term1) term1();
            RepTerm1 repTerm1 = new RepTerm1(boolOpr, term1);
            RepTerm1 next = (RepTerm1) repTerm1();
            repTerm1.setNext(next);
            return repTerm1;
        }

        return new RepTerm1Eps();
    }

    private IConcSyn repTerm2() throws GrammarError {
        if (terminal == Terminal.RELOPR){
            System.out.println("expr := optTerm2");
            TokenTupel relOpr = (TokenTupel) consume(Terminal.RELOPR);
            Term2 term2 = (Term2) term2();
            RepTerm2 repTerm2 = new RepTerm2(relOpr, term2);
            RepTerm2 next = (RepTerm2) repTerm2();
            repTerm2.setNext(next);
            return repTerm2;
        }
        return new RepTerm2Eps();
    }

    private IConcSyn term1() throws GrammarError {
        System.out.println("expr := term1");
        Term2 term2 = (Term2) term2();
        RepTerm2 repTerm2 = (RepTerm2) repTerm2();
        return new Term1(term2, repTerm2);
    }

    private IConcSyn term2() throws GrammarError {
        System.out.println("expr := term2");
        Term3 term3 = (Term3) term3();
        RepTerm3 repTerm3 = (RepTerm3) repTerm3();
        return new Term2(term3, repTerm3);
    }

    private IConcSyn repTerm3() throws GrammarError {
        if (terminal == Terminal.ADDOPR) {
            System.out.println("expr := repTerm3");
            TokenTupel addOpr = (TokenTupel) consume(Terminal.ADDOPR);
            Term3 term3 = (Term3) term3();
            RepTerm3 repTerm3 = new RepTerm3(addOpr, term3);
            RepTerm3 next = (RepTerm3) repTerm3();
            repTerm3.setNext(next);
            return repTerm3;
        }
        return new RepTerm3Eps();
    }

    private IConcSyn term3() throws GrammarError {
        System.out.println("expr := term3");
        AbstractFactor factor = (AbstractFactor) factor();
        RepFactor repFactor = (RepFactor) repFactor();
        return new Term3(factor, repFactor);
    }

    private IConcSyn repFactor() throws GrammarError {
        if (terminal == Terminal.MULTOPR) {
            System.out.println("expr := repFactor");
            consume(Terminal.MULTOPR);
            AbstractFactor factor = (AbstractFactor) factor();
            RepFactor repFactor = new RepFactor(factor);
            RepFactor next = (RepFactor) repFactor();
            repFactor.setNext(next);
            return repFactor;
        }
        return new RepFactorEps();
    }

    private IConcSyn factor() throws GrammarError {
        switch (terminal) {
            case LITERAL:
                System.out.println("factor := LITERAL");
                TokenTupel literal = (TokenTupel) consume(Terminal.LITERAL);
                return new FactorLiteral(literal);

            case IDENT:
                System.out.println("factor := IDENT");
                TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
                IConcSyn.IExprList optInitOrExprList = (IConcSyn.IExprList) optInitOrExprList();
                return new FactorIdent(ident, (OptInitOrExprList) optInitOrExprList);

            case LPAREN:
                System.out.println("factor := LPAREN");
                consume(Terminal.LPAREN);
                Expr expr = (Expr) expr();
                consume(Terminal.RPAREN);
                return new FactorParen(expr);

            case NOT:
                System.out.println("factor := NOT(monadicOpr)");
                MonadicOpr monadicOpr = (MonadicOpr) monadicOpr();
                AbstractFactor factor = (AbstractFactor) factor();
                FactorMonadic factorMonadic = new FactorMonadic(monadicOpr, factor);
                return factorMonadic;

            case ADDOPR:
                System.out.println("factor := ADD(monadicOpr)");
                monadicOpr = (MonadicOpr) monadicOpr();
                factor = (AbstractFactor) factor();
                factorMonadic = new FactorMonadic(monadicOpr, factor);
                return factorMonadic;

			case DOT:
				return recordFactor();

            default:
                throw new GrammarError("factor()", 0);
        }
    }

    private IConcSyn optInitOrExprList() throws GrammarError {
		if (terminal == Terminal.INIT) {
			System.out.println("optInitOrExprList := INIT");
			consume(Terminal.INIT);
			return new OptInitOrExprList(null);
		} else if (terminal == Terminal.LPAREN) {
			return new OptInitOrExprList((ExprList) exprList());
		} else
			return new OptInitOrExprListEps();
    }

    private IConcSyn exprList() throws GrammarError {
        System.out.println("exprList");
        consume(Terminal.LPAREN);
        OptExprRep optExprRep = (OptExprRep) optExprRep();
        consume(Terminal.RPAREN);
        return new ExprList(optExprRep);
    }

    private IConcSyn optExprRep() throws GrammarError {
        System.out.println("exprList optExprRep");
        Expr expr;
        try {
            expr = (Expr) expr();
        } catch (GrammarError e) {
            return new OptExprRepEps();
        }
        RepCommaExpr repCommaExpr = (RepCommaExpr) repCommaExpr();
        return new OptExprRep(expr, repCommaExpr);
    }

    private IConcSyn repCommaExpr() throws GrammarError {
        if (terminal == Terminal.COMMA) {
            System.out.println("exprList optExprRep repCommaExpr");
            consume(Terminal.COMMA);
            Expr expr = (Expr) expr();
            RepCommaExpr repCommaExpr = new RepCommaExpr(expr);
            RepCommaExpr next = (RepCommaExpr) repCommaExpr();
            repCommaExpr.setNext(next);
            return repCommaExpr;
        }
        return new RepCommaExprEps();
    }

    private IConcSyn monadicOpr() throws GrammarError {
        System.out.println("monadicOpr");
        if (terminal == Terminal.ADDOPR) {
            TokenTupel operator = (TokenTupel) consume(Terminal.ADDOPR);
            return new MonadicOpr(operator);
        }
        else
            throw new GrammarError("monadicOpr", 0);

    }

	private IConcSyn recordDecl() throws GrammarError {
		consume(Terminal.REC);
		System.out.println("recordDecl");
		
		TokenTupel recident = (TokenTupel) consume(Terminal.RECIDENT);
		consume(Terminal.COLON);
		consume(Terminal.LCURL);
		RecordData recordData = (RecordData) recordData();
		consume(Terminal.RCURL);
		return new RecordDecl(recident, recordData);
	}

	private IConcSyn recordData() throws GrammarError {
		System.out.println("recordData");
		OptChangeMode opCM = (OptChangeMode) optChangeMode();
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		consume(Terminal.TYPE);
		RepRecordData repRecordData = (RepRecordData) repRecordData();
		return new RecordData(ident, repRecordData, opCM);
	}

	private IConcSyn repRecordData() throws GrammarError {
		RepRecordData head = null, current;
		while (terminal == Terminal.COMMA) {
			consume(Terminal.COMMA);
			OptChangeMode opc = (OptChangeMode) optChangeMode();
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			consume(Terminal.COLON);
			consume(Terminal.TYPE);
			current = new RepRecordData(ident,opc);

            if (head == null)
                head = current;
            else {
                head.setNext(current);
            }
		}

		return head;
	}

	private IConcSyn recordFactor() throws GrammarError {
		System.out.println("recordFactor");
		consume(Terminal.DOT);
		TokenTupel ident1 = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.DOT);
		TokenTupel ident2 = (TokenTupel) consume(Terminal.IDENT);
		return new RecordFactor(ident1, ident2);
	}



}
