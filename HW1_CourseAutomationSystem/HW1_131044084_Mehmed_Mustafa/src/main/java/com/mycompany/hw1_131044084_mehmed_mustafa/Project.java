package com.mycompany.hw1_131044084_mehmed_mustafa;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class Project extends Assignment{
    private final ArrayList<Student> studentsInTheProject = new ArrayList<>();
    
    /**
     * Default constructor
     */
    public Project(){
        this.setName("NoProjectName");
        this.setDeadLine(null);
        this.setLateDeadLine(null);
    }
    /**
     * 
     * @param projectName name of the project
     * @param deadLine dead line of the homework
     * @param lateDeadLine late dead line of the homework
     */
    public Project(String projectName, Calendar deadLine, Calendar lateDeadLine){
        this.setName(projectName);
        this.setDeadLine(deadLine);
        this.setLateDeadLine(lateDeadLine);
    }
    
    /**
     * 
     * @param aStudent a student to add
     * @return TRUE if successful
     */
    public boolean addStudentToProject(Student aStudent){
        if(aStudent == null){
            return false;
        }
        for(int i=0; i<studentsInTheProject.size(); ++i){
            if(aStudent.equals(studentsInTheProject.get(i))){
                System.out.print(aStudent.getFullName());
                System.out.println(" is already in the " + this.getName() + " project!");
                return false;
            }
        }
        
        studentsInTheProject.add(aStudent);
        System.out.print(aStudent.getFullName());
        System.out.println(" is added to the " + this.getName() + " project");
        return true;
    }
    /**
     * 
     * @param aStudent a student to remove
     * @return TRUE if successful
     */
    public boolean removeStudentFromProject(Student aStudent){
        if(aStudent == null){
            return false;
        }        
        for(int i=0; i<studentsInTheProject.size(); ++i){
            if(aStudent.equals(studentsInTheProject.get(i))){
                studentsInTheProject.remove(aStudent);
                System.out.print(aStudent.getFullName());
                System.out.println(" is removed the " + this.getName() + " project!");
                return true;
            }
        }
        
        System.out.print(aStudent.getFullName());
        System.out.println(" is not in the " + this.getName() + " project!");
        return false;        
    }
    /**
     * Print all students on the current project
     */
    public void printStudentsOnTheProject(){
        System.out.println("Students in the " + this.getName() + " project:");
        for(int i=0; i<studentsInTheProject.size(); ++i){
            System.out.println(studentsInTheProject.get(i));
        }
        System.out.println();
    }
    
    /**
     * 
     * @return string format of the object
     */    
    @Override
    public String toString(){
        String temp = "Project: " + getName() + ", dead line: " + getDeadLine();
        temp += ", late dead line: " + getLateDeadLine();
        return temp;
    }    
}
