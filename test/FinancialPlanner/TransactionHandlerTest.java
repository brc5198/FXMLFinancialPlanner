/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stevenburns
 */
public class TransactionHandlerTest {
    
    public TransactionHandlerTest() {
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
     * Test of getTransactionHistory method, of class TransactionHandler.
     */
    @Test
    public void testGetTransactionHistory() {
        System.out.println("getTransactionHistory");
        TransactionHandler instance = new TransactionHandler();
        ArrayList<Transaction> expResult = null;
        ArrayList<Transaction> result = instance.getTransactionHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
