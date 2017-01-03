package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.parser.concSynTree.*;
import ch.fhnw.compiler.error.*;
import ch.fhnw.compiler.scanner.data.ITokenList;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import com.sun.org.apache.regexp.internal.RE;

import java.awt.color.ICC_ColorSpace;


public class Parser implements IParser {

	private ITokenList tokenList;
	private Token token;
	private Terminal terminal;
	private ConcSyn concSyn;
	
	public Parser(ITokenList tl){
	this.tokenList=tl;
	this.tokenList.reset();
	
	token = tokenList.nextToken();
	terminal = token.getTerminal();
	concSyn = new ConcSyn();
	}

	private Token consume(Terminal expectedTerm) throws ch.fhnw.compiler.error.GrammarError{

		if(terminal==expectedTerm){
			Token consumedToken = token;
			if(terminal!=Terminal.SENTINEL){
				token = tokenList.nextToken();
				terminal = token.getTerminal();
			}
			return consumedToken;
		}else{
			throw new ch.fhnw.compiler.error.GrammarError(terminal,expectedTerm);
		}
	}
	
	@Override
	public Program parse() throws ch.fhnw.compiler.error.GrammarError {
		// TODO Auto-generated method stub
		
		Program program = program();
		consume(Terminal.SENTINEL);
		return program;

	}
	
	private Program program() throws ch.fhnw.compiler.error.GrammarError{
		// TODO Auto-generated method stub
			consume(Terminal.PROGRAM);
			Token t =consume(Terminal.IDENT);
			//FOR next ones we need the wrappers.
			
			
		
		throw new ch.fhnw.compiler.error.GrammarError(terminal,Terminal.PROGRAM);
	}
	
	private IConcSynWrapper decl() throws GrammarError {
		switch(terminal) {
			case FUN:
				System.out.println("decl ::= funDecl");
				return funDecl();
				break;
			case PROC:
				System.out.println("decl ::= procDecl");
				return procDecl();
				break;
			case CHANGEMODE:
			case IDENT:
				System.out.println("decl ::= storeDecl");
				return storeDecl();
				break;
			default:
				throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
				break;
		}
	}
	
	
	private IConcSynWrapper stoDecl() throws GrammarError {
		switch(terminal) {
		case REC: System.out.println("stoDecl ::= recordDecl");
		return recordDecl();
		break;
		default: System.out.println("stoDecl ::= OptChangeMode Ident");
		OptChangeMode optChangeMode = optChangeMode();
		TypedIdent ident = typedIdent();
		return new StoDecl(optChangeMode,ident);
		break;
		}
	}
	
	
	private IConcSynWrapper funDecl() throws ch.fhnw.compiler.error.GrammarError{
		switch(terminal){
		case FUN:
			System.out.println("funDecl ::= FUN ident ParamList Returns StoDecl OptGlobalglobImps OptLocalcpsStoDecl");
			consume(Terminal.FUN);
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			ParamList paramList = paramList();
			consume(Terminal.RETURNS);
			StoDecl stoDecl = stoDecl();
			OptGlobalglobImps optGlobalglobImps = optGlobalglobImps();
			OptLocalcpsStoDecl optLocalcpsStoDecl = optLocalcpsStoDecl();
			consume(Terminal.DO);
			CpsCmd cpsCmd = cpsCmd();
			consume(Terminal.ENDFUN);
			
			return new FunDecl(ident, paramList, optGlobalglobImps, optLocalcpsStoDecl, cpsCmd);
			break;
			
		default: throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
		}
	}

	private IConcSynWrapper cmd() throws GrammarError {
		AbstractCmd result = null;
        switch (terminal) {
            case SKIP:
                System.out.println("cmd ::= SKIP");
                consume(Terminal.SKIP);
				result = new CmdSkip();
				break;

			case IF:
				System.out.println("cmd ::= IF");
				consume(Terminal.IF);
				Expr expr = expr();
				consume(Terminal.THEN);
				CpsCmd cpsCmd1 = cpsCmd();
				consume(Terminal.ELSE);
				CpsCmd cpsCmd2 = cpsCmd();
				consume(Terminal.ENDIF);
				result = new CmdIf(expr, cpsCmd1, cpsCmd2);
				break;

			case WHILE:
				System.out.println("cmd ::= WHILE");
				consume(Terminal.WHILE);
				expr = expr();
				consume(Terminal.DO);
				CpsCmd cpsCmd = cpsCmd();
				consume(Terminal.ENDWHILE);
				result = new CmdWhile(expr, cpsCmd);
				break;

			case CALL:
				System.out.println("cmd ::= CALL");
				consume(Terminal.CALL);
				TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
				ExprList exprList = exprList();
				OptGlobInits optGlobInits = optGlobInits();
				result = new CmdCall(ident, exprList, optGlobInits);
				break;

			case DEBUGIN:
				System.out.println("cmd ::= DEBUGIN");
				consume(Terminal.DEBUGIN);
				expr = expr();
				result = new CmdDebugIn(expr);
				break;

			case DEBUGOUT:
				System.out.println("cmd ::= DEBUGOUT");
				consume(Terminal.DEBUGOUT);
				expr = expr();
				result = new CmdDebugOut(expr);
				break;

			default:
			//TODO recident case; recidents in scanner????
				System.out.println("cmd ::= RECIDENT");
				ident = (TokenTupel) consume(Terminal.IDENT);
				consume(Terminal.BECOMES);
				consume(Terminal.LPAREN);
				IConcSynWrapper recconstr = recConstr();
				consume(Terminal.RPAREN);
		}
		return result;
    }

    private IConcSynWrapper recConstr() throws GrammarError {
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

	private IConcSynWrapper repCommaIdentLiteral() throws GrammarError {
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

	private IConcSynWrapper optGlobInits() throws GrammarError {
		if (terminal == Terminal.INIT) {
            GlobInits globInits = (GlobInits) globInits();
			return new OptGlobInits(globInits);
		} else
			return null;//OptGlobInitsEpsilon()
	}

    private IConcSynWrapper cpsCmd() throws GrammarError {
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

    private IConcSynWrapper globInits() throws GrammarError {
        System.out.println("globInits");
        consume(Terminal.INIT);
        Idents idents = (Idents) idents();
        return new GlobInits(idents);
    }

    private IConcSynWrapper idents() throws GrammarError {
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

    private IConcSynWrapper expr() throws GrammarError {
        System.out.println("expr");
        Term1 term1 = (Term1) term1();
        RepTerm1 repTerm1 = (RepTerm1) repTerm1();
        return new Expr(term1, repTerm1);
    }

    private IConcSynWrapper repTerm1() throws GrammarError {
        if(terminal == Terminal.BOOLOPR) {
            System.out.println("expr := repterm1");
            consume(Terminal.BOOLOPR);
            Term1 term1 = (Term1) term1();
            RepTerm1 repTerm1 = new RepTerm1(term1);
            RepTerm1 next = (RepTerm1) repTerm1();
            repTerm1.setNext(next);
            return repTerm1;
        }

        return null;
    }

    private IConcSynWrapper optTerm2() throws GrammarError {
        if (terminal == Terminal.RELOPR){
            System.out.println("expr := optTerm2");
            consume(Terminal.RELOPR);
            Term2 term2 = (Term2) term2();
            return new OptTerm2(term2);
        }
        return null;
    }

    private IConcSynWrapper term1() throws GrammarError {
        System.out.println("expr := term1");
        Term2 term2 = (Term2) term2();
        OptTerm2 optTerm2 = (OptTerm2) optTerm2();
        return new Term1(term2, optTerm2);
    }

    private IConcSynWrapper term2() throws GrammarError {
        System.out.println("expr := term2");
        Term3 term3 = (Term3) term3();
        RepTerm3 repTerm3 = (RepTerm3) repTerm3();
        return new Term2(term3, repTerm3);
    }

    private IConcSynWrapper repTerm3() throws GrammarError {
        if (terminal == Terminal.ADDOPR) {
            System.out.println("expr := repTerm3");
            consume(Terminal.ADDOPR);
            Term3 term3 = (Term3) term3();
            RepTerm3 repTerm3 = new RepTerm3(term3);
            RepTerm3 next = (RepTerm3) repTerm3();
            repTerm3.setNext(next);
            return repTerm3;
        }
        return null;
    }

    private IConcSynWrapper term3() throws GrammarError {
        System.out.println("expr := term3");
        AbstractFactor factor = (AbstractFactor) factor();
        RepFactor repFactor = (RepFactor) repFactor();
        return new Term3(factor, repFactor);
    }

    private IConcSynWrapper repFactor() throws GrammarError {
        if (terminal == Terminal.MULTOPR) {
            System.out.println("expr := repFactor");
            consume(Terminal.MULTOPR);
            AbstractFactor factor = (AbstractFactor) factor();
            RepFactor repFactor = new RepFactor(factor);
            RepFactor next = (RepFactor) repFactor();
            repFactor.setNext(next);
            return repFactor;
        }
        return null;
    }

    private IConcSynWrapper factor() throws GrammarError {
        switch (terminal) {
            case LITERAL:
                System.out.println("factor := LITERAL");
                TokenTupel literal = (TokenTupel) consume(Terminal.LITERAL);
                return new FactorLiteral(literal);

            case IDENT:
                System.out.println("factor := IDENT");
                TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
                return new FactorLiteral(ident);

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

            default:
                throw new GrammarError("factor()", 0);
        }
    }

    private IConcSynWrapper exprList() throws GrammarError {
        System.out.println("exprList");
        consume(Terminal.LPAREN);
        OptExprRep optExprRep = optExprRep();
        consume(Terminal.RPAREN);
        return new ExprList(optExprRep);
    }

    private OptExprRep optExprRep() throws GrammarError {
        System.out.println("exprList optExprRep");
        Expr expr;
        try {
            expr = (Expr) expr();
        } catch (GrammarError e) {
            return null;
        }
        RepCommaExpr repCommaExpr = (RepCommaExpr) repCommaExpr();
        return new OptExprRep(expr, repCommaExpr);
    }

    private IConcSynWrapper repCommaExpr() throws GrammarError {
        if (terminal == Terminal.COMMA) {
            System.out.println("exprList optExprRep repCommaExpr");
            consume(Terminal.COMMA);
            Expr expr = (Expr) expr();
            RepCommaExpr repCommaExpr = new RepCommaExpr(expr);
            RepCommaExpr next = (RepCommaExpr) repCommaExpr();
            return repCommaExpr;
        }
        return null;
    }

    private IConcSynWrapper monadicOpr() throws GrammarError {
        System.out.println("monadicOpr");
        if (terminal == Terminal.NOT) {
            return new MonadicOpr(Terminal.NOT);
        } else if (terminal == Terminal.ADDOPR) {
            return new MonadicOpr(Terminal.ADDOPR);
        } else
            throw new GrammarError("monadicOpr", 0);

    }

	private IConcSynWrapper recordDecl() throws GrammarError {
		System.out.println("recordDecl");
		consume(Terminal.REC);
		TokenTupel recident = consume(Terminal.RECIDENT);
		consume(Terminal.COLON);
		consume(Terminal.LCURL);
		RecordData recordData = (RecordData) recordData();
		consume(Terminal.RCURL);
		return new RecordDecl(recident, recordData);
	}

	private IConcSynWrapper recordData() throws GrammarError {
		System.out.println("recordData");
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		consume(Terminal.TYPE);
		RepRecordData repRecordData = (RepRecordData) repRecordData();
		return new RecordData(ident, repRecordData);
	}

	private IConcSynWrapper repRecordData() throws GrammarError {
		RepRecordData head = null, current = null;
		while (terminal == Terminal.COMMA) {
			consume(Terminal.COMMA);
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			consume(Terminal.COLON);
			consume(Terminal.TYPE);
			current = new RepRecordData(ident);
		}

		if (head == null)
			head = current;
		else
			head.setNext(current);

		return head;
	}

	private IConcSynWrapper recordFactor() throws GrammarError {
		System.out.println("recordFactor");
		consume(Terminal.DOT);
		TokenTupel ident1 = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.DOT);
		TokenTupel ident2 = (TokenTupel) consume(Terminal.IDENT);
		return new RecordFactor(ident1, ident2);
	}



}
