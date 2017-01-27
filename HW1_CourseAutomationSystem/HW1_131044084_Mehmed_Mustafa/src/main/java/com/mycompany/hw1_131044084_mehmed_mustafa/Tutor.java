package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Tutor extends Student{
    /**
     * Default constructor, sets NoName to both first and last
     */    
    public Tutor(){
        super();
    }
    /**
     * 
     * @param firstName input string, sets first name to firstName
     * @param lastName input string, sets last name to lastName
     */
    public Tutor(String firstName, String lastName){
        super(firstName, lastName);
    }
    
    /**
     * 
     * @return The rights that user has
     */    
    @Override
    public String getRightsInfo(){
        String temp = this.getFullName();
        temp += " is a Student and Tutor";
        return temp;
    }
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        return (this.getFullName());
    }
}
