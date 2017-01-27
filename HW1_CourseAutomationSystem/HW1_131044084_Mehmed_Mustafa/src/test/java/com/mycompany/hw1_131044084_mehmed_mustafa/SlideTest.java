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
public class SlideTest extends TestCase {
    
    public SlideTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SlideTest.class);
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
     * Test of setDocumentType method, of class Slide.
     */
    public void testSetDocumentType() {
        System.out.println("setDocumentType");
        String aType = "";
        Slide instance = new Slide();
        instance.setDocumentType(aType);
    }

    /**
     * Test of getDocumentType method, of class Slide.
     */
    public void testGetDocumentType() {
        System.out.println("getDocumentType");
        Slide instance = new Slide();
        String expResult = "Type not defined!";
        String result = instance.getDocumentType();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Slide.
     */
    public void testToString() {
        System.out.println("toString");
        Slide instance = new Slide();
        String expResult = "NoDocumentName.Type not defined!";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
