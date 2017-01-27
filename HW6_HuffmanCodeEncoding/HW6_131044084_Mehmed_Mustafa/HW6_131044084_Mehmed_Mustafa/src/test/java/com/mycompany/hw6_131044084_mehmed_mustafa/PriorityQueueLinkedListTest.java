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
public class PriorityQueueLinkedListTest {
    
    public PriorityQueueLinkedListTest() {
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
     * Test of size method, of class PriorityQueueLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PriorityQueueLinkedList instance = new PriorityQueueLinkedList();
        instance.add(14);
        instance.add(4);
        instance.add(2);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class PriorityQueueLinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueueLinkedList instance = new PriorityQueueLinkedList();
        instance.add(7);
        instance.add(3);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of offer method, of class PriorityQueueLinkedList.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        Object e = null;
        PriorityQueueLinkedList instance = new PriorityQueueLinkedList();
        instance.offer(6);
        instance.offer(2);
        instance.offer(7);
        boolean expResult = true;
        boolean result = instance.offer(6);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class PriorityQueueLinkedList.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Object e = null;
        PriorityQueueLinkedList instance = new PriorityQueueLinkedList();
        instance.offer(6);
        instance.offer(2);
        instance.offer(1);
        instance.offer(6);
        instance.offer(3);
        instance.offer(8);
        boolean expResult = true;
        boolean result = instance.removeElement(6);
        assertEquals(expResult, result);
    }

    /**
     * Test of poll method, of class PriorityQueueLinkedList.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        PriorityQueueLinkedList instance = new PriorityQueueLinkedList();
        instance.offer(6);
        instance.offer(2);
        instance.offer(6);
        instance.offer(3);
        instance.offer(8);
        Object expResult = 2;
        Object result = instance.poll();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class PriorityQueueLinkedList.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorityQueueLinkedList instance = new PriorityQueueLinkedList();
        instance.offer(6);
        instance.offer(2);
        instance.offer(1);
        instance.offer(6);
        instance.offer(3);
        instance.offer(8);
        Object expResult = 1;
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
}
