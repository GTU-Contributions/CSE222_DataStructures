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
public class AdministratorTest extends TestCase {
    
    public AdministratorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AdministratorTest.class);
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
     * Test of addCourse method, of class Administrator.
     */
    public void testAddCourse() {
        System.out.println("addCourse");
        Course aCourse = new Course("BIL222", new Teacher("Erdogan", "Sevilgen"));
        Administrator instance = new Administrator();
        boolean expResult = true;
        boolean result = instance.addCourse(aCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUser method, of class Administrator.
     */
    public void testAddUser() {
        System.out.println("addUser");
        User aUser = new Student("Mehmed", "Mustafa");
        Administrator instance = new Administrator();
        boolean expResult = true;
        boolean result = instance.addUser(aUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCourse method, of class Administrator.
     */
    public void testRemoveCourse_String() {
        System.out.println("removeCourse");
        String aCourseCode = "BIL231";
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.removeCourse(aCourseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCourse method, of class Administrator.
     */
    public void testRemoveCourse_Course() {
        System.out.println("removeCourse");
        Course aCourse = null;
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.removeCourse(aCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class Administrator.
     */
    public void testRemoveUser_String_String() {
        System.out.println("removeUser");
        String firstName = "Adem";
        String lastName = "Kaya";
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.removeUser(firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class Administrator.
     */
    public void testRemoveUser_User() {
        System.out.println("removeUser");
        User aUser = null;
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.removeUser(aUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRightsInfo method, of class Administrator.
     */
    public void testGetRightsInfo() {
        System.out.println("getRightsInfo");
        Administrator instance = new Administrator("Mehmed", "Mustafa");
        String expResult = "Mehmed Mustafa is an Administrator";
        String result = instance.getRightsInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrator.
     */
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Administrator();
        Administrator instance = new Administrator();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Administrator.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Administrator instance = new Administrator();
        int expResult = 7;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Administrator.
     */
    public void testToString() {
        System.out.println("toString");
        Administrator instance = new Administrator();
        String expResult = "NoFirstName NoLastName";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
