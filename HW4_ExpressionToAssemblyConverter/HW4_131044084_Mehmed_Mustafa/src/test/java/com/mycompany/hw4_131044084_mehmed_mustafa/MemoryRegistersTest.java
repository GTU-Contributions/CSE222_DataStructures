/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw4_131044084_mehmed_mustafa;

import com.mycompany.hw4_131044084_mehmed_mustafa.MemoryRegisters.Register;
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
public class MemoryRegistersTest {
    
    public MemoryRegistersTest() {
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
     * Test of getFreeReg method, of class MemoryRegisters.
     */
    @Test
    public void testGetFreeReg() {
        System.out.println("getFreeReg");
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t0");
        MemoryRegisters.Register result = instance.getFreeReg();
        assertEquals(expResult, result);
    }

    /**
     * Test of findVariableReg method, of class MemoryRegisters.
     */
    @Test
    public void testFindVariableReg() {
        System.out.println("findVariableReg");
        String varName = "";
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = null;
        MemoryRegisters.Register result = instance.findVariableReg(varName);
        assertEquals(expResult, result);
    }

    /**
     * Test of freeRegister method, of class MemoryRegisters.
     */
    @Test
    public void testFreeRegister() {
        System.out.println("freeRegister");
        MemoryRegisters.Register regToFree = null;
        MemoryRegisters instance = new MemoryRegisters();
        instance.freeRegister(regToFree);
    }

    /**
     * Test of load method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoad_int() throws Exception {
        System.out.println("load");
        int value = 0;
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t0");
        MemoryRegisters.Register result = instance.load(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of load method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoad_String_int() throws Exception {
        System.out.println("load");
        String varName = "";
        int value = 0;
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t0");
        expResult = instance.load(value);
        expResult.setVarName(varName);
        MemoryRegisters.Register result = instance.load(varName, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testMove_MemoryRegistersRegister_MemoryRegistersRegister() throws Exception {
        System.out.println("move");
        MemoryRegisters.Register moveTo = new Register("$t0");
        MemoryRegisters.Register fromWhere = new Register("$t1");
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t0");
        MemoryRegisters.Register result = instance.move(moveTo, fromWhere);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testMove_3args() throws Exception {
        System.out.println("move");
        MemoryRegisters.Register moveTo = new Register("$t3");
        String regVarName = "a";
        MemoryRegisters.Register fromWhere = new Register("$t4");
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t3");
        MemoryRegisters.Register result = instance.move(moveTo, regVarName, fromWhere);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        MemoryRegisters.Register lhs = new Register("$t0");
        lhs.setRegValue(5);
        MemoryRegisters.Register rhs = new Register("$t1");
        rhs.setRegValue(3);
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t2");
        expResult.setRegValue(8);
        MemoryRegisters.Register result = instance.add(lhs, rhs);
        assertEquals(expResult, result);
    }

    /**
     * Test of sub method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testSub() throws Exception {
        System.out.println("sub");
        MemoryRegisters.Register lhs = new Register("$t0");
        lhs.setRegValue(8);
        MemoryRegisters.Register rhs = new Register("$t1");
        rhs.setRegValue(4);
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t2");
        expResult.setRegValue(4);
        MemoryRegisters.Register result = instance.sub(lhs, rhs);
        assertEquals(expResult, result);
    }

    /**
     * Test of mult method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testMult() throws Exception {
        System.out.println("mult");
        MemoryRegisters.Register lhs = new Register("$t0");
        lhs.setRegValue(7);
        MemoryRegisters.Register rhs = new Register("$t1");
        rhs.setRegValue(2);
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t2");
        expResult.setRegValue(14);
        MemoryRegisters.Register result = instance.mult(lhs, rhs);
        assertEquals(expResult, result);
    }

    /**
     * Test of div method, of class MemoryRegisters.
     * @throws java.lang.Exception
     */
    @Test
    public void testDiv() throws Exception {
        System.out.println("div");
        MemoryRegisters.Register lhs = new Register("$t0");
        lhs.setRegValue(11);
        MemoryRegisters.Register rhs = new Register("$t1");
        rhs.setRegValue(4);
        MemoryRegisters instance = new MemoryRegisters();
        MemoryRegisters.Register expResult = new Register("$t2");
        expResult.setRegValue(2);
        MemoryRegisters.Register result = instance.div(lhs, rhs);
        assertEquals(expResult, result);
    }

    /**
     * Test of print method, of class MemoryRegisters.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        MemoryRegisters.Register regToPrint = new Register("$t5");
        MemoryRegisters instance = new MemoryRegisters();
        String expResult = "move\t$a0, $t5\nli\t$v0, 1\nsyscall\n";
        String result = instance.print(regToPrint);
        assertEquals(expResult, result);
    }
    
}
