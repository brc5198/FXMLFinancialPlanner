/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
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
public class BudgetViewControllerTest {
    
    public BudgetViewControllerTest() {
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
     * Test of initialize method, of class BudgetViewController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        FinancePlanner app = null;
        BudgetViewController instance = new BudgetViewController();
        instance.initialize(app);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of requestNewBudget method, of class BudgetViewController.
     */
    @Test
    public void testRequestNewBudget() {
        System.out.println("requestNewBudget");
        BudgetViewController instance = new BudgetViewController();
        Budget expResult = new Budget();
        Budget result = instance.requestNewBudget();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
