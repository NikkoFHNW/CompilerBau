package ch.fhnw.compiler.parser.abs;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ch.fhnw.compiler.context.Parameter;
import ch.fhnw.compiler.context.Routine;
import ch.fhnw.compiler.context.Store;
import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.compiler.scanner.data.Type;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;


public interface IAbs {
    interface IProgram extends IAbs {
        void check() throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }

    interface ICpsDecl extends IAbs {
        void checkDeclaration() throws ContextError;
        void check(int locals) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
        int getCount();
    }
    interface IDecl extends IAbs {
        void checkDeclaration() throws ContextError;
        int check(int locals) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }
    interface IStoDecl extends IDecl {
        TokenTupel getType();
        String getIdent();
        IInstructions.Store check() throws ContextError;
    }

    interface ICmd extends IAbs {
        void check(boolean canInit) throws ContextError;
        void check() throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }
    interface IParam extends IAbs {
        void check(Routine routine) throws ContextError;
        void checkInit() throws ContextError;
        int calculateAddress(int count, int locals);
        int codeIn(int loc, int count, int locals) throws CodeTooSmallError;
        int codeOut(int loc, int count, int locals) throws CodeTooSmallError;
    }
    interface IGlobImp extends IAbs {
        void check(Routine routine) throws ContextError;
        void checkInit() throws ContextError;
    }
    interface IExpr extends IAbs {
        TokenTupel checkR() throws ContextError;
        TokenTupel checkL(boolean canInit) throws ContextError;
        TokenTupel checkL() throws ContextError;
        TokenTupel check() throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }
//    interface IExprList extends IAbs {
//        void check(
//                List<Parameter> paramList,
//                Set<String> aliasList,
//                boolean canInit)
//                throws ContextError;
//        int code(int loc
//             ) throws CodeTooSmallError;
//    }

    //possible TODO: return Set
    interface IGlobInit extends IAbs {
        Object check(Object initList)
                throws ContextError;
        TokenTupel check() throws ContextError;
    }

    interface IRecData extends IDecl{
    	Map<String,Type> getCompleteData();
    	void getData(Map<String,Type> resL);
    }
    
    
    
    String toString(String indent);
    int getLine();

    @SuppressWarnings("serial")
    final class ContextError extends Exception {
        public ContextError(final String errorMessage, final int line) {
            super(errorMessage + "\n\tat line:" + line);

        }
    }

}
