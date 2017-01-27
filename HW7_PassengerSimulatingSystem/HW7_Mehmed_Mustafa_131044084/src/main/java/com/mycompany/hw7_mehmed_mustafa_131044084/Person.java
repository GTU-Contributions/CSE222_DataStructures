package com.mycompany.hw7_mehmed_mustafa_131044084;

/**
 * Person class
 * @author Mehmed Mustafa 131044084
 */
public class Person{
    
    //Data Fields
    /* Name of the person */
    String name;
    /* Surname of the person */
    String surname;
    /* Researcher card ID */
    int researcherCardID = 0; //Between 1000-5000
    /* Student card ID */
    int studentCardID = 0; //Between 5000-15000
    
    /**
     * Constructor
     * @param name First name of the person
     * @param surname Last name of the person
     * @param researcherID Researcher card ID
     * @param studentID  Student card ID
     */
    public Person(String name, String surname, int researcherID, int studentID){
        this.name = name;
        this.name = surname;
        this.researcherCardID = researcherID;
        this.studentCardID = studentID;
    }
    
    /**
     * Constructor
     * @param researcherID Researcher card ID
     * @param studentID Student card ID
     */
    public Person(int researcherID, int studentID){
        this.researcherCardID = researcherID;
        this.studentCardID = studentID;
    }
    
    /**
     * Method to check if two objects are same person
     * @param other Other object to check with
     * @return True if it's the same person, false otherwise
     */
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Person))
            return false;
        if(other == this)
            return true;

        Person rightSide = (Person)other;
        return (this.name != null && name.equals(rightSide.name)) && 
               (this.surname != null && surname.equals(rightSide.surname)) && 
               (this.researcherCardID == rightSide.researcherCardID) && 
               (this.studentCardID == rightSide.studentCardID);
    }

    /**
     * Method for hashing the person information
     * @return Hash code of the person
     */
    @Override
    public int hashCode() {
        int hash = 7919;
        hash = 7919 * hash + this.researcherCardID;
        hash = 7919 * hash + this.studentCardID;
        return hash;
    }
    
}
