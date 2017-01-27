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
public class TutorTest extends TestCase {
    
    public TutorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TutorTest.class);
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
     * Test of getRightsInfo method, of class Tutor.
     */
    public void testGetRightsInfo() {
        System.out.println("getRightsInfo");
        Tutor instance = new Tutor("Abby", "Tylor");
        String expResult = "Abby Tylor is a Student and Tutor";
        String result = instance.getRightsInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Tutor.
     */
    public void testToString() {
        System.out.println("toString");
        Tutor instance = new Tutor("Rukiye", "Bozkurt");
        String expResult = "Rukiye Bozkurt";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
