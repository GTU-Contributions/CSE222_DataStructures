/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw3_mehmed_mustafa_131044084;

import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author mmustafa
 */
public class SpecListTest {
    
    public SpecListTest() {
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
     * Test of addAllAtHead method, of class SpecList.
     */
    @org.junit.Test
    public void testAddAllAtHead() {
        System.out.println("addAllAtHead");
        Collection c = null;
        SpecList instance = new SpecList();
        instance.add(7);
        instance.add(3);
        instance.add(2);
        instance.add(4);
        instance.add(5);
        boolean expResult = false;
        boolean result = instance.addAllAtHead(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIntersectList method, of class SpecList.
     */
    @org.junit.Test
    public void testGetIntersectList() {
        System.out.println("getIntersectList");
        Collection c = new SpecList();
        c.add(5);
        c.add(3);
        c.add(6);
        c.add(1);
        c.add(8);
        c.add(9);        
        SpecList instance = new SpecList();
        instance.add(5);
        instance.add(1);
        instance.add(8);
        instance.add(14);
        instance.add(16);
        SpecList intersect = new SpecList();
        intersect.add(5);
        intersect.add(1);
        intersect.add(8);
        List expResult = intersect;
        List result = instance.getIntersectList(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortList method, of class SpecList.
     */
    @org.junit.Test
    public void testSortList_0args() {
        System.out.println("sortList");
        SpecList instance = new SpecList();
        instance.add(5);
        instance.add(3);
        instance.add(6);
        instance.add(1);
        instance.add(8);
        instance.add(9);
        List expResult = new SpecList();
        expResult.add(1);
        expResult.add(3);
        expResult.add(5);
        expResult.add(6);
        expResult.add(8);
        expResult.add(9);
        List result = instance.sortList();
        assertEquals(expResult, result);
    }

    /**
     * Test of sortList method, of class SpecList.
     */
    @org.junit.Test
    public void testSortList_int() {
        System.out.println("sortList");
        int ignoreMe = 0;
        SpecList instance = new SpecList();
        instance.add(5);
        instance.add(3);
        instance.add(6);
        instance.add(1);
        instance.add(8);
        instance.add(9);
        List expResult = new SpecList();
        expResult.add(9);
        expResult.add(8);
        expResult.add(6);
        expResult.add(5);
        expResult.add(3);
        expResult.add(1);
        List result = instance.sortList(ignoreMe);
        assertEquals(expResult, result);
    }
    
}
