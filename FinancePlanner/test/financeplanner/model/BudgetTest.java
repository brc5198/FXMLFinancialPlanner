/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.model;

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
public class BudgetTest {
    
    public BudgetTest() {
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
     * Test of setBudgetID method, of class Budget.
     */
    @Test
    public void testSetBudgetID() {
        System.out.println("setBudgetID");
        int budget_ID = 0;
        Budget instance = new Budget();
        instance.setBudgetID(budget_ID);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getID(), 0);
    }

    /**
     * Test of setName method, of class Budget.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "testName";
        Budget instance = new Budget();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getName(), "testName");
    }

    /**
     * Test of setStartTime method, of class Budget.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        String startTime = "testTime";
        Budget instance = new Budget();
        instance.setStartTime(startTime);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getStartTime(), "testTime");
    }

    /**
     * Test of setEndTime method, of class Budget.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        String endTime = "testTime";
        Budget instance = new Budget();
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getEndTime(), "testTime");
    }

    /**
     * Test of setAmount method, of class Budget.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        double amount = 0.0;
        Budget instance = new Budget();
        instance.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getAmount(), amount);
    }

    /**
     * Test of setTransactions method, of class Budget.
     */
    @Test
    public void testSetTransactions() {
        System.out.println("setTransactions");
        ArrayList<Transaction> transactions = null;
        Budget instance = new Budget();
        instance.setTransactions(transactions);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getTransactions(), transactions);
    }

    /**
     * Test of getID method, of class Budget.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Budget instance = new Budget();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class Budget.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Budget instance = new Budget();
        String expResult = "testName";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStartTime method, of class Budget.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Budget instance = new Budget();
        String expResult = "testTime";
        String result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEndTime method, of class Budget.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Budget instance = new Budget();
        String expResult = "testTime";
        String result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAmount method, of class Budget.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Budget instance = new Budget();
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTransactions method, of class Budget.
     */
    @Test
    public void testGetTransactions() {
        System.out.println("getTransactions");
        Budget instance = new Budget();
        ArrayList<Transaction> expResult = null;
        ArrayList<Transaction> result = instance.getTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
