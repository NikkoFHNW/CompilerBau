datatype term
 = LITERAL
 | IDENT
 | LEXERROR
 | RELOPR
 | BOOLOPR
 | TYPE
 | SENTINEL
 | ADDOPR
 | MULTOPR
 | LPAREN
 | RPAREN
 | COMMA
 | SEMICOLON
 | COLON
 | BECOMES
 | FLOWMODE
 | CHANGEMODE
 | MECHMODE
 | DO
 | ELSE
 | FUN
 | ENDFUN
 | ENDIF
 | ENDPROC
 | ENDPROGRAM
 | ENDWHILE
 | GLOBAL
 | CALL
 | INIT
 | DEBUGIN
 | DEBUGOUT
 | NOTOPR
 | RETURNS
 | SKIP
 | THEN
 | PROC 
 | PROGRAM
 | LOCAL
 | RECIDENT
 | ATOMTYPE
 | IF
 | WHILE
 | REC
 | LCURL
 | DOT
 | RCURL
 
 val string_of_term = 
 fn LITERAL => "LITERAL" 
 |IDENT => "IDENT"
 |LEXERROR => "LEXERROR"
 |RELOPR => "RELOPR"
 |BOOLOPR => "BOOLOPR"
 |TYPE => "TYPE"
 |SENTINEL => "SENTINEL"
 |ADDOPR => "ADDOPR"
 |MULTOPR => "MULTOPR"
 |LPAREN => "LPAREN"
 |RPAREN => "RPAREN"
 |COMMA => "COMMA"
 |SEMICOLON => "SEMICOLON"
 |COLON => "COLON"
 |BECOMES => "BECOMES"
 |FLOWMODE => "FLOWMODE"
 |CHANGEMODE => "CHANGEMODE"
 |MECHMODE => "MECHMODE"
 |DO => "DO"
 |ELSE => "ELSE"
 |FUN => "FUN"
 |ENDFUN => "ENDFUN"
 |ENDIF => "ENDIF"
 |ENDPROC => "ENDPROC"
 |ENDPROGRAM => "ENDPROGRAM"
 |ENDWHILE => "ENDWHILE"
 |GLOBAL => "GLOBAL"
 |CALL => "CALL"
 |INIT => "INIT"
 |DEBUGIN => "DEBUGIN"
 |DEBUGOUT => "DEBUGOUT"
 |NOTOPR => "NOTOPR"
 |RETURNS => "RETURNS"
 |SKIP => "SKIP"
 |THEN => "THEN"
 |PROC => "PROC"
 |PROGRAM => "PROGRAM"
 |LOCAL => "LOCAL"
 |RECIDENT => "RECIDENT"
 | ATOMTYPE => "ATOMTYPE"
 | IF => "IF"
 | WHILE => "WHILE"
 | REC => "REC"
 | LCURL => "LCURL"
 | RCURL => "RCURL"
 | DOT => "DOT"
 
 datatype nonterm
  = program
  | decl
  | stoDecl
  | funDecl
  | procDecl
  | globImps
  | globImp
  | cpsDecl
  | cpsStoDecl
  | progParamList
  | progParam
  | paramList
  | param
  | typedIdent
  | cmd
  | cpsCmd
  | globInits
  | idents
  | expr
  | term1
  | term2
  | term3
  | factor
  | exprList
  | monadicOpr
  | optGlobalcpsDecl
  | optChangeMode
  | recordDecl
  | optGlobalglobImps
  |optLocalcpsStoDecl
  | repCommaGlobImp
  | optFlowMode
  | repSemicolonDecl
  | repSemicolonStoDecl
  | optProgParamRepCommaProgParam
  | repCommaProgParam
  | optParamRepCommaParam
  | repCommaParam
  | recordParam
  | optGlobInits
  | repSemicolonCmd
  | repCommaIdent
  | repTerm1
  | optTerm2
  | repTerm3
  | repFactor
  | optInitOrExprList
  | optExprRepCommaExpr
  | repCommaExpr
  | recordData
  | repRecordData
  | recordFactor
  | optMechMode
  | recConstr
  | repCommaIdentLiteral
  | identOrLiteral
  | typedIdentOrRecordParam
  | recfieldFactor

val string_of_nonterm =
  fn program          => "program"
   | decl             => "decl"
   | stoDecl          => "stoDecl"
   | funDecl          => "funDecl"
   | procDecl         => "procDecl"
   | globImps         => "globImps"
   | globImp          => "globImp"
   | cpsDecl          => "cpsDecl"
   | cpsStoDecl       => "cpsStoDecl"
   | progParamList    => "progParamList"
   | progParam        => "progParam"
   | paramList        => "paramList"
   | param            => "param"
   | typedIdent       => "typedIdent"
   | cmd              => "cmd"
   | cpsCmd           => "cpsCmd"
   | globInits        => "globInits"
   | idents           => "idents"
   | expr             => "expr"
   | term1            => "term1"
   | term2            => "term2"
   | term3            => "term3"
   | factor           => "factor"
   | exprList         => "exprList"
   | monadicOpr       => "monadicOpr"
   | optGlobalcpsDecl => "optGlobalcpsDecl"
   | optChangeMode    => "optChangeMode"
   | recordDecl       => "recordDecl"
   | optGlobalglobImps => "optGlobalglobImps"
   | optLocalcpsStoDecl => "optLocalcpsStoDecl"
   | repCommaGlobImp => "repCommaGlobImp"
   | optFlowMode => "optFlowMode"
   | repSemicolonDecl => "repSemicolonDecl"
   | repSemicolonStoDecl => "repSemicolonStoDecl"
   | optProgParamRepCommaProgParam => "optProgParamRepCommaProgParam"
   | repCommaProgParam => "repCommaProgParam"
   | optParamRepCommaParam => "optParamRepCommaParam"
   | repCommaParam => "repCommaParam"
   | recordParam => "recordParam"
   | optGlobInits => "optGlobInits"
   | repSemicolonCmd => "repSemicolonCmd"
   | repCommaIdent => "repCommaIdent"
   | repTerm1 => "repTerm1"
   | optTerm2 => "optTerm2"
   | repTerm3 => "repTerm3"
   | repFactor => "repFactor"
   | optInitOrExprList => "optInitOrExprList"
   | optExprRepCommaExpr => "optExprRepCommaExpr"
   | repCommaExpr => "repCommaExpr"
   | recordData => "recordData"
   | repRecordData => "repRecordData"
   | recordFactor => "recordFactor"
   | optMechMode => "optMechMode"
   | recConstr => "recConstr"
   | repCommaIdentLiteral => "repCommaIdentLiteral"
   | identOrLiteral => "identOrLiteral"
   | typedIdentOrRecordParam => "typedIdentOrRecordParam"
   | recfieldFactor => "recfieldFactor"





  
 val string_of_gramsym = (string_of_term, string_of_nonterm)

local
  open FixFoxi.FixFoxiCore
in

val productions = 
[
(program,[[T PROGRAM, T IDENT, N progParamList, N optGlobalcpsDecl, T DO, N cpsCmd, T ENDPROGRAM]]),
(optGlobalcpsDecl , [[T GLOBAL, N cpsDecl],[]]),
(decl, [[N stoDecl], [N funDecl], [N procDecl]]),
(stoDecl, [[N optChangeMode, N typedIdent],[N recordDecl]]),
(optChangeMode, [[T CHANGEMODE],[]]),
(funDecl, [[T FUN, T IDENT, N paramList, T RETURNS, N stoDecl,N optGlobalglobImps, N optLocalcpsStoDecl, T DO, N cpsCmd, T ENDFUN]]),
(optGlobalglobImps, [[T GLOBAL, N globImps], []]),
(optLocalcpsStoDecl,[[T LOCAL, N cpsStoDecl],[]]),
(procDecl, [[T PROC, T IDENT, N param, N optGlobalglobImps, N optLocalcpsStoDecl, T DO, N cpsCmd, T ENDPROC]]),
(globImps,[[N globImp, N repCommaGlobImp]]),
(repCommaGlobImp,[[T COMMA, N globImp, N repCommaGlobImp],[]]),
(globImp,[[N optFlowMode, N optChangeMode, T IDENT]]),
(optFlowMode, [[T FLOWMODE], []]),
(cpsDecl,[[N decl, N repSemicolonDecl]]),
(repSemicolonDecl,[[T SEMICOLON, N decl, N repSemicolonDecl],[]]),
(cpsStoDecl,[[N stoDecl, N repSemicolonStoDecl]]),
(repSemicolonStoDecl,[[T SEMICOLON, N stoDecl, N repSemicolonStoDecl],[]]),
(progParamList,[[T LPAREN, N optProgParamRepCommaProgParam, T RPAREN]]),
(optProgParamRepCommaProgParam, [[N progParam, N repCommaProgParam], []]),
(repCommaProgParam,[[T COMMA, N progParam, N repCommaProgParam], []]),
(progParam,[[N optFlowMode, N optChangeMode, N typedIdent],[N recordParam]]),
(paramList,[[T LPAREN, N optParamRepCommaParam, T RPAREN]]),
(optParamRepCommaParam, [[N param, N repCommaParam], []]),
(repCommaParam,[[T COMMA, N param, N repCommaParam], []]),
(param, [[N optFlowMode, N optMechMode, N optChangeMode, N typedIdentOrRecordParam]]),
(typedIdentOrRecordParam, [[N typedIdent],[N recordParam]]),
(recordParam, [[T DOT,T IDENT, T COLON, T RECIDENT]]),
(typedIdent,[[T IDENT, T COLON, T ATOMTYPE]]),
(cmd,[[T SKIP], [N expr, T BECOMES, N expr], [T IF, N expr, T THEN, N cpsCmd, T ELSE, N cpsCmd, T ENDIF],[T WHILE, N expr, T DO, N cpsCmd, T ENDWHILE],[T CALL, T IDENT, N exprList, N optGlobInits],[T DEBUGIN, N expr],[T DEBUGOUT, N expr],[T RECIDENT, T IDENT, T BECOMES, T LPAREN, N recConstr, T RPAREN]]),
(recConstr, [[T IDENT, N repCommaIdentLiteral], [T LITERAL, N repCommaIdentLiteral]]),
(repCommaIdentLiteral, [[T COMMA, N identOrLiteral, N repCommaIdentLiteral], []]),
(identOrLiteral, [[T IDENT], [T LITERAL]]),
(optGlobInits,[[N globInits], []]),
(cpsCmd,[[N cmd, N repSemicolonCmd]]),
(repSemicolonCmd,[[T SEMICOLON, N cmd, N repSemicolonCmd], []]),
(globInits,[[T INIT, N idents]]),
(idents,[[T IDENT, N repCommaIdent]]),
(repCommaIdent,[[T COMMA, T IDENT, N repCommaIdent], []]),
(expr,[[N term1, N repTerm1]]),
(repTerm1,[[T BOOLOPR, N term1, N repTerm1], []]),
(term1,[[N term2, N optTerm2]]),
(optTerm2,[[T RELOPR, N term2],[]]),
(term2,[[N term3, N repTerm3]]),
(repTerm3,[[T ADDOPR, N term3, N repTerm3],[]]),
(term3,[[N factor, N repFactor]]),
(repFactor,[[T MULTOPR, N factor, N repFactor],[]]),
(factor, [[T LITERAL],[T IDENT, N optInitOrExprList], [N monadicOpr, N factor],[T LPAREN, N expr, T RPAREN], [N recordFactor]]),
(optInitOrExprList,[[T INIT],[N exprList],[]]),
(exprList,[[T LPAREN, N optExprRepCommaExpr, T RPAREN]]),
(optExprRepCommaExpr,[[N expr, N repCommaExpr],[]]),
(repCommaExpr,[[T COMMA, N expr, N repCommaExpr], []]),
(monadicOpr,[[T NOTOPR],[T ADDOPR]]),
(recordDecl,[[T REC, T RECIDENT, T COLON, T LCURL, N recordData, T RCURL]]),
(recordData,[[N optChangeMode, T IDENT, T COLON, T ATOMTYPE, N repRecordData]]),
(repRecordData,[[T COMMA, N optChangeMode, T IDENT, T COLON, T ATOMTYPE, N repRecordData], []]),
(recordFactor,[[T DOT, T IDENT, T DOT, T IDENT]]),
(optMechMode,[[T MECHMODE],[]])
]

val S = program

val result = fix_foxi productions S string_of_gramsym

end
