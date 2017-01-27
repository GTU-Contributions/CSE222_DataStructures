/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6_131044084_mehmed_mustafa;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mmustafa
 */
public class PriorityQueueBSTTest {
    
    public PriorityQueueBSTTest() {
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
     * Test of compare method, of class PriorityQueueBST.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Object left = 5;
        Object right = 5;
        PriorityQueueBST instance = new PriorityQueueBST();
        int expResult = 0;
        int result = instance.compare(left, right);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class PriorityQueueBST.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueueBST instance = new PriorityQueueBST();
        instance.add(3);
        instance.add(2);
        instance.add(8);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class PriorityQueueBST.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PriorityQueueBST instance = new PriorityQueueBST();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of offer method, of class PriorityQueueBST.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        Object e = null;
        PriorityQueueBST instance = new PriorityQueueBST();
        instance.offer(2);
        instance.offer(1);
        instance.offer(4);
        instance.offer(6);
        instance.offer(5);
        boolean expResult = false;
        boolean result = instance.offer(5);
        assertEquals(expResult, result);
    }

    /**
     * Test of poll method, of class PriorityQueueBST.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        PriorityQueueBST instance = new PriorityQueueBST();
        instance.offer(2);
        instance.offer(1);
        instance.offer(4);
        instance.offer(6);
        instance.offer(5);
        instance.offer(0);
        Object expResult = 0;
        Object result = instance.poll();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class PriorityQueueBST.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorityQueueBST instance = new PriorityQueueBST();
        instance.offer(4);
        instance.offer(6);
        instance.offer(2);
        instance.offer(4);
        instance.offer(6);
        instance.offer(5);
        Object expResult = 2;
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
}
