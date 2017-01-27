/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1_131044084_mehmed_mustafa;

import java.util.Calendar;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author mmustafa
 */
public class AssignmentTest extends TestCase {
    
    public AssignmentTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AssignmentTest.class);
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
     * Test of setName method, of class Assignment.
     */
    public void testSetName() {
        System.out.println("setName");
        String aName = "Mustafa";
        Assignment instance = new AssignmentImpl();
        instance.setName(aName);
    }

    /**
     * Test of getName method, of class Assignment.
     */
    public void testGetName() {
        System.out.println("getName");
        Assignment instance = new AssignmentImpl();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeadLine method, of class Assignment.
     */
    public void testSetDeadLine() {
        System.out.println("setDeadLine");
        Calendar aDate = null;
        Assignment instance = new AssignmentImpl();
        instance.setDeadLine(aDate);
    }

    /**
     * Test of getDeadLine method, of class Assignment.
     */
    public void testGetDeadLine() {
        System.out.println("getDeadLine");
        Assignment instance = new AssignmentImpl();
        String expResult = "No valid dead line";
        String result = instance.getDeadLine();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLateDeadLine method, of class Assignment.
     */
    public void testSetLateDeadLine() {
        System.out.println("setLateDeadLine");
        Calendar aDate = null;
        Assignment instance = new AssignmentImpl();
        instance.setLateDeadLine(aDate);
    }

    /**
     * Test of getLateDeadLine method, of class Assignment.
     */
    public void testGetLateDeadLine() {
        System.out.println("getLateDeadLine");
        Assignment instance = new AssignmentImpl();
        String expResult = "No valid late dead line";
        String result = instance.getLateDeadLine();
        assertEquals(expResult, result);
    }

    /**
     * Test of addSubmission method, of class Assignment.
     */
    public void testAddSubmission() {
        System.out.println("addSubmission");
        RarForHomework aRar = null;
        Student aStudent = null;
        Assignment instance = new AssignmentImpl();
        instance.addSubmission(aRar, aStudent);
    }

    /**
     * Test of isStudentSubmissionExist method, of class Assignment.
     */
    public void testIsStudentSubmissionExist() {
        System.out.println("isStudentSubmissionExist");
        Student aStudent = null;
        Assignment instance = new AssignmentImpl();
        boolean expResult = false;
        boolean result = instance.isStudentSubmissionExist(aStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of gradeSubmission method, of class Assignment.
     */
    public void testGradeSubmission() {
        System.out.println("gradeSubmission");
        Student aStudent = null;
        String aGrade = "";
        Assignment instance = new AssignmentImpl();
        boolean expResult = false;
        boolean result = instance.gradeSubmission(aStudent, aGrade);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewStudentGrade method, of class Assignment.
     */
    public void testViewStudentGrade() {
        System.out.println("viewStudentGrade");
        Student aStudent = null;
        Assignment instance = new AssignmentImpl();
        instance.viewStudentGrade(aStudent);
    }

    /**
     * Test of equals method, of class Assignment.
     */
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Assignment instance = new AssignmentImpl();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Assignment.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Assignment instance = new AssignmentImpl();
        int expResult = 7;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Assignment.
     */
    public void testToString() {
        System.out.println("toString");
        Assignment instance = new AssignmentImpl();
        String expResult = "No valid name, dead line: No valid dead line, late dead line: No valid late dead line";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    public class AssignmentImpl extends Assignment {
    }
    
}
