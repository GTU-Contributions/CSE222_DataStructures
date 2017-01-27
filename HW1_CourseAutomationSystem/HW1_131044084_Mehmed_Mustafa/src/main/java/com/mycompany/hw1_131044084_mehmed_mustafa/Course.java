package com.mycompany.hw1_131044084_mehmed_mustafa;

import java.util.ArrayList;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Course{
    private String courseCode;
    private Teacher instructor;
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Tutor> tutors = new ArrayList<>();
    private final ArrayList<Document> documents = new ArrayList<>();
    private final ArrayList<Assignment> assignments = new ArrayList<>();
    
    /**
     * Default constructor - initializa to NoName
     */
    public Course(){
        courseCode = "NoName";
        instructor = new Teacher();
    }
    /**
     * 
     * @param courseCode sets the course code
     * @param instructor sets the teacher of the course
     */
    public Course(String courseCode, Teacher instructor){
        this.courseCode = courseCode;
        this.instructor = instructor;
    }
    
    /**
     * 
     * @param courseCode sets course code of the course
     */
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }
    /**
     * 
     * @return the course code of the course
     */
    public String getCourseCode(){
        return courseCode;
    }
    /**
     * 
     * @param instructor sets the teacher of the course
     */
    public void setCourseTeacher(Teacher instructor){
        this.instructor = instructor;
    }
    /**
     * 
     * @return the teacher of the course
     */
    public Teacher getCourseTeacher(){
        return instructor;
    }
    
    /**
     * 
     * @param aStudent student to search
     * @return the index of the student, -1 if not found
     */
    public int checkStudentExistence(Student aStudent){
        for(int i=0; i<students.size(); ++i){
            if(aStudent.equals(students.get(i)))
                return i;
        }
        
        return -1;
    }
    /**
     * 
     * @param aTutor tutor to search
     * @return the index of the tutor, -1 if not found 
     */
    public int checkTutorExistence(Tutor aTutor){
        for(int i=0; i<tutors.size(); ++i){
            if(aTutor.equals(tutors.get(i)))
                return i;
        }
        
        return -1;
    }
    /**
     * 
     * @param docName document name to search
     * @param aType document type to search
     * @return the index of the document, -1 if not found
     */
    public int checkDocumentExistence(String docName, String aType){
        for(int i=0; i<documents.size(); ++i){
            if(docName.equals(documents.get(i).getName()) &&
                    aType.equals(documents.get(i).getDocumentType()))
                return i;
        }
        
        return -1;
    }
    /**
     * 
     * @param assigName assignment name to search
     * @return the index of the assignment, -1 if not found 
     */
    public int checkAssignmentExistence(String assigName){
        for(int i=0; i<assignments.size(); ++i){
            if(assigName.equals(assignments.get(i).getName()))
                return i;
        }
        
        return -1;        
    }
    
    /**
     * 
     * @param aStudent a student to add
     * @return TRUE if successful
     */
    public boolean addStudent(Student aStudent){
        if(aStudent == null){
            return false;
        }
        if(checkStudentExistence(aStudent) != -1)
        {
            System.out.print(aStudent.getFullName());
            System.out.println(" is already on the " + courseCode + " course!");
            return false;
        }
        else
        {
            students.add(aStudent);
            System.out.print(aStudent.getFullName());
            System.out.println(" is added to the " + courseCode + " course!");
            return true;
        }      
    }
    /**
     * 
     * @param aTutor a tutor to add
     * @return TRUE if successful 
     */
    public boolean addTutor(Tutor aTutor){
        if(aTutor == null){
            return false;
        }
        if(checkTutorExistence(aTutor) != -1)
        {
            System.out.print(aTutor.getFullName());
            System.out.println(" is already on the " + courseCode + " course!");
            return false;
        }
        else
        {
            tutors.add(aTutor);
            System.out.print(aTutor.getFullName());
            System.out.println(" is added to the " + courseCode + " course!");
            return true;
        }         
    }
    /**
     * 
     * @param aDocument a document to add
     * @return TRUE if successful 
     */
    public boolean addDocument(Document aDocument){
        if(aDocument == null){
            return false;
        }
        if(checkDocumentExistence(aDocument.getName(), aDocument.getDocumentType()) != -1)
        {
            System.out.print(aDocument.getName() + "." + aDocument.getDocumentType());
            System.out.println(" is already on the " + courseCode + " course!");
            return false;
        }
        else
        {
            documents.add(aDocument);
            System.out.print(aDocument.getName() + "." + aDocument.getDocumentType());
            System.out.println(" is added to the " + courseCode + " course!");
            return true;
        }        
    }
    /**
     * 
     * @param anAssignment an assignment to add
     * @return TRUE if successful 
     */
    public boolean addAssignment(Assignment anAssignment){
        if(anAssignment == null){
            return false;
        }
        if(checkAssignmentExistence(anAssignment.getName()) != -1)
        {
            System.out.print(anAssignment.getName());
            System.out.println(" is already on the " + courseCode + " course!");
            return false;
        }
        else
        {
            assignments.add(anAssignment);
            System.out.print(anAssignment.getName());
            System.out.println(" is added to the " + courseCode + " course!");
            return true;
        }        
    }
    
    /**
     * 
     * @param firstName first name of the student to remove
     * @param lastName last name of the student to remove
     * @return TRUE if successful
     */
    public boolean removeStudent(String firstName, String lastName){
        int index = checkStudentExistence(new Student(firstName, lastName));
        
        if(index != -1 && index < students.size())
        {
            students.remove(index);
            System.out.print(firstName + " " + lastName);
            System.out.println(" is removed from the " + courseCode + " course!");
            return true;
        }
        else
        {
            System.out.println("The student: " + firstName + " " + lastName + 
                                                    " isn't on the course!");
            return false;
        }
    }
    /**
     * 
     * @param firstName first name of the tutor to remove
     * @param lastName last name of the tutor to remove
     * @return TRUE if successful
     */
    public boolean removeTutor(String firstName, String lastName){
        int index = checkTutorExistence(new Tutor(firstName, lastName));

        if(index != -1 && index < assignments.size())
        {
            tutors.remove(index);
            System.out.print(firstName + " " + lastName);
            System.out.println(" is removed from the " + courseCode + " course!");
            return true;
        }
        else
        {
            System.out.println("The tutor: " + firstName + " " + lastName + 
                                                    " isn't on the course!");
            return false;
        }
    }
    /**
     * 
     * @param fileName document name to remove
     * @param aType document type to remove
     * @return TRUE if successful 
     */
    public boolean removeDocument(String fileName, String aType){
        int index = checkDocumentExistence(fileName, aType);
        
        if(index != -1 && index < assignments.size())
        {
            documents.remove(index);
            System.out.print(fileName + "." + aType);
            System.out.println(" is removed from the " + courseCode + " course!");
            return true;
        }
        else
        {
            System.out.println("The document: " + fileName + "." + aType + 
                                                    " isn't on the course!");
            return false;
        }        
    }
    /**
     * 
     * @param assigName assignment name to remove
     * @return TRUE if successful 
     */
    public boolean removeAssignment(String assigName){
        int index = checkAssignmentExistence(assigName);
        
        if(index != -1 && index < assignments.size())
        {
            assignments.remove(index);
            System.out.print(assigName);
            System.out.println(" is removed from the " + courseCode + " course!");
            return true;
        }
        else
        {
            System.out.println("The assignment: " + assigName + 
                                                    " isn't on the course!");
            return false;
        }        
        
    }
    
    /**
     * 
     * @param assigName assignment name to search for
     * @return Assignment referance, null if not found
     */
    public Assignment findAssignment(String assigName){
        int index = checkAssignmentExistence(assigName);
        if(index != -1 && index < assignments.size())
            return assignments.get(index);
        else
            return null;
    }
    
    /**
     * Prints the students on the current course
     */
    public void printTheCourseStudents(){
        System.out.println("Students enrolled to the " + courseCode + " course:");
        for(int i=0; i<students.size(); ++i){
            System.out.println(students.get(i));
        }
        System.out.println();
    }
    /**
     * Prints the tutors on the current course
     */
    public void printTheCourseTutors(){
        System.out.println("Tutors available on the " + courseCode + " course:");
        for(int i=0; i<tutors.size(); ++i){
            System.out.println(tutors.get(i));
        }
        System.out.println();        
    }    
    /**
     * Prints the documents on the current course
     */
    public void printTheCourseDocuments(){
        System.out.println("Documents uploaded to the " + courseCode + " course:");
        for(int i=0; i<documents.size(); ++i){
            System.out.println(documents.get(i));
        }
        System.out.println();        
    }
    /**
     * Prints the assignments on the current course
     */
    public void printTheCourseAssignments(){
        System.out.println("Assignments given to the " + courseCode + " course:");
        for(int i=0; i<assignments.size(); ++i){
            System.out.println(assignments.get(i));
        }
        System.out.println();        
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
            Course other = (Course) obj;
            return (this.getCourseCode().equals(other.getCourseCode()));
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
        String temp = this.getCourseCode() + ", ";
        temp += "Course teacher: " + instructor.getFullName();
        return temp;
    }
    
}
