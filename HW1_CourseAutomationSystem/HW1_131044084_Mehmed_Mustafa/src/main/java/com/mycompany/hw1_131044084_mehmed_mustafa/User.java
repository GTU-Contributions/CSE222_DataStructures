package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public abstract class User implements UserInfo{
    private String firstName;
    private String lastName;
    
    /**
     * Default constructor, sets NoName to both first and last
     */
    public User(){
        this.firstName = "NoFirstName";
        this.lastName = "NoLastName";
    }
    /**
     * 
     * @param firstName input string, sets first name to firstName
     * @param lastName input string, sets last name to lastName
     */
    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * 
     * @param firstName input string, sets first name
     */
    @Override
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    /**
     * 
     * @param lastName input string, sets last name
     */
    @Override
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    /**
     * 
     * @return the first name of the user
     */
    @Override
    public String getFirstName(){
        return firstName;
    }
    /**
     * 
     * @return the last name of the user
     */
    @Override
    public String getLastName(){
        return lastName;
    }
    /**
     * 
     * @return the full name of the user
     */
    @Override
    public String getFullName(){
        return (firstName + " " + lastName);
    }
    
    /**
     * 
     * @return The rights that user has
     */
    public abstract String getRightsInfo();
    
}