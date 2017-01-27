package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Student extends User{
    /**
     * Default constructor, sets NoName to both first and last
     */    
    public Student(){
        super();
    }
    /**
     * 
     * @param firstName input string, sets first name to firstName
     * @param lastName input string, sets last name to lastName
     */
    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }
    /**
     * 
     * @param courseCode code of the course, where to add the submision
     * @param assigName name of the assignment to add to
     * @param aRar homework in RarForHomework format
     * @return 
     */
    public boolean addSubmission(String courseCode, String assigName, RarForHomework aRar){
        
        Course tempCourse = SystemMoodle.findCourse(courseCode);
        if(tempCourse == null){
            System.out.println("There is no course with name " + courseCode);
            return false;            
        }
        else if(tempCourse.checkStudentExistence(this) == -1){
            System.out.println("You can't upload submission to a course you haven't enrolled!");
            return false;          
        }
        else{
            Assignment temp = SystemMoodle.findAssignment(assigName, courseCode);
            if(temp == null){
                System.out.print("There is no assignment with name " + assigName);
                System.out.println(" in course " + courseCode);
                return false;            
            }
            else if(temp.isStudentSubmissionExist(this)){
                System.out.print("You have already uploaded your submission to " + assigName);
                System.out.println(" in course " + courseCode);            
                return false;            
            }
            else{
                temp.addSubmission(aRar, this);
                System.out.print(this.getFullName());
                System.out.print(", you have uploaded your submission to " + assigName);
                System.out.println(" in course " + courseCode);            
                return true;
            }
        }
            
    }
    /**
     * 
     * @param courseCode input string, view all the documents on the course code
     */
    public void viewCourseLectures(String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
        }
        else if(temp.checkStudentExistence(this) != -1){
            SystemMoodle.showAllDocumentsForCourse(courseCode);
        }
        else{
             System.out.print("You can't view " + courseCode);
             System.out.println("'s documents, because you aren't enrolled to this course!");
        }
    }
    /**
     * 
     * @param courseCode course code where to check the grade
     * @param assigName assignment name where to check the grade
     */
    public void viewCourseGrade(String courseCode, String assigName){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
        }
        else if(temp.checkStudentExistence(this) == -1){
            System.out.println("You aren't enrolled to " + courseCode);
        }
        else{
            Assignment tempAssig = SystemMoodle.findAssignment(assigName, courseCode);
            if(tempAssig == null){
                System.out.println("There is no assignment with name " + assigName);
            }
            else{
                tempAssig.viewStudentGrade(this);
            }
        }        
    }
    
    /**
     * 
     * @return The rights that user has
     */    
    @Override
    public String getRightsInfo(){
        String temp = this.getFullName();
        temp += " is a Student";
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
            Student other = (Student) obj;
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
        int hash = 3;
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
