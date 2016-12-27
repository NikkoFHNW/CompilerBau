package ch.fhnw.compiler.parserNew;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parserNew.ConcTree.*;


//import ch.fhnw.cpib.compiler.error.GrammarError;
//import ch.fhnw.cpib.compiler.parser.ConcTree.*;
//import ch.fhnw.cpib.compiler.scanner.IToken;
//import ch.fhnw.cpib.compiler.scanner.ITokenList;
//import ch.fhnw.cpib.compiler.scanner.enums.Terminal;
//import ch.fhnw.cpib.compiler.scanner.token.*;

import ch.fhnw.compiler.scanner.*;
import ch.fhnw.compiler.scanner.data.*;


public class Parser {

	private final ITokenList tokenList;
	private Token token;
	private Terminal terminal;
	
	public Parser(final ITokenList tokenList){
		this.tokenList = tokenList;
		this.tokenList.reset();
		
		// precondition: token list contains at least the SENTINEL 
		token= tokenList.nextToken();
		// establish class invariant
		terminal= token.getTerminal();
	}
	
	private Token consume(Terminal expectedTerminal) throws GrammarError {
		if (terminal == expectedTerminal) {
			final Token consumedToken = token;
			if (terminal != Terminal.SENTINEL) {
				token = tokenList.nextToken();
				// maintain class invariant
				terminal = token.getTerminal();
			}
			return consumedToken;
		} else {
//			throw new GrammarError("terminal expected: " + expectedTerminal + ", terminal found: " + terminal, token.getLine());
			throw new GrammarError("terminal expected: " + expectedTerminal + ", terminal found: " + terminal, 0);
		}

	}
	
	public ConcTree.Program parse() throws GrammarError {
		ConcTree.Program program = program();
		consume(Terminal.SENTINEL);
		return program;
	}
	
	private ConcTree.Program program() throws GrammarError {
		System.out.println("program ::= PROGRAM IDENT programParameterList optionalGlobalDeclarations DO blockCmd ENDPROGRAM");
		consume(Terminal.PROGRAM);
//		Ident ident = (Ident) consume(Terminal.IDENT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		ConcTree.ProgramParameterList programParameterList = programParameterList();
		ConcTree.OptionalGlobalDeclarations optionalGlobalDeclarations = optionalGlobalDeclarations();
		consume(Terminal.DO);
		ConcTree.BlockCmd blockCmd = blockCmd();
		consume(Terminal.ENDPROGRAM);
		return new ConcTree.Program(ident, programParameterList, optionalGlobalDeclarations, blockCmd);
	}
	
	private ConcTree.OptionalGlobalDeclarations optionalGlobalDeclarations() throws GrammarError{
		if (terminal == Terminal.GLOBAL) {
			System.out.println("optionalGlobalDeclarations ::= GLOBAL declarations");
			consume(Terminal.GLOBAL);
			return new ConcTree.OptionalGlobalDeclarations(declarations());
		} else {
			System.out.println("optionalGlobalDeclarations ::= epsilon");
			return new ConcTree.OptionalGlobalDeclarationsEpsilon();
		}
		
	}
	private ConcTree.Declarations declarations() throws GrammarError{
		System.out.println("declarations ::= declaration repeatingOptionalDeclarations");
		ConcTree.Declaration declaration = declaration();
		ConcTree.RepeatingOptionalDeclarations repeatingOptionalDeclarations = repeatingOptionalDeclarations();
		return new ConcTree.Declarations(declaration, repeatingOptionalDeclarations);
		
	}
	private ConcTree.RepeatingOptionalDeclarations repeatingOptionalDeclarations() throws GrammarError {
		if(terminal == Terminal.SEMICOLON){
			System.out.println("repeatingOptionalDeclarations ::= SEMICOLON declaration repeatingOptionalDeclarations");
			consume(Terminal.SEMICOLON);
			Declaration declaration = declaration();
			RepeatingOptionalDeclarations repeatingOptionalDeclarations = repeatingOptionalDeclarations();
			return new ConcTree.RepeatingOptionalDeclarations(declaration, repeatingOptionalDeclarations);
		}else{
			System.out.println("repeatingOptionalDeclarations ::= epsilon");
			return new ConcTree.RepeatingOptionalDeclarationsEpsilon();
		}
	}
	
	private ConcTree.Declaration declaration() throws GrammarError {
		switch(terminal) {
			case FUN:
				System.out.println("declaration ::= functionDeclaration");
				return functionDeclaration();
			case PROC:
				System.out.println("declaration ::= procedureDeclaration");
				return procedureDeclaration();
			case REC:
				System.out.println("declaration ::= recordDeclaration");
				return recordDeclaration();
			case CHANGEMODE:
			case IDENT:
				System.out.println("declaration ::= storageDeclaration");
				return storageDeclaration();
			default:
//				throw new GrammarError("declaration got " + terminal, token.getLine());
				throw new GrammarError("declaration got " + terminal, 0);
		}
	}
	
	private ConcTree.RecordDeclaration recordDeclaration() throws GrammarError{
		System.out.println("recordDeclaration ::= REC IDENT recordFieldList");
		consume(Terminal.REC);
//		Ident ident = (Ident) consume(Terminal.IDENT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		RecordFieldList recordFieldList = recordFieldList();
		return new ConcTree.RecordDeclaration(ident, recordFieldList);
	}
	
	private ConcTree.RecordFieldList recordFieldList() throws GrammarError{
		System.out.println("recordFieldList ::= LPAREN recordFieldDeclaration repeatingOptionalRecordFieldDeclaration RPAREN");
		consume(Terminal.LPAREN);
		RecordFieldDeclaration recordFieldDeclaration = recordFieldDeclaration();
		RepeatingOptionalRecordFieldDeclarations repeatingOptionalRecordFieldDeclarations = repeatingOptionalRecordFieldDeclarations();
		consume(Terminal.RPAREN);
		return new RecordFieldList(recordFieldDeclaration, repeatingOptionalRecordFieldDeclarations);
	}
	
	private ConcTree.RecordFieldDeclaration recordFieldDeclaration() throws GrammarError {
		System.out.println("recordFieldDeclaration ::= optionalChangeMode typedIdent");
		ConcTree.OptionalChangeMode optionalChangeMode = optionalChangeMode();
		ConcTree.TypedIdent typedIdent = typedIdent();
		return new ConcTree.RecordFieldDeclaration(optionalChangeMode, typedIdent);
	}
	
	private ConcTree.RepeatingOptionalRecordFieldDeclarations repeatingOptionalRecordFieldDeclarations() throws GrammarError {
		if(terminal == Terminal.SEMICOLON){
			System.out.println("repeatingOptionalRecordFieldDeclarations ::= SEMICOLON recordFieldDeclaration repeatingOptionalRecordFieldDeclarations");
			consume(Terminal.SEMICOLON);
			RecordFieldDeclaration recordFieldDeclaration = recordFieldDeclaration();
			RepeatingOptionalRecordFieldDeclarations repeatingOptionalRecordFieldDeclarations = repeatingOptionalRecordFieldDeclarations();
			return new RepeatingOptionalRecordFieldDeclarations(recordFieldDeclaration, repeatingOptionalRecordFieldDeclarations);
		} else {
			System.out.println("RepeatingOptionalRecordFieldDeclarations ::= epsilon");
			return new RepeatingOptionalRecordFieldDeclarationsEpsilon();
		}
	}
	
	private ConcTree.RepeatingOptionalStorageDeclarations repeatingOptionalStorageDeclarations() throws GrammarError {
		if(terminal == Terminal.SEMICOLON){
			System.out.println("repeatingOptionalStorageDeclarations ::= SEMICOLON storageDeclaration repeatingOptionalStorageDeclarations");
			consume(Terminal.SEMICOLON);
			StorageDeclaration storageDeclaration = storageDeclaration();
			RepeatingOptionalStorageDeclarations repeatingOptionalStorageDeclarations = repeatingOptionalStorageDeclarations();
			return new RepeatingOptionalStorageDeclarations(storageDeclaration, repeatingOptionalStorageDeclarations);
		} else {
			System.out.println("RepeatingOptionalStorageDeclarations ::= epsilon");
			return new RepeatingOptionalStorageDeclarationsEpsilon();
		}
	}
	
	private ConcTree.StorageDeclaration storageDeclaration() throws GrammarError {
		System.out.println("storageDeclaration ::= optionalChangeMode typedIdent");
		ConcTree.OptionalChangeMode optionalChangeMode = optionalChangeMode();
		ConcTree.TypedIdent typedIdent = typedIdent();
		return new ConcTree.StorageDeclaration(optionalChangeMode, typedIdent);
	}

	private ConcTree.FunctionDeclaration functionDeclaration() throws GrammarError {
		System.out.println("funDecl ::= FUN IDENT parameterList RETURNS storageDeclaration optionalGlobalImports optionalLocalStorageDeclarations DO blockCmd ENDFUN");
		consume(Terminal.FUN);
//		Ident ident = (Ident) consume(Terminal.IDENT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		
		
		ConcTree.ParameterList parameterList = parameterList();
		consume(Terminal.RETURNS);
		ConcTree.StorageDeclaration storeDecl = storageDeclaration();
		ConcTree.OptionalGlobalImports optionalGlobalImports = optionalGlobalImports();
		ConcTree.OptionalLocalStorageDeclarations optionalLocalStorageDeclarations = optionalLocalStorageDeclarations();
		consume(Terminal.DO);
		ConcTree.BlockCmd blockCmd = blockCmd();
		consume(Terminal.ENDFUN);
		return new ConcTree.FunctionDeclaration(ident, parameterList, storeDecl, optionalGlobalImports, optionalLocalStorageDeclarations, blockCmd);
	}
	private ConcTree.ParameterList parameterList() throws GrammarError {
		System.out.println("parameterList ::= LPAREN optionalParameters RPAREN");
		consume(Terminal.LPAREN);
		OptionalParameters optionalParameters = optionalParameters();
		consume(Terminal.RPAREN);
		return new ParameterList(optionalParameters);
	}
	private ConcTree.OptionalParameters optionalParameters() throws GrammarError {
		if(terminal == Terminal.CHANGEMODE || terminal == Terminal.MECHMODE || terminal == Terminal.FLOWMODE || terminal == Terminal.IDENT){
			System.out.println("optionalParameters ::= parameter repeatingOptionalParameters");
			Parameter parameter = parameter();
			RepeatingOptionalParameters repeatingOptionalParameters = repeatingOptionalParameters();
			return new OptionalParameters(parameter, repeatingOptionalParameters);
		} else {
			System.out.println("optionalParameters ::= epsilon");
			return new ConcTree.OptionalParametersEpsilon();
		}
	}
	private ConcTree.RepeatingOptionalParameters repeatingOptionalParameters() throws GrammarError {
		if(terminal == Terminal.COMMA){
			System.out.println("repeatingOptionalParameters ::= COMMA parameter repeatingOptionalParameters");
			consume(Terminal.COMMA);
			Parameter parameter = parameter();
			RepeatingOptionalParameters repeatingOptionalParameters = repeatingOptionalParameters();
			return new RepeatingOptionalParameters(parameter, repeatingOptionalParameters);
		} else {
			System.out.println("repeatingProgramParameters ::= epsilon");
			return new RepeatingOptionalParametersEpsilon();
		}
	}
	private ConcTree.ProcedureDeclaration procedureDeclaration() throws GrammarError {
		System.out.println("procedureDeclaration ::= PROC IDENT parameterList optionalGlobalDeclarations optionalLocalStorageDeclarations DO blockCmd ENDPROC");
		consume(Terminal.PROC);
//		Ident ident = (Ident) consume(Terminal.IDENT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		ConcTree.ParameterList parameterList = parameterList();
		ConcTree.OptionalGlobalImports optionalGlobalImports = optionalGlobalImports();
		ConcTree.OptionalLocalStorageDeclarations optionalLocalStorageDeclarations = optionalLocalStorageDeclarations();
		consume(Terminal.DO);
		ConcTree.BlockCmd blockCmd = blockCmd();
		consume(Terminal.ENDPROC);
		return new ConcTree.ProcedureDeclaration(ident, parameterList, optionalGlobalImports, optionalLocalStorageDeclarations, blockCmd);
	}

	private ConcTree.OptionalLocalStorageDeclarations optionalLocalStorageDeclarations() throws GrammarError {
		if (terminal == Terminal.LOCAL) {
			System.out.println("optionalLocalStorageDeclarations ::= LOCAL storageDeclaration repeatingOptionalStorageDeclarations");
			consume(Terminal.LOCAL);
			StorageDeclaration storageDeclaration = storageDeclaration();
			RepeatingOptionalStorageDeclarations repeatingOptionalStorageDeclarations = repeatingOptionalStorageDeclarations();
			return new ConcTree.OptionalLocalStorageDeclarations(storageDeclaration, repeatingOptionalStorageDeclarations);
		} else {
			System.out.println("optionalLocalStorageDeclarations ::= epsilon");
			return new ConcTree.OptionalLocalStorageDeclarationsEpsilon();
		}
	}

	//neu
	private ConcTree.ProgramParameterList programParameterList() throws GrammarError {
		System.out.println("programParameterList ::= LPAREN optionalProgramParameters RPAREN");
		consume(Terminal.LPAREN);
		ConcTree.OptionalProgramParameters optionalProgramParameters = optionalProgramParameters();
		consume(Terminal.RPAREN);
		return new ConcTree.ProgramParameterList(optionalProgramParameters);
	}

	private ConcTree.OptionalProgramParameters optionalProgramParameters() throws GrammarError {
		if (terminal != Terminal.RPAREN) {
			System.out.println("optionalProgramParameters ::= optionalFLOWMODE optionalCHANGEMODE, typedIdent, repeatingOptionalProgramParameters");
			ConcTree.OptionalFlowMode optionalFlowMode = optionalFlowMode();
			ConcTree.OptionalChangeMode optionalChangeMode = optionalChangeMode();
			ConcTree.TypedIdent typedIdent = typedIdent();
			ConcTree.RepeatingOptionalProgramParameters repeatingOptionalProgramParameters = repeatingOptionalProgramParameters();
			return new ConcTree.OptionalProgramParameters(optionalFlowMode, optionalChangeMode, typedIdent, repeatingOptionalProgramParameters);
		} else {
			System.out.println("optionalProgramParameters ::= epsilon");
			return new ConcTree.OptionalProgramParametersEpsilon();
		}
	}
	//neu
	private ConcTree.TypedIdent typedIdent() throws GrammarError{
		System.out.println("typedIdent ::= IDENT COLON typeDeclaration");
//		Ident ident = (Ident) consume(Terminal.IDENT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		TypeDeclaration typeDeclaration = typeDeclaration();
		return new ConcTree.TypedIdent(ident, typeDeclaration);
	}
	private ConcTree.TypeDeclaration typeDeclaration() throws GrammarError {
		if(terminal == Terminal.IDENT){
			System.out.println("typeDeclaration ::= IDENT");
//			Ident ident = (Ident) consume(Terminal.IDENT);
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			return new TypeDeclarationIdent(ident);
			
		} else if(terminal == Terminal.TYPE){
			System.out.println("typeDeclaration ::= TYPE");
//			Type type = (Type) consume(Terminal.TYPE);
			TokenTupel type = (TokenTupel) consume(Terminal.TYPE);
			return new TypeDeclarationType(type);
		} else {
//			throw new GrammarError("terminal expected: IDENT | TYPE, terminal found: " + terminal, token.getLine());
			throw new GrammarError("terminal expected: IDENT | TYPE, terminal found: " + terminal, 0);
		}
	}
	//neu
	private ConcTree.RepeatingOptionalProgramParameters repeatingOptionalProgramParameters() throws GrammarError {
		if (terminal == Terminal.COMMA) {
			System.out.println("repeatingOptionalProgramParameters ::= COMMA optionalFlowMode optionalChangeMode typedIdent repeatingOptionalProgramParameters");
			consume(Terminal.COMMA);
			ConcTree.OptionalFlowMode optionalFlowMode = optionalFlowMode();
			ConcTree.OptionalChangeMode optionalChangeMode = optionalChangeMode();
			ConcTree.TypedIdent typedIdent = typedIdent();
			ConcTree.RepeatingOptionalProgramParameters repeatingOptionalProgramParameters = repeatingOptionalProgramParameters();
			return new ConcTree.RepeatingOptionalProgramParameters(optionalFlowMode, optionalChangeMode, typedIdent, repeatingOptionalProgramParameters);
		} else {
			System.out.println("repeatingOptionalProgramParameters ::= epsilon");
			return new ConcTree.RepeatingOptionalProgramParametersEpsilon();
		}
	}

	private ConcTree.Parameter parameter() throws GrammarError {
		System.out.println("parameter ::= optionalFlowMode optionalMechMode optionalChangeMode typedIdent");
		ConcTree.OptionalFlowMode optionalFlowMode = optionalFlowMode();
		ConcTree.OptionalMechMode optionalMechMode = optionalMechMode();
		ConcTree.StorageDeclaration storageDeclaration = storageDeclaration();
		return new ConcTree.Parameter(optionalFlowMode, optionalMechMode, storageDeclaration);
	}

	private ConcTree.Cmd cmd() throws GrammarError {
		ConcTree.Cmd ret = null;
		
		switch (terminal) {
			case SKIP:
				System.out.println("cmd ::= SKIP");
				consume(Terminal.SKIP);
				ret = new ConcTree.CmdSkip();
				break;
			case IF:
				System.out.println("cmd ::= IF expression THEN blockCmd ELSE blockCmd ENDIF");
				consume(Terminal.IF);
				ConcTree.Expression ifExpression = expression();
				consume(Terminal.THEN);
				ConcTree.BlockCmd ifCmd = blockCmd();
				consume(Terminal.ELSE);
				ConcTree.BlockCmd elseCmd = blockCmd();
				consume(Terminal.ENDIF);
				ret = new ConcTree.CmdIf(ifExpression, ifCmd, elseCmd);
				break;
			case CALL:
				System.out.println("cmd ::= CALL IDENT expressionList optionalGlobalInits");
				consume(Terminal.CALL);
//				Ident ident = (Ident) consume(Terminal.IDENT);
				TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
				ConcTree.ExpressionList expressionList = expressionList();
				ConcTree.OptionalGlobalInits optionalGlobalInits = optionalGlobalInits();
				ret = new ConcTree.CmdCall(ident, expressionList,optionalGlobalInits);
				break;
			case WHILE:
				System.out.println("cmd ::= WHILE expression DO blockCmd ENDWHILE");
				consume(Terminal.WHILE);
				ConcTree.Expression whileExpr = expression();
				consume(Terminal.DO);
				ConcTree.BlockCmd whileCmd = blockCmd();
				consume(Terminal.ENDWHILE);
				ret =  new ConcTree.CmdWhile(whileExpr, whileCmd);
				break;
			case DEBUGIN:
				System.out.println("cmd ::= DEBUGIN expression");
				consume(Terminal.DEBUGIN);
				ConcTree.Expression debugInExpression = expression();
				ret = new ConcTree.CmdDebugIn(debugInExpression);
				break;
			case DEBUGOUT:
				System.out.println("cmd ::= DEBUGOUT expression");
				consume(Terminal.DEBUGOUT);
				ConcTree.Expression debugOutExpression = expression();
				ret = new ConcTree.CmdDebugOut(debugOutExpression);
				break;
			case IDENT:
				System.out.println("cmd ::= expression BECOMES expression");
				ConcTree.Expression expression = expression();
				consume(Terminal.BECOMES);
				ConcTree.Expression nextExpression = expression();
				ret = new ConcTree.CmdExpression(expression, nextExpression);
				break;
			default:
//				throw new GrammarError("terminal expected: SKIP | IF | CALL | WHILE | DEBUGIN | DEBUGOUT | IDENT, terminal found: " + terminal + " in a command", token.getLine());
				throw new GrammarError("terminal expected: SKIP | IF | CALL | WHILE | DEBUGIN | DEBUGOUT | IDENT, terminal found: " + terminal + " in a command", 0);
		}
		return ret;
	}

	private ConcTree.BlockCmd blockCmd() throws GrammarError {
		System.out.println("blockCmd ::= cmd repeatingOptionalCmds");
		ConcTree.Cmd cmd = cmd();
		ConcTree.RepeatingOptionalCmds repeatingOptionalCmds = repeatingOptionalCmds();
		return new ConcTree.BlockCmd(cmd, repeatingOptionalCmds);
	}

	private ConcTree.RepeatingOptionalCmds repeatingOptionalCmds() throws GrammarError {
		if (terminal == Terminal.SEMICOLON) {
			System.out.println("repCmd ::= SEMICOLON cmd repeatingOptionalCmds");
			consume(Terminal.SEMICOLON);
			ConcTree.Cmd cmd = cmd();
			ConcTree.RepeatingOptionalCmds repeatingOptionalCmds = repeatingOptionalCmds();
			return new ConcTree.RepeatingOptionalCmds(cmd, repeatingOptionalCmds);
		} else {
			System.out.println("repeatingCmds ::= epsilon");
			return new ConcTree.RepeatingCmdsEpsilon();
		}
	}

	private ConcTree.OptionalGlobalInits optionalGlobalInits() throws GrammarError {
		if (terminal == Terminal.INIT) {
			System.out.println("optionalGlobalInits ::= INIT idents");
			consume(Terminal.INIT);
			ConcTree.Idents idents = idents();
			return new ConcTree.OptionalGlobalInits(idents);
		} else {
			System.out.println("optionalGlobalInits ::= epsilon");
			return new ConcTree.OptionalGlobalInitsEpsilon();
		}
	}

	private ConcTree.Idents idents() throws GrammarError {
		System.out.println("idents ::= IDENT repeatingOptionalIdents");
//		Ident ident = (Ident) consume(Terminal.IDENT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		ConcTree.RepeatingOptionalIdents repeatingOptionalIdents = repeatingOptionalIdents();
		return new ConcTree.Idents(ident, repeatingOptionalIdents);
	}

	private ConcTree.RepeatingOptionalIdents repeatingOptionalIdents() throws GrammarError {
		if (terminal != Terminal.COMMA) {
			System.out.println("repeatingOptionalIdents ::= epsilon");
			return new ConcTree.RepeatingOptionalIdentsEpsilon();
		} else {
			System.out.println("repeatingOptionalIdents ::= COMMA IDENT idents");
			consume(Terminal.COMMA);
//			Ident ident = (Ident) consume(Terminal.IDENT);
			TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
			ConcTree.Idents idents = idents();
			return new ConcTree.RepeatingOptionalIdents(ident, idents);
		}
	}

	private ConcTree.Expression expression() throws GrammarError {
		System.out.println("expression ::= term1 repBOOLOPRterm1");
		ConcTree.Term1 term1 = term1();
		ConcTree.RepBOOLOPRterm1 repBOOLOPRterm1 = repBOOLOPRterm1();
		return new ConcTree.Expression(term1, repBOOLOPRterm1);
	}

	private ConcTree.RepBOOLOPRterm1 repBOOLOPRterm1() throws GrammarError {
		if (terminal == Terminal.BOOLOPR) {
			System.out.println("repTerm1 ::= BOOLOPR term1 repBOOLOPRterm1");
//			Operator.BoolOpr boolOpr = (Operator.BoolOpr) consume(Terminal.BOOLOPR);
			TokenTupel boolOpr = (TokenTupel) consume(Terminal.BOOLOPR);
			ConcTree.Term1 term1 = term1();
			ConcTree.RepBOOLOPRterm1 repBOOLOPRterm1 = repBOOLOPRterm1();
			return new ConcTree.RepBOOLOPRterm1(boolOpr, term1, repBOOLOPRterm1);
		} else {
			System.out.println("repBOOLOPRterm1 ::= epsilon");
			return new ConcTree.RepBOOLOPRterm1Epsilon();
		}
	}

	private ConcTree.Term1 term1() throws GrammarError {
		System.out.println("term1 ::= term2 repRELOPRterm2");
		ConcTree.Term2 term2 = term2();
		ConcTree.RepRELOPRterm2 repRELOPRterm2 = repRELOPRterm2();
		return new ConcTree.Term1(term2, repRELOPRterm2);
	}

	private ConcTree.RepRELOPRterm2 repRELOPRterm2() throws GrammarError {
		if (terminal == Terminal.RELOPR){
			System.out.println("repRELOPRterm2 ::= RELOPR term2 repRELOPRterm2");
//			Operator.RelOpr relOpr = (Operator.RelOpr) consume(Terminal.RELOPR);
			TokenTupel relOpr = (TokenTupel) consume(Terminal.RELOPR);
			ConcTree.Term2 term2 = term2();
			ConcTree.RepRELOPRterm2 repRELOPRterm2 = new ConcTree.RepRELOPRterm2Epsilon();
			return new ConcTree.RepRELOPRterm2(relOpr, term2, repRELOPRterm2);
		} else {
			System.out.println("repRELOPRterm2 ::= epsilon");
			return new ConcTree.RepRELOPRterm2Epsilon();
		}
	}

	private ConcTree.Term2 term2() throws GrammarError {
		System.out.println("term2 ::= term3 repADDOPRterm3");
		ConcTree.Term3 term3 = term3();
		ConcTree.RepADDOPRterm3 repADDOPRterm3 = repADDOPRterm3();
		return new ConcTree.Term2(term3, repADDOPRterm3);
	}

	private ConcTree.RepADDOPRterm3 repADDOPRterm3() throws GrammarError {
		if (terminal == Terminal.ADDOPR) {
			System.out.println("repADDOPRterm3 ::= ADDOPR term3 repADDOPRterm3");
//			Operator.AddOpr addOpr = (Operator.AddOpr) consume(Terminal.ADDOPR);
			TokenTupel addOpr = (TokenTupel) consume(Terminal.ADDOPR);
			ConcTree.Term3 term3 = term3();
			ConcTree.RepADDOPRterm3 repADDOPRterm3 = repADDOPRterm3();
			return new ConcTree.RepADDOPRterm3(addOpr, term3, repADDOPRterm3);
		} else {
			System.out.println("repADDOPRterm3 ::= epsilon");
			return new ConcTree.RepADDOPRterm3Epsilon();
		}
	}

	private ConcTree.Term3 term3() throws GrammarError {
		
			System.out.println("term3 ::= factor repMultOpr");
			ConcTree.Factor factor = factor();
			ConcTree.RepMULTOPRfactor repMultOpr = repMultOprFactor();
			TokenTupel multopr = (TokenTupel) consume(Terminal.MULTOPR);
			return new ConcTree.Term3( factor, repMultOpr);
		

//		ConcTree.Term4 term4 = term4();
//		ConcTree.RepMULTOPRterm4 repMULTOPRterm4 = repMULTOPRterm4();
//		return new ConcTree.Term3(term4, repMULTOPRterm4);
	}
//	private ConcTree.RepMULTOPRterm4 repMULTOPRterm4() throws GrammarError{
//		if(terminal == Terminal.MULTOPR) {
//			System.out.println("repMULTOPRterm4 ::= MULTOPR term4 repMULTOPRterm4");
////			Operator.MultOpr multOpr = (Operator.MultOpr) consume(Terminal.MULTOPR);
//			TokenTupel multOpr = (TokenTupel) consume(Terminal.MULTOPR);
//			ConcTree.Term4 term4 = term4();
//			ConcTree.RepMULTOPRterm4 repMULTOPRterm4= repMULTOPRterm4();
//			return new ConcTree.RepMULTOPRterm4(multOpr, term4, repMULTOPRterm4);
//		} else{
//			System.out.println("repMULTOPRterm4 ::= epsilon");
//			return new ConcTree.RepMULTOPRterm4Epsilon();
//		}
//	}
//	private ConcTree.Term4 term4() throws GrammarError {
//		System.out.println("term4 ::= factor repDOTOPRfactor");
//		ConcTree.Factor factor = factor();
//		ConcTree.RepDOTOPRfactor repDOTOPRfactor = repDOTOPRfactor();
//		return new ConcTree.Term4(factor, repDOTOPRfactor);
//		
//	}
	
//	private ConcTree.RepDOTOPRfactor repDOTOPRfactor() throws GrammarError{
//		if(terminal == Terminal.DOTOPR){
//			System.out.println("repDOTOPRfactor ::= DOTOPR factor repDOTOPRfactor");
//			Operator.DotOpr dotOpr = (Operator.DotOpr) consume(Terminal.DOTOPR);
//			ConcTree.Factor factor = factor();
//			ConcTree.RepDOTOPRfactor repDOTOPRfactor = repDOTOPRfactor();
//			return new ConcTree.RepDOTOPRfactor(dotOpr, factor, repDOTOPRfactor);
//		} else {
//			System.out.println("repDOTOPRfactor ::= epsilon");
//			return new ConcTree.RepDOTOPRfactorEpsilon();
//		}
//	}


	private ConcTree.Factor factor() throws GrammarError {
		ConcTree.Factor ret = null;
		switch (terminal) {
			case LITERAL:
				System.out.println("factor ::= LITERAL");
				ret = new ConcTree.FactorLiteral((TokenTupel) consume(Terminal.LITERAL));
				break;
			case IDENT:
				System.out.println("factor ::= IDENT optionalIdent");
//				Ident ident = (Ident) consume(Terminal.IDENT);
				TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
				ConcTree.OptionalIdent optionalIdent = optionalIdent();
				ret = new ConcTree.FactorIdent(ident, optionalIdent);
				break;
			case LPAREN:
				System.out.println("factor ::= LPAREN expression RPAREN");
				consume(Terminal.LPAREN);
				ConcTree.Expression expression = expression();
				consume(Terminal.RPAREN);
				ret = new ConcTree.FactorExpression(expression);
				break;
			default:
				System.out.println("factor ::= monadicOperator factor");
				ConcTree.MonadicOperator monadicOperator = monadicOperator();
				ConcTree.Factor factor = factor();
				ret = new ConcTree.FactorMonadicOperator(monadicOperator, factor);
		}
		return ret;
	}

	private ConcTree.OptionalIdent optionalIdent() throws GrammarError {
		ConcTree.OptionalIdent ret = null;
		switch (terminal) {
			case INIT:
				System.out.println("optionalIdent ::= INIT");
				consume(Terminal.INIT);
				ret = new ConcTree.OptionalIdentInit();
				break;
			case LPAREN:
				System.out.println("optionalIdent ::= expressionList");
				ConcTree.ExpressionList expressionList = expressionList();
				ret = new ConcTree.OptionalIdentExpressionList(expressionList);
				break;
			default:
				System.out.println("optionalIdent::= epsilon");
				ret = new ConcTree.OptionalIdentEpsilon();
		}
		return ret;
	}

	private ConcTree.ExpressionList expressionList() throws GrammarError {
		System.out.println("expressionList ::= LPAREN optionalExpressions RPAREN");
		consume(Terminal.LPAREN);
		ConcTree.OptionalExpressions optionalExpressions = optionalExpressions();
		consume(Terminal.RPAREN);
		return new ConcTree.ExpressionList(optionalExpressions);
	}

	private ConcTree.OptionalExpressions optionalExpressions() throws GrammarError {
		if (terminal == Terminal.RPAREN) {
			System.out.println("optionalExpressions ::= epsilon");
			return new ConcTree.OptionalExpressionsEpsilon();
		} else {
			System.out.println("optionalExpressions ::= expression repeatingOptionalExpression");
			ConcTree.Expression expression = expression();
			ConcTree.RepeatingOptionalExpressions repeatingOptionalExpressions = repeatingOptionalExpressions();
			return new ConcTree.OptionalExpressions(expression, repeatingOptionalExpressions);
		}
	}

	private ConcTree.RepeatingOptionalExpressions repeatingOptionalExpressions() throws GrammarError {
		if (terminal != Terminal.COMMA) {
			System.out.println("repeatingOptionalExpressions ::= epsilon");
			return new ConcTree.RepeatingOptionalExpressionsEpsilon();
		} else {
			System.out.println("repeatingOptionalExpressions ::= COMMA expression optionalExpressions");
			consume(Terminal.COMMA);
			ConcTree.Expression expression = expression();
			ConcTree.RepeatingOptionalExpressions repeatingOptionalExpressions = repeatingOptionalExpressions();
			return new ConcTree.RepeatingOptionalExpressions(expression, repeatingOptionalExpressions);
		}
	}

	private ConcTree.MonadicOperator monadicOperator() throws GrammarError {
		ConcTree.MonadicOperator ret = null;
		switch (terminal) {
			case NOT:
				System.out.println("monadicOpr ::= NOT");
				ret = new ConcTree.MonadicOperator((TokenTupel) consume(Terminal.NOT));
				break;
			case ADDOPR:
				System.out.println("monadicOpr ::= ADDOPR");
				ret = new ConcTree.MonadicOperator((TokenTupel) consume(Terminal.ADDOPR));
				break;
			default:
//				throw new GrammarError("terminal expected: NOT | ADDOPR, terminal found: " + terminal, token.getLine());
				throw new GrammarError("terminal expected: NOT | ADDOPR, terminal found: " + terminal, 0);
		}
		return ret;
	}

	private ConcTree.OptionalMechMode optionalMechMode() throws GrammarError {
		ConcTree.OptionalMechMode ret = null;
		if (terminal == Terminal.MECHMODE) {
			System.out.println("optionalMechMode ::= MECHMODE");
			ret = new ConcTree.OptionalMechMode((TokenTupel) consume(Terminal.MECHMODE));
		} else {
			System.out.println("optionalMechMode ::= epsilon");
			ret = new ConcTree.OptionalMechModeEpsilon();
		}
		return ret;
	}

	private ConcTree.OptionalChangeMode optionalChangeMode() throws GrammarError {
		ConcTree.OptionalChangeMode ret = null;
		if (terminal == Terminal.CHANGEMODE) {
			System.out.println("optionalChangeMode ::= CHANGEMODE");
			ret = new ConcTree.OptionalChangeMode((TokenTupel) consume(Terminal.CHANGEMODE));
		} else {
			System.out.println("optionalChangeMode ::= epsilon");
			ret = new ConcTree.OptionalChangeModeEpsilon();
		}
		return ret;
	}

	private ConcTree.OptionalFlowMode optionalFlowMode() throws GrammarError {
		ConcTree.OptionalFlowMode ret = null;
		if (terminal == Terminal.FLOWMODE) {
			System.out.println("optionalFlowMode ::= FLOWMODE");
			ret = new ConcTree.OptionalFlowMode((TokenTupel) consume(Terminal.FLOWMODE));
		} else {
			System.out.println("optionalFlowMode ::= epsilon");
			ret = new ConcTree.OptionalFlowModeEpsilon();
		}
		return ret;
	}
	private ConcTree.OptionalGlobalImports optionalGlobalImports() throws GrammarError {
		if(terminal == Terminal.GLOBAL){
			System.out.println("optionalGlobalImports ::= GLOBAL globalImport repeatingGlobalImports");
			consume(Terminal.GLOBAL);
			GlobalImport globalImport = globalImport();
			RepeatingOptionalGlobalImports repeatingOptionalGlobalImports = repeatingOptionalGlobalImports();
			return new ConcTree.OptionalGlobalImports(globalImport, repeatingOptionalGlobalImports);
		}else {
			System.out.println("optionalGlobalImports :== espilon");
			return new ConcTree.OptionalGlobalImportsEpsilon();
		}
	}
	private ConcTree.GlobalImport globalImport() throws GrammarError {
		System.out.println("globalImport ::= optionalFLOWMODE optionalCHANGEMODE IDENT");
		OptionalFlowMode optionalFlowMode = optionalFlowMode();
		OptionalChangeMode optionalChangeMode = optionalChangeMode();
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		return new ConcTree.GlobalImport(optionalFlowMode, optionalChangeMode, ident);
	}
	private ConcTree.RepeatingOptionalGlobalImports repeatingOptionalGlobalImports() throws GrammarError {
		if(terminal == Terminal.COMMA){
			System.out.println("repeatingOptionalGlobalImports ::= COMMA globalImport repeatingOptionalGlobalImports");
			consume(Terminal.COMMA);
			GlobalImport globalImport = globalImport();
			RepeatingOptionalGlobalImports repeatingOptionalGlobalImports = repeatingOptionalGlobalImports();
			return new RepeatingOptionalGlobalImports(globalImport, repeatingOptionalGlobalImports);
		}else {
			System.out.println("repeatingOptionalGlobalImports ::= epsilon");
			return new RepeatingOptionalGlobalImportsEpsilon();
		}
	}
	
	private ConcTree.RepMULTOPRfactor repMultOprFactor() throws GrammarError{
		if(terminal == Terminal.MULTOPR){
			System.out.println("repMultOprFactor ::= MULTOPR Factor repMultOprFactor");
			TokenTupel multOpr = (TokenTupel)consume(Terminal.MULTOPR);
			Factor factor = factor();
			RepMULTOPRfactor repMultOprFactor = repMultOprFactor();
			
//			return new RepeatingOptionalGlobalImports(globalImport, repeatingOptionalGlobalImports);
			return new RepMULTOPRfactor(multOpr, factor, repMultOprFactor);
		}else {
			System.out.println("repMULTOPRFactor ::= epsilon");
//			return new RepeatingOptionalGlobalImportsEpsilon();
			return new RepMULTOPRfactorEpsilon();
		}
	}
	
}