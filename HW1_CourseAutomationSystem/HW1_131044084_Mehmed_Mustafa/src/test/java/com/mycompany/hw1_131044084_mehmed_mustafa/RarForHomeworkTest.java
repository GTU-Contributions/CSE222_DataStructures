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
public class RarForHomeworkTest extends TestCase {
    
    public RarForHomeworkTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(RarForHomeworkTest.class);
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
     * Test of setGrade method, of class RarForHomework.
     */
    public void testSetGrade() {
        System.out.println("setGrade");
        String aGrade = "";
        RarForHomework instance = new RarForHomework();
        instance.setGrade(aGrade);
    }

    /**
     * Test of getGrade method, of class RarForHomework.
     */
    public void testGetGrade() {
        System.out.println("getGrade");
        RarForHomework instance = new RarForHomework();
        String expResult = "Not available yet";
        String result = instance.getGrade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDocumentType method, of class RarForHomework.
     */
    public void testSetDocumentType() {
        System.out.println("setDocumentType");
        String aType = "";
        RarForHomework instance = new RarForHomework();
        instance.setDocumentType(aType);
    }

    /**
     * Test of getDocumentType method, of class RarForHomework.
     */
    public void testGetDocumentType() {
        System.out.println("getDocumentType");
        RarForHomework instance = new RarForHomework();
        String expResult = "Type not defined!";
        String result = instance.getDocumentType();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class RarForHomework.
     */
    public void testToString() {
        System.out.println("toString");
        RarForHomework instance = new RarForHomework();
        String expResult = "NoDocumentName.Type not defined!";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
