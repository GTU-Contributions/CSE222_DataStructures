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
public class DocumentTest extends TestCase {
    
    public DocumentTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(DocumentTest.class);
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
     * Test of setName method, of class Document.
     */
    public void testSetName() {
        System.out.println("setName");
        String aName = "";
        Document instance = new Document();
        instance.setName(aName);

    }

    /**
     * Test of getName method, of class Document.
     */
    public void testGetName() {
        System.out.println("getName");
        Document instance = new Document();
        String expResult = "NoDocumentName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Document.
     */
    public void testSetType() {
        System.out.println("setType");
        String aType = "";
        Document instance = new Document();
        instance.setType(aType);
    }

    /**
     * Test of getDocumentType method, of class Document.
     */
    public void testGetDocumentType() {
        System.out.println("getDocumentType");
        Document instance = new Document();
        String expResult = "doc";
        String result = instance.getDocumentType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPublisher method, of class Document.
     */
    public void testSetPublisher() {
        System.out.println("setPublisher");
        User aUser = null;
        Document instance = new Document();
        instance.setPublisher(aUser);
    }

    /**
     * Test of getPublisher method, of class Document.
     */
    public void testGetPublisher() {
        System.out.println("getPublisher");
        Document instance = new Document("Bla", new Teacher("Davut", "Sania"));
        User expResult = new Teacher("Davut", "Sania");
        User result = instance.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Document.
     */
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Document instance = new Document();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Document.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Document instance = new Document();
        int expResult = 5;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Document.
     */
    public void testToString() {
        System.out.println("toString");
        Document instance = new Document();
        String expResult = "NoDocumentName.doc";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
