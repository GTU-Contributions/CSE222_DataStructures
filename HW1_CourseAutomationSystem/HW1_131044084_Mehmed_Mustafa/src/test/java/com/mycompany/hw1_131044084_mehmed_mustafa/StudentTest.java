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
public class StudentTest extends TestCase {
    
    public StudentTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(StudentTest.class);
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
     * Test of addSubmission method, of class Student.
     */
    public void testAddSubmission() {
        System.out.println("addSubmission");
        String courseCode = "";
        String assigName = "";
        RarForHomework aRar = null;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.addSubmission(courseCode, assigName, aRar);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewCourseLectures method, of class Student.
     */
    public void testViewCourseLectures() {
        System.out.println("viewCourseLectures");
        String courseCode = "";
        Student instance = new Student();
        instance.viewCourseLectures(courseCode);
    }

    /**
     * Test of viewCourseGrade method, of class Student.
     */
    public void testViewCourseGrade() {
        System.out.println("viewCourseGrade");
        String courseCode = "";
        String assigName = "";
        Student instance = new Student();
        instance.viewCourseGrade(courseCode, assigName);
    }

    /**
     * Test of getRightsInfo method, of class Student.
     */
    public void testGetRightsInfo() {
        System.out.println("getRightsInfo");
        Student instance = new Student("Dimko", "Balev");
        String expResult = "Dimko Balev is a Student";
        String result = instance.getRightsInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Student.
     */
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Student.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Student instance = new Student();
        int expResult = 3;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Student.
     */
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student();
        String expResult = "NoFirstName NoLastName";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
