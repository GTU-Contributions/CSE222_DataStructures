/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1_131044084_mehmed_mustafa;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mmustafa
 */
public class SystemMoodleTest extends TestCase {
    
    public SystemMoodleTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SystemMoodleTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of checkCourseExistence method, of class SystemMoodle.
     */
    public void testCheckCourseExistence() {
        System.out.println("checkCourseExistence");
        String aCourse = "BIL555";
        int expResult = -1;
        int result = SystemMoodle.checkCourseExistence(aCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUserExistence method, of class SystemMoodle.
     */
    public void testCheckUserExistence() {
        System.out.println("checkUserExistence");
        String fullName = "Adem Ademov";
        int expResult = -1;
        int result = SystemMoodle.checkUserExistence(fullName);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCourse method, of class SystemMoodle.
     */
    public void testAddCourse() {
        System.out.println("addCourse");
        Course aCourse = null;
        boolean expResult = false;
        boolean result = SystemMoodle.addCourse(aCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUser method, of class SystemMoodle.
     */
    public void testAddUser() {
        System.out.println("addUser");
        User aUser = null;
        boolean expResult = false;
        boolean result = SystemMoodle.addUser(aUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCourse method, of class SystemMoodle.
     */
    public void testRemoveCourse() {
        System.out.println("removeCourse");
        String aCourseCode = "";
        boolean expResult = false;
        boolean result = SystemMoodle.removeCourse(aCourseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class SystemMoodle.
     */
    public void testRemoveUser() {
        System.out.println("removeUser");
        String firstName = "";
        String lastName = "";
        boolean expResult = false;
        boolean result = SystemMoodle.removeUser(firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of findCourse method, of class SystemMoodle.
     */
    public void testFindCourse() {
        System.out.println("findCourse");
        String aCourse = "";
        Course expResult = null;
        Course result = SystemMoodle.findCourse(aCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAssignment method, of class SystemMoodle.
     */
    public void testFindAssignment() {
        System.out.println("findAssignment");
        String assigName = "";
        String courseCode = "";
        Assignment expResult = null;
        Assignment result = SystemMoodle.findAssignment(assigName, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of showAllCourses method, of class SystemMoodle.
     */
    public void testShowAllCourses() {
        System.out.println("showAllCourses");
        SystemMoodle.showAllCourses();
    }

    /**
     * Test of showAllUsers method, of class SystemMoodle.
     */
    public void testShowAllUsers() {
        System.out.println("showAllUsers");
        SystemMoodle.showAllUsers();
    }

    /**
     * Test of showAllDocumentsForCourse method, of class SystemMoodle.
     */
    public void testShowAllDocumentsForCourse() {
        System.out.println("showAllDocumentsForCourse");
        String courseCode = "";
        SystemMoodle.showAllDocumentsForCourse(courseCode);
    }

    /**
     * Test of showAllAssignmentsForCourse method, of class SystemMoodle.
     */
    public void testShowAllAssignmentsForCourse() {
        System.out.println("showAllAssignmentsForCourse");
        String courseCode = "";
        SystemMoodle.showAllAssignmentsForCourse(courseCode);
    }
    
}
