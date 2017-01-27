package com.mycompany.hw6_131044084_mehmed_mustafa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mehmed Mustafa
 */
public class PriorityQueueVectorTest {
    
    public PriorityQueueVectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class PriorityQueueVector.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PriorityQueueVector instance = new PriorityQueueVector();
        instance.add(5);
        instance.add(12);
        instance.add(3);
        instance.add(7);
        instance.add(5);
        instance.add(12);
        instance.add(3);
        instance.add(7);
        int expResult = 8;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class PriorityQueueVector.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueueVector instance = new PriorityQueueVector();
        instance.add(7);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of offer method, of class PriorityQueueVector.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        Object e = null;
        PriorityQueueVector instance = new PriorityQueueVector();
        boolean expResult = true;
        boolean result = instance.offer(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class PriorityQueueVector.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Object e = null;
        PriorityQueueVector instance = new PriorityQueueVector();
        instance.add(6);
        instance.add(5);
        boolean expResult = false;
        boolean result = instance.removeElement(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of poll method, of class PriorityQueueVector.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        PriorityQueueVector instance = new PriorityQueueVector();
        instance.add(3);
        instance.add(16);
        instance.add(1);
        instance.add(4);
        Object expResult = 1;
        Object result = instance.poll();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class PriorityQueueVector.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorityQueueVector instance = new PriorityQueueVector();
        instance.add(3);
        instance.add(16);
        instance.add(1);
        instance.add(0);
        Object expResult = 0;
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
}
