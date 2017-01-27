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
public class HomeworkTest extends TestCase {
    
    public HomeworkTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(HomeworkTest.class);
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
     * Test of toString method, of class Homework.
     */
    public void testToString() {
        System.out.println("toString");
        Homework instance = new Homework();
        String expResult = "Homework: NoHomeworkName, dead line: No valid dead line, late dead line: No valid late dead line";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
