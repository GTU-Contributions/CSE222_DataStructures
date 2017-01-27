package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Administrator extends User{
    /**
     * Default constructor, sets NoName to both first and last
     */
    public Administrator(){
        super();
    }
    /**
     * 
     * @param firstName input string, sets first name to firstName
     * @param lastName input string, sets last name to lastName
     */
    public Administrator(String firstName, String lastName){
        super(firstName, lastName);
    }
    /**
     * 
     * @param aCourse course object to add
     * @return TRUE if successful
     */
    public boolean addCourse(Course aCourse){
        if(aCourse == null){
            return false;
        }   
        return SystemMoodle.addCourse(aCourse);
    }
    /**
     * 
     * @param aUser user object to add
     * @return TRUE if successful 
     */
    public boolean addUser(User aUser){
        if(aUser == null){
            return false;
        }
        return SystemMoodle.addUser(aUser);
    }
    /**
     * 
     * @param aCourseCode input string course code to remove
     * @return TRUE if successful 
     */
    public boolean removeCourse(String aCourseCode){
        return SystemMoodle.removeCourse(aCourseCode);
    }
    /**
     * 
     * @param aCourse input Course object to remove
     * @return TRUE if successful 
     */
    public boolean removeCourse(Course aCourse){
        if(aCourse == null){
            return false;
        }
        return removeCourse(aCourse.getCourseCode());
    }
    /**
     * 
     * @param firstName first name of the user to remove
     * @param lastName last name of the user to remove
     * @return TRUE if successful 
     */
    public boolean removeUser(String firstName, String lastName){
        return SystemMoodle.removeUser(firstName, lastName);
    }
    /**
     * 
     * @param aUser user object to remove
     * @return TRUE if successful 
     */
    public boolean removeUser(User aUser){
        if(aUser == null){
            return false;
        }
        return removeUser(aUser.getFirstName(), aUser.getLastName());
    }

    /**
     * 
     * @return The rights that user has
     */
    @Override
    public String getRightsInfo(){
        String temp = this.getFullName();
        temp += " is an Administrator";
        return temp;
    }
    
    /**
     * 
     * @param obj another object from class Object
     * @return TRUE if this object is equal to the obj
     */
    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(this.getClass() == obj.getClass()){
            Administrator other = (Administrator) obj;
            return (this.getFirstName().equals(other.getFirstName()) &&
                    this.getLastName().equals(other.getLastName()));
        }
        else
            return false;
    }
    
    /**
     * 
     * @return hash code of the object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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