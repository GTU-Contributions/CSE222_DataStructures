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
public class ProjectTest extends TestCase {
    
    public ProjectTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ProjectTest.class);
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
     * Test of addStudentToProject method, of class Project.
     */
    public void testAddStudentToProject() {
        System.out.println("addStudentToProject");
        Student aStudent = null;
        Project instance = new Project();
        boolean expResult = false;
        boolean result = instance.addStudentToProject(aStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeStudentFromProject method, of class Project.
     */
    public void testRemoveStudentFromProject() {
        System.out.println("removeStudentFromProject");
        Student aStudent = null;
        Project instance = new Project();
        boolean expResult = false;
        boolean result = instance.removeStudentFromProject(aStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of printStudentsOnTheProject method, of class Project.
     */
    public void testPrintStudentsOnTheProject() {
        System.out.println("printStudentsOnTheProject");
        Project instance = new Project();
        instance.printStudentsOnTheProject();
    }

    /**
     * Test of toString method, of class Project.
     */
    public void testToString() {
        System.out.println("toString");
        Project instance = new Project();
        String expResult = "Project: NoProjectName, dead line: No valid dead line, late dead line: No valid late dead line";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
