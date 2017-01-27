package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Slide extends Document{
    private String slideType;
    
    /**
     * Default constructor
     */
    public Slide(){
        slideType = "Type not defined!";
    }
    /**
     * 
     * @param fileName sets the name of the slide
     * @param aType sets the type of the slide
     * @param publisher sets the publisher of the slide
     */
    public Slide(String fileName, String aType, User publisher){
        this.setName(fileName);       
        this.slideType = aType;
        this.setPublisher(publisher);
    }
    
    /**
     * 
     * @param aType sets the type of the slide
     */
    public void setDocumentType(String aType){
        this.slideType = aType;
    }    
    
    /**
     * 
     * @return the type of the slide
     */
    @Override
    public String getDocumentType(){
        return (slideType);
    }
    
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        return (this.getName() + "." + slideType);
    }
}
