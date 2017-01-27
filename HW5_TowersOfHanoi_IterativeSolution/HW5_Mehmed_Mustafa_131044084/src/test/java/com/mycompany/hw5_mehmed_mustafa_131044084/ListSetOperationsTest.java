package com.mycompany.hw5_mehmed_mustafa_131044084;

import java.util.ArrayList;
import java.util.List;
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
public class ListSetOperationsTest {
    
    public ListSetOperationsTest() {
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
     * Test of intersectionOfLists method, of class ListSetOperations.
     */
    @Test
    public void testIntersectionOfLists() {
        System.out.println("intersectionOfLists");
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(2);
        arr1.add(2);
        arr1.add(4);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        ListSetOperations instance = new ListSetOperations(arr1, arr2);
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(2);
        arr3.add(4);
        List expResult = arr3;
        List result = instance.intersectionOfLists();
        assertEquals(expResult, result);
    }

    /**
     * Test of unionOfLists method, of class ListSetOperations.
     */
    @Test
    public void testUnionOfLists() {
        System.out.println("unionOfLists");
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(2);
        arr1.add(4);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);        
        ListSetOperations instance = new ListSetOperations(arr1, arr2);
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(0);
        arr3.add(1);
        arr3.add(3);
        arr3.add(2);
        arr3.add(4);
        List expResult = arr3;
        List result = instance.unionOfLists();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSubset method, of class ListSetOperations.
     */
    @Test
    public void testIsSubset() {
        System.out.println("isSubset");
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);       
        ListSetOperations instance = new ListSetOperations(arr1, arr2);
        boolean expResult = true;
        boolean result = instance.isSubset();
        assertEquals(expResult, result);
    }
    
}
