package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public interface UserInfo {
    /**
     * 
     * @param aName input string
     */
    public void setFirstName(String aName);
    /**
     * 
     * @param aName input string
     */
    public void setLastName(String aName);
    /**
     * 
     * @return the first name of the user
     */
    public String getFirstName();
    /**
     * 
     * @return the last name of the user
     */
    public String getLastName();
    /**
     * 
     * @return the full name of the user
     */
    public String getFullName();

}
