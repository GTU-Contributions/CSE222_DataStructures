package com.mycompany.hw1_131044084_mehmed_mustafa;

import java.util.ArrayList;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class SystemMoodle {
    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<Course> courses = new ArrayList<>();
    
    /**
     * 
     * @param aCourse a course to check
     * @return the index where the course exist, -1 if not exist
     */
    public static int checkCourseExistence(String aCourse){
        for(int i=0; i<courses.size(); ++i){
            if(aCourse.equals(courses.get(i).getCourseCode()))
                return i;
        }
        
        return -1;
    }
    /**
     * 
     * @param fullName a user's full name to check
     * @return the index where the user exist, -1 if not exist
     */
    public static int checkUserExistence(String fullName){
        for(int i=0; i<users.size(); ++i){
            if(fullName.equals(users.get(i).getFullName()))
                return i;
        }
        
        return -1;
    } 
    
    /**
     * 
     * @param aCourse course object to add
     * @return TRUE if successful
     */
    public static boolean addCourse(Course aCourse){
        if(aCourse == null){
            return false;
        }
        if(checkCourseExistence(aCourse.getCourseCode()) != -1)
        {
            System.out.print(aCourse.getCourseCode());
            System.out.println(" course is already on the moodle!");
            return false;
        }
        else
        {
            courses.add(aCourse);
            System.out.print(aCourse.getCourseCode());
            System.out.println(" course is added to the moodle!");
            return true;
        }
    }
    /**
     * 
     * @param aUser user object to add
     * @return TRUE if successful 
     */
    public static boolean addUser(User aUser){
        if(aUser == null){
            return false;
        }
        if(checkUserExistence(aUser.getFullName()) != -1)
        {
            System.out.print(aUser.getFullName());
            System.out.println(" is already on the moodle!");
            return false;
        }
        else
        {
            users.add(aUser);
            System.out.print(aUser.getFullName());
            System.out.println(" is added to the moodle!");
            return true;
        }
    }
    
    /**
     * 
     * @param aCourseCode course code to remove
     * @return TRUE if successful 
     */
    public static boolean removeCourse(String aCourseCode){
        int index = checkCourseExistence(aCourseCode);
        
        if(index != -1 && index < courses.size())
        {
            courses.remove(index);
            System.out.println(aCourseCode + " is removed from the Courses list!");
            return true;
        }
        
        System.out.println("The " + aCourseCode + "isn't on the Courses list!");
        return false;
    }
    /**
     * 
     * @param firstName first name of the user to remove
     * @param lastName last name of the user to remove
     * @return TRUE if successful 
     */
    public static boolean removeUser(String firstName, String lastName){
        int index = checkUserExistence(firstName + " " + lastName);
        
        if(index != -1 && index < users.size())
        {
            users.remove(index);
            System.out.printf(firstName + " " + lastName);
            System.out.println(" is removed from the moodle!");
            return true;
        }
        
        System.out.println("The user: " + firstName + " " + lastName + 
                                                    " isn't on the moodle!");
        return false;
    }
    
    /**
     * 
     * @param aCourse a course code to find
     * @return Course object referance, null if not exist
     */
    public static Course findCourse(String aCourse){
        for(int i=0; i<courses.size(); ++i){
            if(aCourse.equals(courses.get(i).getCourseCode()))
                return courses.get(i);
        }
        
        return null;
    }
    /**
     * 
     * @param assigName an asignment name to find
     * @param courseCode a course code in which to search
     * @return Assignment object referance, null if not exist
     */
    public static Assignment findAssignment(String assigName, String courseCode){
        Course tempCourse = findCourse(courseCode);
        if(tempCourse == null){
            return null;            
        }
        else
        {
            Assignment tempAssig = tempCourse.findAssignment(assigName);
            
            if(tempAssig == null){
                return null;                
            }
            else
                return tempAssig;
        }
        
    }
    
    /**
     * Prints all courses on the moodle
     */
    public static void showAllCourses(){
        System.out.println("--------------------");
        System.out.println("The list of all Courses in the moodle: ");
        for(int i=0; i<courses.size(); ++i){
            System.out.println(courses.get(i));
        }
        System.out.println("--------------------");
        System.out.println();
    }
    /**
     * Prints all users on the moodle
     */
    public static void showAllUsers(){
        System.out.println("--------------------");
        System.out.println("The list of all Users in the moodle!");
        for(int i=0; i<users.size(); ++i){
            System.out.println(users.get(i));
        }
        System.out.println("--------------------");
        System.out.println();
    }
    /**
     * Prints all documents on the course code
     * @param courseCode course code of the course which's documents to print
     */
    public static void showAllDocumentsForCourse(String courseCode){
        Course temp = findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
        }
        else
            temp.printTheCourseDocuments();
        
    }
    /**
     * Prints all assignments on the course code
     * @param courseCode course code of the course which's assignments to print
     */
    public static void showAllAssignmentsForCourse(String courseCode){
        Course temp = findCourse(courseCode);
        if(temp == null){
            System.out.println("There is no course with code " + courseCode);
        }
        else
            temp.printTheCourseAssignments();
    }
    
    public static void printAllUsersByTheirRights(){
        for(int i=0; i<users.size(); ++i){
            System.out.println(users.get(i).getRightsInfo());
        }
    }
}
