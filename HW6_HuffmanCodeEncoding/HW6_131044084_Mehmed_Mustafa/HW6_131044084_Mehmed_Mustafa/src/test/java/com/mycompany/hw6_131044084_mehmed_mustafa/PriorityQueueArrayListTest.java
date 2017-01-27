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
public class PriorityQueueArrayListTest {
    
    public PriorityQueueArrayListTest() {
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
     * Test of size method, of class PriorityQueueArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PriorityQueueArrayList instance = new PriorityQueueArrayList();
        instance.add(5);
        instance.add(12);
        instance.add(3);
        instance.add(7);
        int expResult = 4;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class PriorityQueueArrayList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueueArrayList instance = new PriorityQueueArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of offer method, of class PriorityQueueArrayList.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        Object e = null;
        PriorityQueueArrayList instance = new PriorityQueueArrayList();
        instance.add(1);
        instance.add(6);
        instance.add(2);
        instance.add(4);
        boolean expResult = true;
        boolean result = instance.offer(7);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class PriorityQueueArrayList.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Object e = null;
        PriorityQueueArrayList instance = new PriorityQueueArrayList();
        instance.add(1);
        instance.add(6);
        instance.add(2);
        instance.add(4);
        boolean expResult = false;
        boolean result = instance.removeElement(9);
        assertEquals(expResult, result);
    }

    /**
     * Test of poll method, of class PriorityQueueArrayList.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        PriorityQueueArrayList instance = new PriorityQueueArrayList();
        instance.add(7);
        instance.add(6);
        instance.add(2);
        instance.add(4);
        Object expResult = 2;
        Object result = instance.poll();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class PriorityQueueArrayList.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorityQueueArrayList instance = new PriorityQueueArrayList();
        instance.add(7);
        instance.add(6);
        instance.add(2);
        instance.add(4);
        Object expResult = 2;
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
}
