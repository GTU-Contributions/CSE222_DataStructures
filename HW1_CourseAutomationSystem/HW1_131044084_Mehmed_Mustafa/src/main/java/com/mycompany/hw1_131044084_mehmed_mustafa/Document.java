package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Document {
    private String name;
    private String type;
    private User publisher;
    
    /**
     * Default constructor
     */
    public Document(){
        this.name = "NoDocumentName";
        this.type = "doc";
        this.publisher = new Teacher();
    }
    /**
     * 
     * @param aName sets the name of the document
     * @param aUser sets the published of the document
     */
    public Document(String aName, User aUser){
        this.name = aName;
        this.type = "doc";
        this.publisher = aUser;
    }
    /**
     * 
     * @param aName sets the name of the document
     * @param aType sets the type of the document
     * @param aUser sets the published of the document
     */
    public Document(String aName, String aType, User aUser){
        this.name = aName;
        this.type = aType;
        this.publisher = aUser;
    }
    
    /**
     * 
     * @param aName sets the name of the document
     */
    public void setName(String aName){
        this.name = aName;
    }
    /**
     * 
     * @return the name of the document
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @param aType sets the type of the document
     */
    public void setType(String aType){
        this.type = aType;
    } 
    /**
     * 
     * @return the type of the document
     */
    public String getDocumentType(){
        return (type);
    }
    
    /**
     * 
     * @param aUser sets the publisher of the document
     */
    public void setPublisher(User aUser){
        this.publisher = aUser;
    }
    /**
     * 
     * @return the publisher of the document
     */
    public User getPublisher(){
        return publisher;
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
            Document other = (Document) obj;
            return (this.getName().equals(other.getName()) &&
                    this.getDocumentType().equals(other.getDocumentType()));
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
        int hash = 5;
        return hash;
    }
    
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        return (name + "." + type);
    }
}
