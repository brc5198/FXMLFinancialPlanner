/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Budget;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bradcaviston
 */
public class BudgetHandlerTest {
    
    public BudgetHandlerTest() {
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
     * Test of createNewBudget method, of class BudgetHandler.
     */
    @Test
    public void testCreateNewBudget() {
        System.out.println("createNewBudget");
        String name = "testName";
        String startTime = "testTime";
        String endTime = "testTime";
        double amount = 0.0;
        BudgetHandler instance = new BudgetHandler();
        Budget expResult = null;
        Budget result = instance.createNewBudget(name, startTime, endTime, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateBudgetsSum method, of class BudgetHandler.
     */
    @Test
    public void testCalculateBudgetsSum() {
        System.out.println("calculateBudgetsSum");
        BudgetHandler instance = new BudgetHandler();
        double expResult = 0.0;
        double result = instance.calculateBudgetsSum();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateBudgetRemainder method, of class BudgetHandler.
     */
    @Test
    public void testCalculateBudgetRemainder() {
        System.out.println("calculateBudgetRemainder");
        Budget budget = null;
        double expResult = 0.0;
        double result = BudgetHandler.calculateBudgetRemainder(budget);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateBudgetRemainderPercent method, of class BudgetHandler.
     */
    @Test
    public void testCalculateBudgetRemainderPercent() {
        System.out.println("calculateBudgetRemainderPercent");
        Budget budget = null;
        double expResult = 0.0;
        double result = BudgetHandler.calculateBudgetRemainderPercent(budget);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBudgets method, of class BudgetHandler.
     */
    @Test
    public void testSetBudgets() {
        System.out.println("setBudgets");
        ArrayList<Budget> budgets = new ArrayList();
        BudgetHandler instance = new BudgetHandler();
        instance.setBudgets(budgets);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getBudgets(), budgets);
    }

    /**
     * Test of getBudgets method, of class BudgetHandler.
     */
    @Test
    public void testGetBudgets() {
        System.out.println("getBudgets");
        BudgetHandler instance = new BudgetHandler();
        ArrayList<Budget> expResult = null;
        ArrayList<Budget> result = instance.getBudgets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
