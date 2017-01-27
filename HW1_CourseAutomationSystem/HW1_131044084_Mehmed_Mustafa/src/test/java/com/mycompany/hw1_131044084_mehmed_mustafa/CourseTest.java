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
public class CourseTest extends TestCase {
    
    public CourseTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CourseTest.class);
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
     * Test of setCourseCode method, of class Course.
     */
    public void testSetCourseCode() {
        System.out.println("setCourseCode");
        String courseCode = "";
        Course instance = new Course();
        instance.setCourseCode(courseCode);
    }

    /**
     * Test of getCourseCode method, of class Course.
     */
    public void testGetCourseCode() {
        System.out.println("getCourseCode");
        Course instance = new Course();
        String expResult = "NoName";
        String result = instance.getCourseCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourseTeacher method, of class Course.
     */
    public void testSetCourseTeacher() {
        System.out.println("setCourseTeacher");
        Teacher instructor = null;
        Course instance = new Course();
        instance.setCourseTeacher(instructor);
    }

    /**
     * Test of getCourseTeacher method, of class Course.
     */
    public void testGetCourseTeacher() {
        System.out.println("getCourseTeacher");
        Course instance = new Course();
        Teacher expResult = new Teacher();
        Teacher result = instance.getCourseTeacher();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkStudentExistence method, of class Course.
     */
    public void testCheckStudentExistence() {
        System.out.println("checkStudentExistence");
        Student aStudent = new Student("Mehmed", "Mustafa");
        Course instance = new Course();
        int expResult = -1;
        int result = instance.checkStudentExistence(aStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkTutorExistence method, of class Course.
     */
    public void testCheckTutorExistence() {
        System.out.println("checkTutorExistence");
        Tutor aTutor = new Tutor("Ekber", "Aizezi");
        Course instance = new Course();
        int expResult = -1;
        int result = instance.checkTutorExistence(aTutor);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDocumentExistence method, of class Course.
     */
    public void testCheckDocumentExistence() {
        System.out.println("checkDocumentExistence");
        String docName = "ClassLectures";
        String aType = "pdf";
        Course instance = new Course();
        int expResult = -1;
        int result = instance.checkDocumentExistence(docName, aType);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAssignmentExistence method, of class Course.
     */
    public void testCheckAssignmentExistence() {
        System.out.println("checkAssignmentExistence");
        String assigName = null;
        Course instance = new Course();
        int expResult = -1;
        int result = instance.checkAssignmentExistence(assigName);
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudent method, of class Course.
     */
    public void testAddStudent() {
        System.out.println("addStudent");
        Student aStudent = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addStudent(aStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTutor method, of class Course.
     */
    public void testAddTutor() {
        System.out.println("addTutor");
        Tutor aTutor = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addTutor(aTutor);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDocument method, of class Course.
     */
    public void testAddDocument() {
        System.out.println("addDocument");
        Document aDocument = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addDocument(aDocument);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAssignment method, of class Course.
     */
    public void testAddAssignment() {
        System.out.println("addAssignment");
        Assignment anAssignment = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addAssignment(anAssignment);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeStudent method, of class Course.
     */
    public void testRemoveStudent() {
        System.out.println("removeStudent");
        String firstName = "";
        String lastName = "";
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeStudent(firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTutor method, of class Course.
     */
    public void testRemoveTutor() {
        System.out.println("removeTutor");
        String firstName = "";
        String lastName = "";
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeTutor(firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeDocument method, of class Course.
     */
    public void testRemoveDocument() {
        System.out.println("removeDocument");
        String fileName = "";
        String aType = "";
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeDocument(fileName, aType);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAssignment method, of class Course.
     */
    public void testRemoveAssignment() {
        System.out.println("removeAssignment");
        String assigName = "";
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeAssignment(assigName);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAssignment method, of class Course.
     */
    public void testFindAssignment() {
        System.out.println("findAssignment");
        String assigName = "";
        Course instance = new Course();
        Assignment expResult = null;
        Assignment result = instance.findAssignment(assigName);
        assertEquals(expResult, result);
    }

    /**
     * Test of printTheCourseStudents method, of class Course.
     */
    public void testPrintTheCourseStudents() {
        System.out.println("printTheCourseStudents");
        Course instance = new Course();
        instance.printTheCourseStudents();
    }

    /**
     * Test of printTheCourseTutors method, of class Course.
     */
    public void testPrintTheCourseTutors() {
        System.out.println("printTheCourseTutors");
        Course instance = new Course();
        instance.printTheCourseTutors();
    }

    /**
     * Test of printTheCourseDocuments method, of class Course.
     */
    public void testPrintTheCourseDocuments() {
        System.out.println("printTheCourseDocuments");
        Course instance = new Course();
        instance.printTheCourseDocuments();
    }

    /**
     * Test of printTheCourseAssignments method, of class Course.
     */
    public void testPrintTheCourseAssignments() {
        System.out.println("printTheCourseAssignments");
        Course instance = new Course();
        instance.printTheCourseAssignments();
    }

    /**
     * Test of equals method, of class Course.
     */
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Course.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Course instance = new Course();
        int expResult = 7;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Course.
     */
    public void testToString() {
        System.out.println("toString");
        Course instance = new Course();
        String expResult = "NoName, Course teacher: NoFirstName NoLastName";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
