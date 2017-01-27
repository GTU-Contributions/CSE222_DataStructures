package com.mycompany.hw4_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public final class MehmedsExceptions{
    private static final long serialVersionUID = 1L;
    
    public static class SyntaxErrorException extends Exception{
        private static final long serialVersionUID = 1L;
        /**
         * Syntax error constructor
         * @param error The error message
         */
        SyntaxErrorException(String error){
            super(error);
        }
    }
    
    public static class UndefinedVariableException extends Exception{
        private static final long serialVersionUID = 1L;
        
        UndefinedVariableException(String error){
            super(error);
        }
    }
    
    public static class RegisterOverflowException extends Exception{
        private static final long serialVersionUID = 1L;
        
        RegisterOverflowException(String error){
            super(error);
        }
    }
    
    public static class DivisionToZeroException extends Exception{
        private static final long serialVersionUID = 1L;
        
        DivisionToZeroException(String error){
            super(error);
        }
    }
    
    public static class GeneralErrorException extends Exception{
        private static final long serialVersionUID = 1L;
        
        GeneralErrorException(String error){
            super(error);
        }
        
    }
}
