package ch.fhnw.compiler.parser;

import ch.fhnw.compiler.parser.concSynTree.*;
import ch.fhnw.compiler.error.*;
import ch.fhnw.compiler.scanner.data.ITokenList;
import ch.fhnw.compiler.scanner.data.Terminal;
import ch.fhnw.compiler.scanner.data.Token;
import ch.fhnw.compiler.scanner.data.TokenTupel;


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
	
	
	private IConcSynWrapper decl() throws GrammarError {
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
			default:
				throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
		}
	}
	
	
	private IConcSynWrapper stoDecl() throws GrammarError {
		switch(terminal) {
		case REC: System.out.println("stoDecl ::= recordDecl");
		return recordDecl();
		break;
		default: System.out.println("stoDecl ::= OptChangeMode Ident");
		OptChangeMode optChangeMode = (OptChangeMode) optChangeMode();
		TypedIdent ident = (TypedIdent) typedIdent();
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
			ParamList paramList = (ParamList) paramList();
			consume(Terminal.RETURNS);
			StoDecl stoDecl = (StoDecl) stoDecl();
			OptGlobalglobImps optGlobalglobImps = (OptGlobalglobImps) optGlobalglobImps();
			OptLocalcpsStoDecl optLocalcpsStoDecl = (OptLocalcpsStoDecl) optLocalcpsStoDecl();
			consume(Terminal.DO);
			CpsCmd cpsCmd = cpsCmd();
			consume(Terminal.ENDFUN);
			
			return new FunDecl(ident, paramList, optGlobalglobImps, optLocalcpsStoDecl, cpsCmd);
			break;
			
		default: throw new ch.fhnw.compiler.error.GrammarError("decl got ",0);
		}
	}
	
	private IConcSynWrapper optGlobalcpsDecl() throws GrammarError{
		
		switch(terminal){
		case GLOBAL:
			consume(Terminal.GLOBAL);
			return cpsDecl();
//			CpsDecl cps = cpsDecl();
//			return new OptGlobalCpsDecl(global, cpsDecl);
			
		default: return null; //EPSILON
		
		}
		
	}
	
	private IConcSynWrapper optChangeMode() throws GrammarError{
		
		switch(terminal){
		case CHANGEMODE:
			
			return new OptChangeMode(consume(Terminal.CHANGEMODE));
			default: return null; //EPSILON
		
		
		}
	}
	
	private IConcSynWrapper optGlobalglobImps()throws GrammarError{
		switch(terminal){
		case GLOBAL:
			consume(Terminal.GLOBAL);
			return globImps();
			
			default: return null; //EPSILON
		
		
		}
		
	}
	
	private IConcSynWrapper optLocalcpsStoDecl() throws GrammarError{
		switch(terminal){
		case LOCAL:
			consume(Terminal.LOCAL);
			return cpsStoDecl();
			
			default: return null; //EPSILON
		
		
		}
		
	}
	private IConcSynWrapper procDecl() throws GrammarError{

		TokenTupel proc = (TokenTupel) consume(Terminal.PROC);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		Param param = (Param) param();
		OptGlobalglobImps optggi = (OptGlobalglobImps) optGlobalglobImps();
		OptLocalcpsStoDecl olcsd = (OptLocalcpsStoDecl) optLocalcpsStoDecl();
		consume(Terminal.DO);
		CpsCmd cpsCmd = CpsCmd();
		consume(Terminal.ENDPROC);
		return new ProcDecl(proc, ident, param, optggi, olcsd,cpsCmd);
	}
	private IConcSynWrapper globImps() throws GrammarError{

		GlobImp globImp = (GlobImp) globImp();
		RepCommaGlobImp repCom = (RepCommaGlobImp) repCommaGlobImp();
		return new GlobImps(globImp, repCom);
		
		
	}
	private IConcSynWrapper repCommaGlobImp() throws GrammarError{
		switch(terminal){
		case COMMA:
			consume(Terminal.COMMA);
			GlobImp globImp = (GlobImp) globImp();
			RepCommaGlobImp repCommaGI = (RepCommaGlobImp) repCommaGlobImp();
			return  new RepCommaGlobImp(globImp, repCommaGI); //Hier gehts nicht ohne new return sonst geht globimp verloren
			
		default: return null; //EPSILON
		
		}
	}
	private IConcSynWrapper globImp() throws GrammarError{
//		[N optFlowMode, N optChangeMode, T IDENT]
		OptFlowMode optFlowMode = (OptFlowMode) optFlowMode();
		OptChangeMode optChangeMode = (OptChangeMode) optChangeMode();
		TokenTupel tt = (TokenTupel) consume(Terminal.IDENT);
		return new GlobImp(optFlowMode, optChangeMode, tt);
	}
	private IConcSynWrapper optFlowMode() throws GrammarError{
// [[T FLOWMODE], []]
		switch(terminal){
		case FLOWMODE:
			 //Hier was returnen? die optklasse oder flowmode?
//			falls flowmode, token oder tokentupel. beide müsste IConcSynWrapper auch implementieren.
			return new OptFlowMode(consume(Terminal.FLOWMODE));
		default: return null; //EPSILON
		}

	
	}
	private IConcSynWrapper cpsDecl() throws GrammarError{
//[[N decl, N repSemicolonDecl]]
		Decl decl = (Decl) decl();
		RepSemicolonDecl repDecl = (RepSemicolonDecl) repSemicolonDecl();
		return new CpsDecl(decl, repDecl);
	}
	private IConcSynWrapper repSemicolonDecl() throws GrammarError{
//[[T SEMICOLON, N decl, N repSemicolonDecl],[]]
		switch(terminal){
		case SEMICOLON: 
			consume(Terminal.SEMICOLON);
			Decl decl = (Decl) decl();
			RepSemicolonDecl repDecl = (RepSemicolonDecl) repSemicolonDecl();
			return new RepSemicolonDecl(decl, repDecl);
		default: return null; //EPSILON
		}
	}
	private IConcSynWrapper cpsStoDecl() throws GrammarError{
//		[[N stoDecl, N repSemicolonStoDecl]]
		StoDecl stoDecl = (StoDecl) stoDecl();
		RepSemicolonStoDecl repSto= (RepSemicolonStoDecl) repSemicolonStoDecl();
		return new CpsStoDecl(stoDecl, repSto);
	}
	private IConcSynWrapper repSemicolonStoDecl() throws GrammarError{
//[[T SEMICOLON, N stoDecl, N repSemicolonStoDecl],[]]
		switch(terminal){
		case SEMICOLON:
			consume(Terminal.SEMICOLON);
			StoDecl stoDecl = (StoDecl) stoDecl();
			RepSemicolonStoDecl repSto = (RepSemicolonStoDecl) repSemicolonStoDecl();
			return new RepSemicolonStoDecl( stoDecl, repSto);
		default: return null; //EPSILON
		}
	}
	private IConcSynWrapper progParamList() throws GrammarError{
//[[T LPAREN, N optProgParamRepCommaProgParam, T RPAREN]]
		consume(Terminal.LPAREN);
		OptProgParamRepCommaProgParam optPro = (OptProgParamRepCommaProgParam) optProgParamRepCommaProgParam();
		consume(Terminal.RPAREN);
		return new ProgParamList(optPro);
	}
	private IConcSynWrapper optProgParamRepCommaProgParam() throws GrammarError{
//[N progParam, N repCommaProgParam], []]
		switch(terminal){
		case DOT: //dot musste zu terminal hinzugefügt werden
		case FLOWMODE:
		case CHANGEMODE:
		case IDENT:
			ProgramParam progParam = (ProgramParam) progParam();
			RepCommaProgParam repPr = (RepCommaProgParam) repCommaProgParam();
			return new OptProgParamRepCommaProgParam(progParam, repPr);
		default: return null; //EPSILON
			
		}
	}
	private IConcSynWrapper repCommaProgParam() throws GrammarError{
//[[T COMMA, N progParam, N repCommaProgParam], []]
		switch(terminal){
		case COMMA: 
			consume(Terminal.COMMA);
			ProgramParam progParam = (ProgramParam) progParam();
			RepCommaProgParam repPr = (RepCommaProgParam) repCommaProgParam();
			return new RepCommaProgParam(progParam, repPr);
		default: return null; //EPSILON
			
		}
	}
	private IConcSynWrapper progParam() throws GrammarError{
//[[N optFlowMode, N optChangeMode, N typedIdent],[N recordParam]]

		RecordParam recordParam = (RecordParam) recordParam();
		
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
	private IConcSynWrapper paramList() throws GrammarError{
//[[T LPAREN, N optParamRepCommaParam, T RPAREN]]
		consume(Terminal.LPAREN);
		OptParamRepCommaParam optP = (OptParamRepCommaParam) optParamRepCommaParam();
		consume(Terminal.RPAREN);
		return new ParamList(optP);
	}
	private IConcSynWrapper optParamRepCommaParam() throws GrammarError{
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
		default: return null; //EPSILON
		}
	}
	private IConcSynWrapper repCommaParam() throws GrammarError{
//[[T COMMA, N param, N repCommaParam], []]		
		switch(terminal){
		case COMMA:
			consume(Terminal.COMMA);
			Param p = (Param) param();
			RepCommaParam rp = (RepCommaParam) repCommaParam();
			return new RepCommaParam(p, rp);
		default: return null; //EPSILON
			
		}
		
	}
	private IConcSynWrapper param()throws GrammarError{
//		[[N optFlowMode, N optMechMode, N optChangeMode, N typedIdent],[N recordParam]]
		switch(terminal){
		case FLOWMODE:
		case MECHMODE:
		case CHANGEMODE:
		case IDENT:
			OptFlowMode optFl = (OptFlowMode) optFlowMode();
			OptMechMode optM = (OptMechMode) optFlowMode();
			OptChangeMode optC = (OptChangeMode) optChangeMode();
			TypedIdent tIdent = (TypedIdent) typedIdent();
			return new Param(optFl, optM, optC, tIdent);
		case DOT:
			return recordParam();
		default: throw new GrammarError("param", 0);
		}
	}
	private IConcSynWrapper recordParam() throws GrammarError{
//		 [[T DOT,T IDENT, T COLON, T RECIDENT]]
		consume(Terminal.DOT);
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		TokenTupel recIdent= (TokenTupel) consume(Terminal.RECIDENT); //Add scanner if starts with capital
		//RECIDENT zu terminal hinzugefügt;
		return new RecordParam(ident, recIdent);
	}
	private IConcSynWrapper typedIdent() throws GrammarError{
//		[[T IDENT, T COLON, T ATOMTYPE]]
		TokenTupel ident = (TokenTupel) consume(Terminal.IDENT);
		consume(Terminal.COLON);
		TokenTupel aType = (TokenTupel) consume(Terminal.TYPE); //TYPE == ATOMTYPE??
		return new TypedIdent(ident, aType);
	}
	
	
	
	
	

}
