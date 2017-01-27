package com.mycompany.hw4_131044084_mehmed_mustafa;

import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.DivisionToZeroException;
import com.mycompany.hw4_131044084_mehmed_mustafa.MehmedsExceptions.RegisterOverflowException;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Class which acts like RAM in my program
 * @author Mehmed Mustafa 131044084
 */
public class MemoryRegisters {
    
    /**
     * Inner Register Class
     */
    public static class Register{
        // Data field
        private final String regName; // To indicate $t0-$t7
        private String varName; // Saves the name of the variable stored in
        private int regValue; // Which value is stored in the register
        private boolean isFreeToUse; // Indicator if the register is usable
        
        /**
         * Register constructor
         * @param regName Register name
         */
        protected Register(String regName){
            this.regName = regName;
            varName = "?";
            regValue = 0;
            isFreeToUse = true;
        }
        /**
         * Returns register's name
         * @return Register name
         */
        @Override
        public String toString(){
            return regName;
        }
        @Override
        public boolean equals(Object obj){
            if (!(obj instanceof Register))
                return false;
            if (obj == this)
                return true;
            Register temp = (Register) obj;
            if(this.regValue == temp.regValue)
                return true;
            
            return false;
        }
        /**
         * Setter for register's variable name
         * @param varName name to set
         */
        public void setVarName(String varName){
            this.varName = varName;
        }
        /**
         * Getter for register's variable name
         * @return register's variable name
         */
        public String getVarName(){
            return varName;
        }
        /**
         * Getter for register's variable value
         * @return the value of the register
         */
        public int getRegValue(){
            return regValue;
        }
        /**
         * Setter for register's variable value
         * @param value the value to be set
         */
        public void setRegValue(int value){
            this.regValue = value;
        }
    }
    
    // Data field
    private final ArrayList<Register> registers;
    
    /**
     * Constructor for the program's RAM
     */
    public MemoryRegisters(){
        registers = new ArrayList();
        registers.add(new Register("$t0"));
        registers.add(new Register("$t1"));
        registers.add(new Register("$t2"));
        registers.add(new Register("$t3"));
        registers.add(new Register("$t4"));
        registers.add(new Register("$t5"));
        registers.add(new Register("$t6"));
        registers.add(new Register("$t7"));
        registers.add(new Register("$t8"));
    }
    
    /**
     * Gives free register from the RAM
     * @return Free register
     */
    protected Register getFreeReg(){
        // Find free usable register
        ListIterator iter = registers.listIterator();
        while(iter.hasNext()){
            Register currentReg = (Register) iter.next();
            if(currentReg.isFreeToUse)
                return currentReg;
        }
        
        return null;
    }
    
    /**
     * Gives the register which holds varName
     * @param varName variable name to search
     * @return the register that holds variable with varName, null if not found
     */
    public Register findVariableReg(String varName){
        ListIterator iter = registers.listIterator();
        while(iter.hasNext()){
            Register currentReg = (Register) iter.next();
            if(varName.compareTo(currentReg.varName) == 0)
                return currentReg;
        }
        
        return null;
    }
    /**
     * Makes a register free for use
     * @param regToFree Register to free
     */
    public void freeRegister(Register regToFree){
        if(regToFree == null)
            return;

        regToFree.isFreeToUse = true;
        regToFree.varName = "?";
        regToFree.regValue = 0;
    }
    
    /**
     * Loads new register with given value
     * @param value the initial value of the register
     * @return Register where the value is initialized
     * @throws RegisterOverflowException When no free register is available
     */
    public Register load(int value) throws RegisterOverflowException{
        Register loadedTo = getFreeReg();
        if(loadedTo == null){
            throw new RegisterOverflowException
            ("Error: Register overflow occured!\n");
        }
        loadedTo.regValue = value;
        loadedTo.isFreeToUse = false;
        
        return loadedTo;
    }
    /**
     * Loads new register with given variable name and value
     * @param varName the name of the variable to be initialized
     * @param value the initial value of the register
     * @return Register where the varName and value are initialized
     * @throws RegisterOverflowException When no free register is available
     */
    public Register load(String varName, int value) throws RegisterOverflowException{
        Register loadedTo = getFreeReg();
        if(loadedTo == null){
            throw new RegisterOverflowException
            ("Error: Register overflow occured!\n");
        }
        loadedTo.varName = varName;
        loadedTo.regValue = value;
        loadedTo.isFreeToUse = false;
        
        return loadedTo;
    }
    /**
     * Moves one register's value to other register
     * @param moveTo where to move
     * @param fromWhere from where to move
     * @return Register where fromWhere is moved
     * @throws RegisterOverflowException When no free register is available
     */
    public Register move(Register moveTo, Register fromWhere) throws RegisterOverflowException{
        // If the left side variable isn't defined
        if(moveTo == null){
            Register newReg = getFreeReg();

            if(newReg == null){
                throw new RegisterOverflowException
                ("Error: Register overflow occured!\n");
            }
            newReg.regValue = fromWhere.regValue;
            newReg.isFreeToUse = false;
            
            // If the fromWhere register is temporary
            if(fromWhere.varName.compareTo("?") == 0)
                freeRegister(fromWhere); // Free it
            
            return newReg;
        }
        // The left side variable is defined
        else{
            moveTo.regValue = fromWhere.regValue;
        
            // If the fromWhere register is temporary
            if(fromWhere.varName.compareTo("?") == 0)
                freeRegister(fromWhere); // Free it
            return moveTo;
        }
    }
    /**
     * Moves one register's value to other register and initialize that register
     * with register variable name
     * @param moveTo where to move
     * @param regVarName register variable to be moved
     * @param fromWhere from where to move
     * @return Register where fromWhere is moved
     * @throws RegisterOverflowException When no free register is available
     */
    public Register move(Register moveTo, String regVarName, Register fromWhere) throws RegisterOverflowException{
        // If the left side variable isn't defined
        if(moveTo == null){
            Register newReg = getFreeReg();

            if(newReg == null){
                throw new RegisterOverflowException
                ("Error: Register overflow occured!\n");
            }
            newReg.varName = regVarName;
            newReg.regValue = fromWhere.regValue;
            newReg.isFreeToUse = false;
            
            // If the fromWhere register is temporary
            if(fromWhere.varName.compareTo("?") == 0)
                freeRegister(fromWhere); // Free it
            
            return newReg;
        }
        // The left side variable is defined
        else{
            moveTo.regValue = fromWhere.regValue;
        
            // If the fromWhere register is temporary
            if(fromWhere.varName.compareTo("?") == 0)
                freeRegister(fromWhere); // Free it
            return moveTo;
        }
    }    
    
    /**
     * Sum two register values
     * @param lhs Left hand side
     * @param rhs Right hand side
     * @return Register where the sum is done
     * @throws RegisterOverflowException When no free register is available
     */
    public Register add(Register lhs, Register rhs) throws RegisterOverflowException{
        // If the both registers are temporary
        if(lhs.varName.compareTo("?")==0 && rhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue + rhs.regValue;
            // Free the second register
            freeRegister(rhs);
            // Return the first register with the sum value
            return lhs;
        }
        // If the first register is temporary and the second isn't
        else if(lhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue + rhs.regValue;
            // Return the first register with the sum value
            return lhs;
        }
        // If the second register is temporary and the first isn't
        else if(rhs.varName.compareTo("?")==0)
        {
            // Save the result to the second register
            rhs.regValue = lhs.regValue + rhs.regValue;
            // Return the second register with the sum value
            return rhs;
        }
        // If the both registers are variables
        else
        {
            // Get new usable register
            Register newRegister = getFreeReg();
            if(newRegister == null){
                throw new RegisterOverflowException
                ("Error: Register overflow occured!\n");
            }
            // Save the result to the new register
            newRegister.regValue = lhs.regValue + rhs.regValue;
            // Return the new register with the sum value
            return newRegister;
        }
    }
    /**
     * Sub two register values
     * @param lhs Left hand side
     * @param rhs Right hand side
     * @return Register where the sub is done
     * @throws RegisterOverflowException When no free register is available
     */
    public Register sub(Register lhs, Register rhs) throws RegisterOverflowException{
        // If the both registers are temporary
        if(lhs.varName.compareTo("?")==0 && rhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue - rhs.regValue;
            // Free the second register
            freeRegister(rhs);
            // Return the first register with the sum value
            return lhs;
        }
        // If the first register is temporary and the second isn't
        else if(lhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue - rhs.regValue;
            // Return the first register with the sum value
            return lhs;
        }
        // If the second register is temporary and the first isn't
        else if(rhs.varName.compareTo("?")==0)
        {
            // Save the result to the second register
            rhs.regValue = lhs.regValue - rhs.regValue;
            // Return the second register with the sum value
            return rhs;
        }
        // If the both registers are variables
        else
        {
            // Get new usable register
            Register newRegister = getFreeReg();
            if(newRegister == null){
                throw new RegisterOverflowException
                ("Error: Register overflow occured!\n");
            }
            // Save the result to the new register
            newRegister.regValue = lhs.regValue - rhs.regValue;
            // Return the new register with the sum value
            return newRegister;
        }
    }
    /**
     * Multiply two register values
     * @param lhs Left hand side
     * @param rhs Right hand side
     * @return Register where the multiplication is done
     * @throws RegisterOverflowException When no free register is available
     */
    public Register mult(Register lhs, Register rhs) throws RegisterOverflowException{
        // If the both registers are temporary
        if(lhs.varName.compareTo("?")==0 && rhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue * rhs.regValue;
            // Free the second register
            freeRegister(rhs);
            // Return the first register with the sum value
            return lhs;
        }
        // If the first register is temporary and the second isn't
        else if(lhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue * rhs.regValue;
            // Return the first register with the sum value
            return lhs;
        }
        // If the second register is temporary and the first isn't
        else if(rhs.varName.compareTo("?")==0)
        {
            // Save the result to the second register
            rhs.regValue = lhs.regValue * rhs.regValue;
            // Return the second register with the sum value
            return rhs;
        }
        // If the both registers are variables
        else
        {
            // Get new usable register
            Register newRegister = getFreeReg();
            if(newRegister == null){
                throw new RegisterOverflowException
                ("Error: Register overflow occured!\n");
            }
            // Save the result to the new register
            newRegister.regValue = lhs.regValue * rhs.regValue;
            // Return the new register with the sum value
            return newRegister;
        }
    }
    /**
     * Divide two register values
     * @param lhs Left hand side
     * @param rhs Right hand side
     * @return Register where the division is done
     * @throws DivisionToZeroException When division to 0 occurs
     * @throws RegisterOverflowException When no free register is available
     */
    public Register div(Register lhs, Register rhs) throws DivisionToZeroException, RegisterOverflowException{
        
        if(rhs.regValue == 0)
            throw new DivisionToZeroException("denominator==0");
        
        // If the both registers are temporary
        if(lhs.varName.compareTo("?")==0 && rhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue / rhs.regValue;
            // Free the second register
            freeRegister(rhs);
            // Return the first register with the sum value
            return lhs;
        }
        // If the first register is temporary and the second isn't
        else if(lhs.varName.compareTo("?")==0)
        {
            // Save the result to the first register
            lhs.regValue = lhs.regValue / rhs.regValue;
            // Return the first register with the sum value
            return lhs;
        }
        // If the second register is temporary and the first isn't
        else if(rhs.varName.compareTo("?")==0)
        {
            // Save the result to the second register
            rhs.regValue = lhs.regValue / rhs.regValue;
            // Return the second register with the sum value
            return rhs;
        }
        // If the both registers are variables
        else
        {
            // Get new usable register
            Register newRegister = getFreeReg();
            if(newRegister == null){
                throw new RegisterOverflowException
                ("Error: Register overflow occured!\n");
            }
            // Save the result to the new register
            newRegister.regValue = lhs.regValue / rhs.regValue;
            // Return the new register with the sum value
            return newRegister;
        }
    }
    
    /**
     * Prints a register's value
     * @param regToPrint Register to be printed
     * @return The string to be print on the assembly file
     */
    public String print(Register regToPrint){
        StringBuilder print = new StringBuilder();
        
        // First line
        print.append("move\t");
        print.append("$a0, ");
        print.append(regToPrint.regName);
        print.append("\n");
        
        // Second line
        print.append("li\t");
        print.append("$v0, 1");
        print.append("\n");
        
        // Third line
        print.append("syscall");
        print.append("\n");
        
        return print.toString();
    }
}
