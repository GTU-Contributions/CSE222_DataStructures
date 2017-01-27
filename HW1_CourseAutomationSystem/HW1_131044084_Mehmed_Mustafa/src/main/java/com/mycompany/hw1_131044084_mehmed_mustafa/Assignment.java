package com.mycompany.hw1_131044084_mehmed_mustafa;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public abstract class Assignment{
    private String name;
    private Calendar deadLine;
    private Calendar lateDeadLine;
    private final ArrayList<RarForHomework> studentUploads = new ArrayList<>();
    
    /**
     * 
     * @param aName sets name of the assignment
     */
    public void setName(String aName){
        this.name = aName;
    }
    /**
     * 
     * @return name of the assignment
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @param aDate sets dead line of the assignment
     */
    public void setDeadLine(Calendar aDate){
        this.deadLine = aDate;
    }
    /**
     * 
     * @return dead line of the assignment
     */
    public String getDeadLine(){
        String temp;
        if(deadLine == null){
            temp = "No valid dead line";
        }
        else
        {
            int year = deadLine.get(Calendar.YEAR);
            int month = deadLine.get(Calendar.MONTH);
            int day = deadLine.get(Calendar.DAY_OF_MONTH);

            temp = day + "/" + month + "/" + year;
        }
        return temp;
    }
    /**
     * 
     * @param aDate sets late dead line of the assignment
     */
    public void setLateDeadLine(Calendar aDate){
        this.lateDeadLine = aDate;
    }
    /**
     * 
     * @return late dead line of the assignment
     */
    public String getLateDeadLine(){
        String temp;
        if(lateDeadLine == null){
            temp = "No valid late dead line";
        }
        else
        {
            int year = lateDeadLine.get(Calendar.YEAR);
            int month = lateDeadLine.get(Calendar.MONTH);
            int day = lateDeadLine.get(Calendar.DAY_OF_MONTH);

            temp = day + "/" + month + "/" + year;            
        }
        return temp;        
    }
    
    
    /**
     * 
     * @param aRar a homework which was uploaded
     * @param aStudent a student who submitted
     */
    public void addSubmission(RarForHomework aRar, Student aStudent){
        studentUploads.add(aRar);
    }
    
    
    /**
     * 
     * @param aStudent a student whos submission to check
     * @return TRUE if exist
     */
    public boolean isStudentSubmissionExist(Student aStudent){
        for(int i=0; i<studentUploads.size(); ++i){
            if(studentUploads.get(i).getPublisher().equals(aStudent)){
                return true;
            }
        }
      
        return false;
    }
    /**
     * 
     * @param aStudent a student whoms homework is gradet
     * @param aGrade sets grade for the homework
     * @return TRUE if successful
     */
    public boolean gradeSubmission(Student aStudent, String aGrade){
        for(int i=0; i<studentUploads.size(); ++i){
            if(studentUploads.get(i).getPublisher().equals(aStudent)){
                studentUploads.get(i).setGrade(aGrade);
                return true;
            }
        }
        
        return false;
    }
    /**
     * 
     * @param aStudent student whos grade to view
     */
    public void viewStudentGrade(Student aStudent){
        for(int i=0; i<studentUploads.size(); ++i){
            if(studentUploads.get(i).getPublisher().equals(aStudent)){
                System.out.println(studentUploads.get(i).getGrade());
                return;
            }
        }
        System.out.println("You haven't uploaded any submissions to this Assignment!");
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
            Assignment other = (Assignment) obj;
            return (this.getName().equals(other.getName()));
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
        String temp;
        if(name == null){
            temp = "No valid name" + ", dead line: ";
            temp += getDeadLine();
            temp += ", late dead line: ";
            temp += getLateDeadLine();            
        }
        else
        {
            temp = name + ", dead line: ";
            temp += getDeadLine();
            temp += ", late dead line: ";
            temp += getLateDeadLine();
        }
    
        return temp;
    }
}
