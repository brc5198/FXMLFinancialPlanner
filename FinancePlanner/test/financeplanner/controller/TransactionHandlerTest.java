/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Transaction;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
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
     * Test of createNewTransaction method, of class TransactionHandler.
     */
    @Test
    public void testCreateNewTransaction() throws SQLException {
        System.out.println("createNewTransaction");
        double amount = 0.0;
        String timeStamp = "";
        String location = "";
        TransactionHandler instance = new TransactionHandler();
        Transaction expResult = new Transaction();
        Transaction result = instance.createNewTransaction(0, amount, timeStamp, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTransactions method, of class TransactionHandler.
     */
    @Test
    public void testSetTransactions() throws SQLException {
        System.out.println("setTransactions");
        ArrayList<Transaction> transactions = null;
        TransactionHandler instance = new TransactionHandler();
        instance.setTransactions(transactions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactions method, of class TransactionHandler.
     */
    @Test
    public void testGetTransactions() throws SQLException {
        System.out.println("getTransactions");
        TransactionHandler instance = new TransactionHandler();
        ArrayList<Transaction> expResult = new ArrayList();
        ArrayList<Transaction> result = instance.getTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
