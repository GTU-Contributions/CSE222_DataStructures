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
public class TeacherTest extends TestCase {
    
    public TeacherTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TeacherTest.class);
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
     * Test of addStudentToCourse method, of class Teacher.
     */
    public void testAddStudentToCourse() {
        System.out.println("addStudentToCourse");
        Student aStudent = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.addStudentToCourse(aStudent, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeStudentFromCourse method, of class Teacher.
     */
    public void testRemoveStudentFromCourse_3args() {
        System.out.println("removeStudentFromCourse");
        String firstName = "";
        String secondName = "";
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeStudentFromCourse(firstName, secondName, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeStudentFromCourse method, of class Teacher.
     */
    public void testRemoveStudentFromCourse_Student_String() {
        System.out.println("removeStudentFromCourse");
        Student aStudent = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeStudentFromCourse(aStudent, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTutorToCourse method, of class Teacher.
     */
    public void testAddTutorToCourse() {
        System.out.println("addTutorToCourse");
        Tutor aTutor = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.addTutorToCourse(aTutor, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTutorFromCourse method, of class Teacher.
     */
    public void testRemoveTutorFromCourse_3args() {
        System.out.println("removeTutorFromCourse");
        String firstName = "";
        String secondName = "";
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeTutorFromCourse(firstName, secondName, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTutorFromCourse method, of class Teacher.
     */
    public void testRemoveTutorFromCourse_Tutor_String() {
        System.out.println("removeTutorFromCourse");
        Tutor aTutor = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeTutorFromCourse(aTutor, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDocumentToCourse method, of class Teacher.
     */
    public void testAddDocumentToCourse() {
        System.out.println("addDocumentToCourse");
        Document aDocument = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.addDocumentToCourse(aDocument, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeDocumentFromCourse method, of class Teacher.
     */
    public void testRemoveDocumentFromCourse_3args() {
        System.out.println("removeDocumentFromCourse");
        String fileName = "";
        String aType = "";
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeDocumentFromCourse(fileName, aType, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeDocumentFromCourse method, of class Teacher.
     */
    public void testRemoveDocumentFromCourse_Document_String() {
        System.out.println("removeDocumentFromCourse");
        Document aDocument = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeDocumentFromCourse(aDocument, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAssignmentToCourse method, of class Teacher.
     */
    public void testAddAssignmentToCourse() {
        System.out.println("addAssignmentToCourse");
        Assignment anAssig = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.addAssignmentToCourse(anAssig, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAssignmentFromCourse method, of class Teacher.
     */
    public void testRemoveAssignmentFromCourse_String_String() {
        System.out.println("removeAssignmentFromCourse");
        String assigName = "";
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeAssignmentFromCourse(assigName, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAssignmentFromCourse method, of class Teacher.
     */
    public void testRemoveAssignmentFromCourse_Assignment_String() {
        System.out.println("removeAssignmentFromCourse");
        Assignment assig = null;
        String courseCode = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeAssignmentFromCourse(assig, courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStudentSubmissionExist method, of class Teacher.
     */
    public void testIsStudentSubmissionExist() {
        System.out.println("isStudentSubmissionExist");
        String assigName = "";
        String courseCode = "";
        Student aStudent = null;
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.isStudentSubmissionExist(assigName, courseCode, aStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of gradeSubmission method, of class Teacher.
     */
    public void testGradeSubmission() {
        System.out.println("gradeSubmission");
        String assigName = "";
        String courseCode = "";
        Student aStudent = null;
        String aGrade = "";
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.gradeSubmission(assigName, courseCode, aStudent, aGrade);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRightsInfo method, of class Teacher.
     */
    public void testGetRightsInfo() {
        System.out.println("getRightsInfo");
        Teacher instance = new Teacher("Murat", "Seker");
        String expResult = "Murat Seker is a Teacher";
        String result = instance.getRightsInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Teacher.
     */
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Teacher.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Teacher instance = new Teacher();
        int expResult = 5;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Teacher.
     */
    public void testToString() {
        System.out.println("toString");
        Teacher instance = new Teacher("Kurtulus", "Savas");
        String expResult = "Kurtulus Savas";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
