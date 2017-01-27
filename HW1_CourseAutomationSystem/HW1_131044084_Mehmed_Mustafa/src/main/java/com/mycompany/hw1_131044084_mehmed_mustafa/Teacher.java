package com.mycompany.hw1_131044084_mehmed_mustafa;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Teacher extends User{
    /**
     * Default constructor, sets NoName to both first and last
     */    
    public Teacher(){
        super();
    }
    /**
     * 
     * @param firstName input string, sets first name to firstName
     * @param lastName input string, sets last name to lastName
     */
    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
    }
    /**
     * 
     * @param aStudent a student to add
     * @param courseCode in which course to add in
     * @return TRUE if successful
     */
    public boolean addStudentToCourse(Student aStudent, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't add student to a course you don't manage!");
            return false;
        }
        else
        {
            temp.addStudent(aStudent);
            return true;
        }
    }
    /**
     * 
     * @param firstName first name of the student to remove
     * @param secondName last name of the student to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful 
     */
    public boolean removeStudentFromCourse(String firstName, String secondName, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't remove student from a course you don't manage!");
            return false;
        }
        else
        {
            temp.removeStudent(firstName, secondName);
            return true;
        }
    }
    /**
     * 
     * @param aStudent a student to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful 
     */
    public boolean removeStudentFromCourse(Student aStudent, String courseCode){
        if(aStudent == null){
            return false;
        }
        return removeStudentFromCourse(aStudent.getFirstName(), aStudent.getLastName(), courseCode);
    } 
    
    /**
     * 
     * @param aTutor a tutor to add
     * @param courseCode in which course to add in
     * @return TRUE if successful 
     */
    public boolean addTutorToCourse(Tutor aTutor, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't add tutor to a course you don't manage!");
            return false;
        }
        else
        {
            temp.addTutor(aTutor);
            return true;
        }        
    }
    /**
     * 
     * @param firstName first name of the tutor to remove
     * @param secondName last name of the tutor to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful 
     */
    public boolean removeTutorFromCourse(String firstName, String secondName, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't remove tutor from a course you don't manage!");
            return false;
        }
        else
        {
            temp.removeTutor(firstName, secondName);
            return true;
        }        
    }
    /**
     * 
     * @param aTutor a tutor to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful 
     */
    public boolean removeTutorFromCourse(Tutor aTutor, String courseCode){
        if(aTutor == null){
            return false;
        }
        return removeTutorFromCourse(aTutor.getFirstName(), aTutor.getLastName(), courseCode);
    }
    
    /**
     * 
     * @param aDocument a document to add
     * @param courseCode in which course to add in
     * @return TRUE if successful 
     */
    public boolean addDocumentToCourse(Document aDocument, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't add document to a course you don't manage!");
            return false;
        }
        else
        {
            temp.addDocument(aDocument);
            return true;
        }     
    }
    /**
     * 
     * @param fileName a document name to remove
     * @param aType a document type to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful 
     */
    public boolean removeDocumentFromCourse(String fileName, String aType, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't remove document from a course you don't manage!");
            return false;
        }
        else
        {
            temp.removeDocument(fileName, aType);
            return true;
        }
    }
    /**
     * 
     * @param aDocument a document to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful
     */
    public boolean removeDocumentFromCourse(Document aDocument, String courseCode){
        if(aDocument == null){
            return false;
        }
        return removeDocumentFromCourse(aDocument.getName(), aDocument.getDocumentType(), courseCode);
    }
    
    /**
     * 
     * @param anAssig an assignment to add
     * @param courseCode in which course to add in
     * @return TRUE if successful 
     */
    public boolean addAssignmentToCourse(Assignment anAssig, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't add assignment to a course you don't manage!");
            return false;
        }
        else
        {
            temp.addAssignment(anAssig);
            return true;
        }        
    }
    /**
     * 
     * @param assigName an assignment name to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful  
     */
    public boolean removeAssignmentFromCourse(String assigName, String courseCode){
        Course temp = SystemMoodle.findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
            return false;
        }
        if(temp.getCourseTeacher() != this){
            System.out.println("You can't remove assignment from a course you don't manage!");
            return false;
        }
        else
        {
            temp.removeAssignment(assigName);
            return true;
        }        
    }
    /**
     * 
     * @param assig an assignment to remove
     * @param courseCode course from which to remove
     * @return TRUE if successful 
     */
    public boolean removeAssignmentFromCourse(Assignment assig, String courseCode){
        if(assig == null){
            return false;
        }
        return removeAssignmentFromCourse(assig.getName(), courseCode);
    }
    
    /**
     * 
     * @param assigName
     * @param courseCode
     * @param aStudent
     * @return TRUE if successful
     */
    public boolean isStudentSubmissionExist(String assigName, String courseCode, Student aStudent){
        Assignment temp = SystemMoodle.findAssignment(assigName, courseCode);
        if(temp == null){
            System.out.println("There is no assignment with name " + assigName);
            return false;
        }
        if(temp.isStudentSubmissionExist(aStudent))
        {
            System.out.println(aStudent.getFullName() + " has made an submission!");
            return true;
        }
        else
        {
             System.out.println(aStudent.getFullName() + " hasn't made an submission!");
             return false;
        }
    }
    /**
     * 
     * @param assigName
     * @param courseCode
     * @param aStudent
     * @param aGrade
     * @return TRUE if successful 
     */
    public boolean gradeSubmission(String assigName, String courseCode, Student aStudent, String aGrade){
        Course tempCourse = SystemMoodle.findCourse(courseCode);
        if(tempCourse == null){
            System.out.println("There is no course with name " + courseCode);
            return false;            
        }
        else if(tempCourse.getCourseTeacher() != this){
            System.out.println("You can't grade students for course you don't manage!");
            return false;          
        }
        else{ // When the course with courseCode exists
            if(tempCourse.checkStudentExistence(aStudent) != -1){
                Assignment tempAssig = SystemMoodle.findAssignment(assigName, courseCode);
                if(tempAssig == null){
                    System.out.println("There is no assignment with name " + assigName);
                    return false;
                }
                else{ // When the assignment assigName exist
                    
                    tempAssig.gradeSubmission(aStudent, aGrade);
                    System.out.print(aStudent.getFullName());
                    System.out.print(" has been graded with " + aGrade);
                    System.out.println(" for submission in: " + assigName);
                    return true;     
                }
                    
            }
            else{ // When student doesn't exist
                System.out.print("There is no student with name " + aStudent.getFullName());
                System.out.println(" enrolled to the course " + courseCode);
                return false;
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
        temp += " is a Teacher";
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
            Teacher other = (Teacher) obj;
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
        int hash = 5;
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
