/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Budget;
import financeplanner.model.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class ConnectorTest {
    
    public ConnectorTest() {
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
     * Test of connection method, of class Connector.
     */
    @Test
    public void testConnection() {
        System.out.println("connection");
        Connector.connection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConnectionToMySql method, of class Connector.
     */
    @Test
    public void testConnectionToMySql() throws SQLException {
        System.out.println("ConnectionToMySql");
        String host = "jdbc:mysql://updb1.up.ist.psu.edu/bvm5284";
        String username = "bvm5284";
        String password = "ENAJrPDT";
        Connection expResult = DriverManager.getConnection(host, username, password);;
        Connection result = Connector.ConnectionToMySql();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of populateBudgetArrayList method, of class Connector.
     */
    @Test
    public void testPopulateBudgetArrayList() throws Exception {
        System.out.println("populateBudgetArrayList");
        Connector instance = new Connector();
        ArrayList<Budget> expResult = new ArrayList();
        ArrayList<Budget> result = instance.populateBudgetArrayList(0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of populateTransactionArrayList method, of class Connector.
     */
    @Test
    public void testPopulateTransactionArrayList() throws Exception {
        System.out.println("populateTransactionArrayList");
        Connector instance = new Connector();
        ArrayList<Transaction> expResult = new ArrayList();
        ArrayList<Transaction> result = instance.populateTransactionArrayList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addNewTransaction method, of class Connector.
     */
    @Test
    public void testAddNewTransaction() throws Exception {
        System.out.println("addNewTransaction");
        double amount = 0.0;
        String transaction_date = "";
        String location = "";
        int Budget_ID = 0;
        Transaction theTransaction = new Transaction(amount, transaction_date, location, Budget_ID);
        boolean worked = true;
        try {
            Connector.addNewTransaction(theTransaction);
        }
        catch(Exception e) {
            worked = false;
        }
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(worked);
    }

    /**
     * Test of addNewBudget method, of class Connector.
     */
    @Test
    public void testAddNewBudget() throws Exception {
        System.out.println("addNewBudget");
        int Budget_ID = 0;
        String Name = "";
        String StartTime = "";
        String EndTime = "";
        double amount = 0.0;
        Budget theBudget = new Budget(0, Name, StartTime, EndTime, amount);
        boolean worked = true;
        try {
            Connector.addNewBudget(theBudget);
        }
        catch(Exception e) {
            worked = false;
        }
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(worked);
    }
    
}
