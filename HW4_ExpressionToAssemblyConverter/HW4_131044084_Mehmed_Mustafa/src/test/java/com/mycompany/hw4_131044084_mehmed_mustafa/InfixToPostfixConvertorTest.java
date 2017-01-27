/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw4_131044084_mehmed_mustafa;

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
public class InfixToPostfixConvertorTest {
    
    public InfixToPostfixConvertorTest() {
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
     * Test of isOperator method, of class InfixToPostfixConvertor.
     */
    @Test
    public void testIsOperator() {
        System.out.println("isOperator");
        char ch = ' ';
        InfixToPostfixConvertor instance = new InfixToPostfixConvertor();
        boolean expResult = false;
        boolean result = instance.isOperator(ch);
        assertEquals(expResult, result);
    }

    /**
     * Test of precedence method, of class InfixToPostfixConvertor.
     */
    @Test
    public void testPrecedence() {
        System.out.println("precedence");
        char op = ' ';
        InfixToPostfixConvertor instance = new InfixToPostfixConvertor();
        int expResult = -1;
        int result = instance.precedence(op);
        assertEquals(expResult, result);
    }

    /**
     * Test of processOperator method, of class InfixToPostfixConvertor.
     */
    @Test
    public void testProcessOperator() {
        System.out.println("processOperator");
        char op = ' ';
        InfixToPostfixConvertor instance = new InfixToPostfixConvertor();
        instance.processOperator(op);
    }

    /**
     * Test of convert method, of class InfixToPostfixConvertor.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert() throws Exception {
        System.out.println("convert");
        String infix = "a = 5 + 8 * 2 ";
        InfixToPostfixConvertor instance = new InfixToPostfixConvertor();
        String expResult = "a 5 8 2 * + = \n";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }
    
}
