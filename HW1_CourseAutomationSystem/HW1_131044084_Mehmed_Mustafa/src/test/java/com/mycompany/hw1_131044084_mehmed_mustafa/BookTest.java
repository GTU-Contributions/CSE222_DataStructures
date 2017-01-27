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
public class BookTest extends TestCase {
    
    public BookTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(BookTest.class);
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
     * Test of setDocumentType method, of class Book.
     */
    public void testSetDocumentType() {
        System.out.println("setDocumentType");
        String aType = "";
        Book instance = new Book();
        instance.setDocumentType(aType);
    }

    /**
     * Test of getDocumentType method, of class Book.
     */
    public void testGetDocumentType() {
        System.out.println("getDocumentType");
        Book instance = new Book();
        String expResult = "Type not defined!";
        String result = instance.getDocumentType();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Book.
     */
    public void testToString() {
        System.out.println("toString");
        Book instance = new Book();
        String expResult = "NoDocumentName.Type not defined!";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
