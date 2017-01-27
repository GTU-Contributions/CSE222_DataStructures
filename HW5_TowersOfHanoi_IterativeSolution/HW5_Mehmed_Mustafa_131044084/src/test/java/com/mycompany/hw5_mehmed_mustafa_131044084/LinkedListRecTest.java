package com.mycompany.hw5_mehmed_mustafa_131044084;

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
public class LinkedListRecTest {
    
    public LinkedListRecTest() {
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
     * Test of remove method, of class LinkedListRec.
     */
    @Test
    public void testRemove_3args() {
        System.out.println("remove");
        LinkedListRec instance = new LinkedListRec();
        boolean expResult = false;
        boolean result = instance.remove(null);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class LinkedListRec.
     */
    @Test
    public void testRemove_GenericType() {
        System.out.println("remove");
        Object outData = 1;
        LinkedListRec instance = new LinkedListRec();
        instance.add(1);
        instance.add(1);
        instance.add(2);
        instance.add(1);
        instance.add(5);
        instance.add(1);
        instance.add(1);
        instance.add(3);
        instance.add(2);
        instance.add(1);
        instance.add(1);
        
        boolean expResult = true;
        boolean result = instance.remove(outData);
        assertEquals(expResult, result);
    }
    
}
