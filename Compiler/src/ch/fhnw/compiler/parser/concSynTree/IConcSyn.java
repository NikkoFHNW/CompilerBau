package ch.fhnw.compiler.parser.concSynTree;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.abs.IAbs;
import ch.fhnw.compiler.scanner.data.TokenTupel;

import java.util.List;

public interface IConcSyn {

        public interface IProgram extends IConcSyn {
            IAbs.IProgram toAbstrSyntax() throws GrammarError;
        };
        public interface IDecl extends IConcSyn {
            IAbs.IDecl toAbstrSyntax() throws GrammarError;
        };
        public interface IStoDecl extends IDecl {
            IAbs.IDecl toAbstrSyntax();
        };
        public interface IFunDecl extends IDecl { };
        public interface IProcDecl extends IDecl { };
        public interface ICpsDecl extends IConcSyn {
            IAbs.IDecl toAbstrSyntax() throws GrammarError;
        };
        public interface IParamList extends IConcSyn {
            IAbs.IParam toAbstrSyntax();
        };
        public interface IOptParamRepCommaParam extends IConcSyn {
            IAbs.IParam toAbstrSyntax();
        };
        public interface IRepCommaParam extends IConcSyn {
            IAbs.IParam toAbstrSyntax();
        };
        public interface IParam extends IConcSyn {
            IAbs.IParam toAbstrSyntax();
        };
        public interface IOptGlobalglobImps extends IConcSyn {
            IAbs.IGlobImp toAbstrSyntax();
        };
        public interface IGlobImps extends IConcSyn {
            IAbs.IGlobImp toAbstrSyntax();
        };
        public interface IRepCommaGlobImp extends IConcSyn {
            IAbs.IGlobImp toAbstrSyntax();
        };
        public interface IGlobImp extends IConcSyn {
            IAbs.IGlobImp toAbstrSyntax(IRepCommaGlobImp repGlobImp);
        };
        public interface ICmd extends IConcSyn {
            IAbs.ICmd toAbstrSyntax() throws GrammarError;
        };
        public interface ICpsCmd extends IConcSyn {
            IAbs.ICmd toAbstrSyntax(ICpsCmd next);
        };
        public interface IOptGlobInits extends IConcSyn {
            IAbs.IGlobInit toAbstrSyntax();
        };
        public interface IGlobInits extends IConcSyn {
            IAbs.IGlobInit toAbstrSyntax();
        };
        public interface IIdents extends IConcSyn {
            IAbs.IGlobInit toAbstrSyntax();
        };
        public interface IExpr extends IConcSyn {
            IAbs.IExpr toAbstrSyntax() throws GrammarError;
        };
        public interface IRepTerm1 extends IConcSyn {
            IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError;
        };
        public interface ITerm1 extends IConcSyn {
            IAbs.IExpr toAbstrSyntax() throws GrammarError;
        };
        public interface ITerm2 extends IConcSyn {
            IAbs.IExpr toAbstrSyntax() throws GrammarError;
        };
        public interface IRepTerm3 extends IConcSyn {
            IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError;
        };
        public interface IOptTerm2 extends IConcSyn {
            IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError;
        };
        public interface ITerm3 extends IConcSyn {
            IAbs.IExpr toAbstrSyntax() throws GrammarError;
        };
        public interface IRepFactor extends IConcSyn {
            IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr);
        };
        public interface IRepCommaExpr extends IConcSyn {
            IAbs.IExpr toAbstrSyntax(IAbs.IExpr expr) throws GrammarError;
        };
        public interface IFactor extends IConcSyn {
            IAbs.IExpr toAbstrSyntax() throws GrammarError;
        };
        public interface IExprList extends IConcSyn {
            List<IAbs.IExpr> toAbstrSyntax() throws GrammarError;
        };
        public interface IOptExprRep extends IConcSyn {
            List<IAbs.IExpr> toAbstrSyntax() throws GrammarError;
        };
        public interface IMonadicOpr extends IConcSyn {
            IAbs.IExpr toAbstrSyntax(IAbs.IExpr factor);
        };
        public interface IOptMechMode extends IConcSyn {
            TokenTupel toAbstrSyntax();
        };
        public interface IOptChangeMode extends IConcSyn {
            TokenTupel toAbstrSyntax();
        };
        public interface IOptFlowMode extends IConcSyn {
            TokenTupel toAbstrSyntax();
        };
        public interface IRecConstr extends IConcSyn {
            IAbs.ICmd toAbstrSyntax();
        };
        public interface IRepRecData extends IConcSyn.IRecData{
        	IAbs.IDecl toAbstrSyntax(IAbs.IDecl repRecD);
        }
        public interface IRecData extends IDecl {
        	IAbs.IDecl toAbstrSyntax();
        }



//        String toString(String indent);

}
