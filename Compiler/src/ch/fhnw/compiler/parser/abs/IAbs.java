package ch.fhnw.compiler.parser.abs;

import ch.fhnw.compiler.scanner.data.TokenTupel;
import ch.fhnw.lederer.virtualmachineFS2015.ICodeArray.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineFS2015.IInstructions;


public interface IAbs {
    public interface IProgram extends IAbs {
        void check() throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }

    public interface ICpsDecl extends IAbs {
        void checkDeclaration() throws ContextError;
        void check(int locals) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
        int getCount();
    }
    public interface IDecl extends IAbs {
        void checkDeclaration() throws ContextError;
        int check(int locals) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }
    public interface IStoDecl extends IDecl {
        TokenTupel getType();
        String getIdent();
        IInstructions.Store check() throws ContextError;
    }

    public interface ICmd extends IAbs {
        void check(boolean canInit) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }
    public interface IParam extends IAbs {
        void check(Object routine) throws ContextError;
        void checkInit() throws ContextError;
        int calculateAddress(int count, int locals);
        int codeIn(int loc, int count, int locals) throws CodeTooSmallError;
        int codeOut(int loc, int count, int locals) throws CodeTooSmallError;
    }
    public interface IGlobImp extends IAbs {
        void check(Object routine) throws ContextError;
        void checkInit() throws ContextError;
    }
    public interface IExpr extends IAbs {
        TokenTupel checkR() throws ContextError;
        TokenTupel checkL(boolean canInit) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
    }
    public interface IExprList extends IAbs {
        void check(
//                List<Parameter> paramList,
//                Set<String> aliasList,
//                boolean canInit)
//                throws ContextError;
//        int code(int loc
             ) throws CodeTooSmallError;
    }
    public interface IGlobInit extends IAbs {
        Object check(Object initList)
                throws ContextError;
    }

    String toString(String indent);
    int getLine();

    @SuppressWarnings("serial")
    public static final class ContextError extends Exception {
        public ContextError(final String errorMessage, final int line) {
            super(errorMessage + "\n\tat line:" + line);

        }
    }
}
