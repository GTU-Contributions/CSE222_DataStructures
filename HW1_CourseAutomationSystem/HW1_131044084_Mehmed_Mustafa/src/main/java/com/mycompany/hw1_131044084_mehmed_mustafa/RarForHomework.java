package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class RarForHomework extends Document{
    private String fileType;
    private String grade = "Not available yet";
    
    /**
     * Default constructor
     */
    public RarForHomework(){
        fileType = "Type not defined!";
    }
    /**
     * 
     * @param fileName name of the rar homework
     * @param aType type of the rar homework
     * @param publisher student who submitted the homework
     */
    public RarForHomework(String fileName, String aType, Student publisher){
        this.setName(fileName);
        this.fileType = aType;
        this.setPublisher(publisher);
    }
    
    /**
     * 
     * @param aGrade sets the grade for the homework
     */
    public void setGrade(String aGrade){
        this.grade = aGrade;
    }
    /**
     * 
     * @return the grade for the homework
     */
    public String getGrade(){
        return this.grade;
    }
    
    /**
     * 
     * @param aType sets the type of the homework
     */
    public void setDocumentType(String aType){
        this.fileType = aType;
    }
    /**
     * 
     * @return the type of the homework
     */
    @Override
    public String getDocumentType(){
        return (fileType);
    }
    
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        return (this.getName() + "." + fileType);
    }
}
