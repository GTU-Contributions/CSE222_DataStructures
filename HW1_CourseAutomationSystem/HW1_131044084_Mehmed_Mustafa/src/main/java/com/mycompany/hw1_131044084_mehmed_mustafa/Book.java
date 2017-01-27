package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Book extends Document{
    private String bookType;

    /**
     * Default constructor
     */
    public Book(){
        super();
        bookType = "Type not defined!";
    }
    /**
     * 
     * @param fileName sets the name of the book
     * @param aType sets the type of the book
     * @param publisher sets the publisher of the book
     */
    public Book(String fileName, String aType, User publisher){
        this.setName(fileName);
        this.bookType = aType;
        this.setPublisher(publisher);
    }
    
    /**
     * 
     * @param aType sets the type of the book
     */
    public void setDocumentType(String aType){
        this.bookType = aType;
    }
    
    /**
     * 
     * @return the type of the book
     */
    @Override
    public String getDocumentType(){
        return (bookType);
    }
    
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        return (this.getName() + "." + bookType);
    }
}
