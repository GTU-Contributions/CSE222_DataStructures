package com.mycompany.hw4_131044084_mehmed_mustafa;

import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.SyntaxErrorException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Class which converts infix to postfix expression
 * @author Mehmed Mustafa 131044084
 */
public class InfixToPostfixConvertor {
    
    // Constants
    /* The operators */
    private static final String OPERATORS = "=+-*/";
    /* The precedence of the operators matches order in OPERATORS */
    private static final int[] PRECEDENCE = {0, 1, 1, 2, 2};
    
    // Data fields
    /* Operator stack */
    private final Stack<Character> opStack;
    /* The postfix string */
    private StringBuilder postfix;

    /**
     * Default constructor
     */
    public InfixToPostfixConvertor(){
        opStack = new Stack<>();
        postfix = new StringBuilder();
    }
    
    /**
     * Test if a character is an operator
     * @param ch Character to be tested
     * @return True if the ch is an operator
     */
    protected boolean isOperator(char ch){
        return (OPERATORS.indexOf(ch) > -1);
    }
    
    /**
     * Get the precedence of an operator
     * @param op The operator which's precedence will be returned
     * @return The precedence value
     */
    protected int precedence(char op){
        if(OPERATORS.indexOf(op) > -1)
            return PRECEDENCE[OPERATORS.indexOf(op)];
        else
            return -1;
    }
    
    /**
     * Method to process operators
     * @param op The operator to process
     */
    protected void processOperator(char op){
        if(opStack.empty()) // If the operator stack is currently empty
            opStack.push(op); // Push the operator in the stack
        
        else // There is an operator in the stack
        {
            char topOp = opStack.peek(); // Peek the operator on the top
            
            // If current operator's precedence is bigger than the top
            if(precedence(op) > precedence(topOp))
                opStack.push(op); // Push the operator in the stack
            else // The top operator's precedence is bigger
            {
                while(!opStack.empty() && precedence(op) <= precedence(topOp))
                {
                    opStack.pop(); // Pop the top operator from the stack
                    // Append the poped top operator to the postfix
                    postfix.append(topOp); 
                    // Append space to the postfix
                    postfix.append(' '); 
                    
                    // If the operator stack isn't empty
                    if(!opStack.empty())
                        topOp = opStack.peek(); // Peek the operator on the top
                }
                
                // The operator stack is currently empty or
                // current operator's precedence is bigger than
                // the precedence of the operator on the top of the stack
                opStack.push(op); // Push the current operator in the stack
            }
        }
    } // End of the processOperator implementation
    
    /**
     * Method to convert string from indix to postfix
     * @param infix The infix expression
     * @return The postfix version of the infix string
     * @throws SyntaxErrorException
     */
    public String convert(String infix) throws SyntaxErrorException{
        postfix = new StringBuilder();
        /* Split the infix expression into tokens */
        /* Every token represents operator or operand */
        String[] tokens = infix.split("\\s+");
        try{
            // Special case for print
            if(tokens[0].compareTo("print") == 0)
            {
                // If the tokens aren't 2
                if(tokens.length != 2){
                    throw new SyntaxErrorException
                    ("Syntax Error: You can print only one operand!");
                }
                // If the token after print isn't Java identifier or digit
                if(!Character.isJavaIdentifierStart(tokens[1].charAt(0)) &&
                        !Character.isDigit(tokens[1].charAt(0)))
                {
                    throw new SyntaxErrorException
                    ("Syntax Error: Wrong variable name to print: " + tokens[0]);
                }
                // If the token after print start with digit 
                // but is not number throws NumberFormatException
                if(Character.isDigit(tokens[1].charAt(0)))
                    // throws NumberFormatException if the operand is not number
                    Integer.parseInt(tokens[1]);
                
                // If the 2 tokens pass every control
                postfix.append(tokens[0]);
                postfix.append(' ');
                postfix.append(tokens[1]);
                postfix.append("\n");
                return postfix.toString();
            } // End of the special case

            // If the first character of the token is not Java identifier
            if(!Character.isJavaIdentifierStart(tokens[0].charAt(0))){
                throw new SyntaxErrorException
                ("Syntax Error: Wrong first variable: " + tokens[0]);
            }
            if(tokens[1].compareTo("=") != 0){
                throw new SyntaxErrorException
                ("Syntax Error: There is no = after first variable!\n");
            }
            
            // Variable to track the pattern - operator operand operator...
            boolean wasLastTokenOperator = true;
                
            // If the infix pass every control until here
            // Process each token in the string
            for(String nextToken : tokens)
            {
                // System.out.println(nextToken);
                char firstChar = nextToken.charAt(0);
                
                // If token is variable operand
                if(Character.isJavaIdentifierStart(firstChar)){
                    if(wasLastTokenOperator){
                        postfix.append(nextToken);
                        postfix.append(' ');
                        wasLastTokenOperator = false;
                    }
                    else{
                        throw new SyntaxErrorException
                        ("Syntax error: You can't have operand after operand!\n");
                    }
                }
                // If token is number operand
                else if(Character.isDigit(firstChar)){
// throws NumberFormatException if the operand is not number
                    Integer.parseInt(nextToken);
                    
                    if(wasLastTokenOperator){
                        postfix.append(nextToken);
                        postfix.append(' ');
                        wasLastTokenOperator = false;
                    }
                    else{
                        throw new SyntaxErrorException
                        ("Syntax error: You can't have operand after operand!\n");
                    }
                }
                // If token is operator
                else if(isOperator(firstChar)){
                    // Last token was operator
                    if(wasLastTokenOperator){
                        throw new SyntaxErrorException
                        ("Syntax error: You can't have operator after operator!\n");
                    }
                    // Last token was operand
                    else{
                        processOperator(firstChar);
                        wasLastTokenOperator = true;
                    }
                    
                }
                else{
                    throw new SyntaxErrorException
                    ("Syntax error: Unexpected Character: " + firstChar + "\n");
                }
            }
            
            // If the last token is operator, there is an error in the expression
            if(wasLastTokenOperator){
                throw new SyntaxErrorException
                ("Syntax error: The expression can't end with an operator!\n");
            }
                
            
            // Pop any remaining operators in the stack
            // appending them to the postfix
            while(!opStack.empty()){
                char operator = opStack.pop();
                postfix.append(operator);
                postfix.append(' ');
            }
            
            postfix.append("\n");
            // Return the result after the stack is empty
            return postfix.toString(); 
            
        }catch(NumberFormatException error){
            throw new SyntaxErrorException
            ("Syntax error: Wrong operand format!\n");
        }catch(EmptyStackException error){
            throw new SyntaxErrorException
            ("Syntax error: The stack is empty!\n");
        }
    } // End of the convert implementation
    
} // End of the InfixToPostfixConvertor implementation
