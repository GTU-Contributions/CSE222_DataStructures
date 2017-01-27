package com.mycompany.hw4_131044084_mehmed_mustafa;

import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.DivisionToZeroException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.GeneralErrorException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.RegisterOverflowException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.SyntaxErrorException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.UndefinedVariableException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MemoryRegisters.Register;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Class which converts postfix to assembly
 * @author Mehmed Mustafa 131044084
 */
public class postfixToAssemblyConvertor {
    
    // Data fields
    private final MemoryRegisters myRegs;
    private ArrayList<String> assemblyFinal;
    
    Stack<Object> operandStack = new Stack<>();
    
    /* The operators */
    private static final String OPERATORS = "=+-*/";
    
    /**
     * Default constructor
     */
    public postfixToAssemblyConvertor(){
        myRegs = new MemoryRegisters();
    }
    
    /**
     * Test if a character is an operator
     * @param ch Character to be tested
     * @return True if the ch is an operator
     */
    private boolean isOperator(char ch){
        return (OPERATORS.indexOf(ch) > -1);
    }
    
    /**
     * Evaluates one operator and push the Register back to the Stack
     * @param op Operator to evaluate
     * @return Register with the evaluated result
     * @throws UndefinedVariableException When we try to process undefined variable
     * @throws DivisionToZeroException When division by zero occurs
     * @throws GeneralErrorException Contains all other kind of errors
     * @throws RegisterOverflowException When no free register is available
     */
    protected Register evalOneOp(char op)
            throws UndefinedVariableException, 
            DivisionToZeroException, GeneralErrorException, 
            RegisterOverflowException{
        
        /* String builder builds current operation's assembly code */
        StringBuilder thisOperation = new StringBuilder();
        String strLhs="", strRhs="";
        Register rLhs, rRhs, result;
        
        /* Determine the right hand side operand */
        // If the left operand is String
        if(operandStack.peek() instanceof String){
            strRhs = (String) operandStack.pop();
            
            // Determine if the right operand is constant or variable
            if(Character.isDigit(strRhs.charAt(0))){
                
                // Special case for load immediate
                if(op == '=' && (operandStack.peek() instanceof String)){
                    strLhs = (String) operandStack.pop();
                    Integer valRhs = Integer.parseInt(strRhs);
                    thisOperation.append("li\t");
                    result = myRegs.load(strLhs, valRhs);
                    thisOperation.append(result);
                    thisOperation.append(", ");
                    thisOperation.append(valRhs);
                    /* Add the assembly code for this operation on the assembly array */
                    assemblyFinal.add(thisOperation.toString());
                    return result;
                }
                
                // The right operand is constant
                Integer valRhs = Integer.parseInt(strRhs);
                thisOperation.append("li\t");
                rRhs = myRegs.load(valRhs);
                thisOperation.append(rRhs);
                thisOperation.append(", ");
                thisOperation.append(valRhs);
                thisOperation.append("\n");
                
            }
            else // The right operand is variable
            {
                rRhs = myRegs.findVariableReg(strRhs);
                if(rRhs == null)
                    throw new UndefinedVariableException(strRhs + " is not defined!\n");
            }
        }
        else // The right operand is register
            rRhs = (Register) operandStack.pop();
        
        /* Determine the left hand side operand */
        // If the left operand is String
        if(operandStack.peek() instanceof String){
            strLhs = (String) operandStack.pop();
            
            // Determine if the left operand is constant or variable
            if(Character.isDigit(strLhs.charAt(0))){
                
                // The left operand is constant
                Integer valLhs = Integer.parseInt(strLhs);
                thisOperation.append("li\t");
                rLhs = myRegs.load(valLhs);
                thisOperation.append(rLhs);
                thisOperation.append(", ");
                thisOperation.append(valLhs);
                thisOperation.append("\n");
                
            }
            else // The left operand is variable
            {
                rLhs = myRegs.findVariableReg(strLhs);
                if(rLhs == null && (op != '='))
                    throw new UndefinedVariableException(strLhs + " is not defined!\n");
            }
        }
        else // The left operand is register
            rLhs = (Register) operandStack.pop();
        
        switch(op){
            case '+':
                thisOperation.append("add\t");
                result = myRegs.add(rLhs, rRhs);
                thisOperation.append(result);
                thisOperation.append(", ");
                thisOperation.append(rLhs);
                thisOperation.append(", ");
                thisOperation.append(rRhs);
                thisOperation.append("\n");
                /* Add the assembly code for this operation on the assembly array */
                assemblyFinal.add(thisOperation.toString());
                break;
            case '-':
                thisOperation.append("sub\t");
                result = myRegs.sub(rLhs, rRhs);
                thisOperation.append(result);
                thisOperation.append(", ");
                thisOperation.append(rLhs);
                thisOperation.append(", ");
                thisOperation.append(rRhs);
                thisOperation.append("\n");
                /* Add the assembly code for this operation on the assembly array */
                assemblyFinal.add(thisOperation.toString());
                break;
            case '/':
                thisOperation.append("div\t");
                thisOperation.append(rLhs);
                thisOperation.append(", ");
                thisOperation.append(rRhs);
                thisOperation.append("\n");
                thisOperation.append("mflo\t");
                result = myRegs.div(rLhs, rRhs); // throws DivisionToZeroExcept
                thisOperation.append(result);
                thisOperation.append("\n");
                /* Add the assembly code for this operation on the assembly array */
                assemblyFinal.add(thisOperation.toString());
                break;
            case '*':
                thisOperation.append("mult\t");
                thisOperation.append(rLhs);
                thisOperation.append(", ");
                thisOperation.append(rRhs);
                thisOperation.append("\n");                
                thisOperation.append("mflo\t");
                result = myRegs.mult(rLhs, rRhs);
                thisOperation.append(result);
                thisOperation.append("\n");
                /* Add the assembly code for this operation on the assembly array */
                assemblyFinal.add(thisOperation.toString());
                break;
            case '=':
                thisOperation.append("move\t");
                result = myRegs.move(rLhs, strLhs, rRhs);
                thisOperation.append(result);
                thisOperation.append(", ");
                thisOperation.append(rRhs);
                thisOperation.append("\n");
                /* Add the assembly code for this operation on the assembly array */
                assemblyFinal.add(thisOperation.toString());
                break;
            default: // If an error occurs
                result = null;
        }
        
        return result;
    }
    
    /**
     * 
     * @param expression Expression to evaluate
     * @return Assembly result of the evaluation
     * @throws GeneralErrorException Contains all other kind of errors
     * @throws RegisterOverflowException When no free register is available
     */
    public String evalOneLine(String expression) 
            throws GeneralErrorException, RegisterOverflowException{
        assemblyFinal = new ArrayList();
        StringBuilder assemblyResult = new StringBuilder();
        String[] tokens = expression.split("\\s+");
        
        // Special case If the expression for evaluating is starting with print
        if(tokens[0].compareTo("print")==0){
            Register temp = myRegs.findVariableReg(tokens[1]);
            if(temp == null)
                throw new GeneralErrorException
                ("Error: Undefined variable can't be printed!\n");
                
            assemblyResult.append(myRegs.print(temp));
            return assemblyResult.toString();
        }
        
        try{
            for(String nextToken : tokens)
            {   
                char firstChar = nextToken.charAt(0);

                // It is an operant ?
                if(Character.isDigit(firstChar) ||
                   Character.isJavaIdentifierStart(firstChar))
                {
                    operandStack.push(nextToken);
                }
                else // It is an operator !
                {   
                    Register result = evalOneOp(firstChar);
                    operandStack.push(result);
                }

            }
            
            // No more tokens to process, pop the result from the stack
            Register answer = (Register)operandStack.pop();
            int intAnswer = answer.getRegValue();
                
            // If the stack is not empty, there is an error
            if(!operandStack.empty()){
                throw new SyntaxErrorException
                ("Error: The stack is not empty!\n");
            }
        }catch(SyntaxErrorException error){
            throw new GeneralErrorException(error.getMessage());
            
        }catch(UndefinedVariableException error){
            throw new GeneralErrorException
            ("Error: Undefined variable can't be processed!\n");
            
        }catch(DivisionToZeroException error){
            throw new GeneralErrorException
            ("Error: Division to zero occured!\n");
        }
        
        for(String nextLine : assemblyFinal)
        {
            assemblyResult.append(nextLine);
        }
        
        assemblyResult.append("\n");
        
        // Reset the assembly for new expression
        assemblyFinal = new ArrayList<>();
        
        return assemblyResult.toString();
    }
}
