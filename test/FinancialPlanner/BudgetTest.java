/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marchetti
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

    /**
     * Test of getBudgetName method, of class Budget.
     */
    @Test
    public void testGetBudgetName() {
        System.out.println("getBudgetName");
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        String expResult = "Dining";
        String result = instance.getBudgetName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetStartDate method, of class Budget.
     */
    @Test
    public void testGetBudgetStartDate() {
        System.out.println("getBudgetStartDate");
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        String expResult = "March 1";
        String result = instance.getBudgetStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetEndDate method, of class Budget.
     */
    @Test
    public void testGetBudgetEndDate() {
        System.out.println("getBudgetEndDate");
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        String expResult = "March 31";
        String result = instance.getBudgetEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetAmount method, of class Budget.
     */
    @Test
    public void testGetBudgetAmount() {
        System.out.println("getBudgetAmount");
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        double expResult = 125.00;
        double result = instance.getBudgetAmount();
        assertEquals(expResult, result, 125.00);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetTransactions method, of class Budget.
     */
//    @Test
//    public void testGetBudgetTransactions() {
//        System.out.println("getBudgetTransactions");
//        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
//        instance.addToTransactions(new Transaction(14.99, 2016-10-1, "Chipotle"));
//        ArrayList<Transaction> expResult = null;
//        ArrayList<Transaction> result = instance.getBudgetTransactions();
//        assertEquals(expResult, result);
//        
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setBudgetName method, of class Budget.
     */
    @Test
    public void testSetBudgetName() {
        System.out.println("setBudgetName");
        String newName = "Entertainment";
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        instance.setBudgetName(newName);
        String last = instance.getBudgetName();
        assertEquals(newName, last);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBudgetStartDate method, of class Budget.
     */
    @Test
    public void testSetBudgetStartDate() {
        System.out.println("setBudgetStartDate");
        String newStartDate = "April 1";
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        instance.setBudgetStartDate(newStartDate);
        String last = instance.getBudgetStartDate();
        assertEquals(last, newStartDate);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBudgetEndDate method, of class Budget.
     */
    @Test
    public void testSetBudgetEndDate() {
        System.out.println("setBudgetEndDate");
        String newEndDate = "April 31";
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        instance.setBudgetEndDate(newEndDate);
        String last = instance.getBudgetEndDate();
        assertEquals(last, newEndDate);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBudgetAmount method, of class Budget.
     */
    @Test
    public void testSetBudgetAmount() {
        System.out.println("setBudgetAmount");
        double newAmount = 0.0;
        Budget instance = new Budget("Dining", "March 1", "March 31", 125.00);
        instance.setBudgetAmount(newAmount);
        double last = instance.getBudgetAmount();
        assertEquals(last, newAmount, 0.0);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addToTransactions method, of class Budget.
     */
//    @Test
//    public void testAddToTransactions() {
//        System.out.println("addToTransactions");
//        Transaction t = null;
//        Budget instance = null;
//        instance.addToTransactions(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
