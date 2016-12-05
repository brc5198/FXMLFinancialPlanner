/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Budget;
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
     * Test of calculateBudgetRemainder method, of class BudgetHandler.
     */
    @Test
    public void testCalculateBudgetRemainder() throws SQLException{
        System.out.println("calculateBudgetRemainder");
        BudgetHandler bh1 = new BudgetHandler();
        Budget budget = bh1.createNewBudget("name", "10-10-1002", "10-10-2011", 5.00);
        double expResult = 5.0;
        double result = BudgetHandler.calculateBudgetRemainder(budget);
        assertEquals(expResult, result, 5.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateBudgetRemainderPercent method, of class BudgetHandler.
     */
    @Test
    public void testCalculateBudgetRemainderPercent() throws SQLException {
        System.out.println("calculateBudgetRemainderPercent");
        BudgetHandler bh1 = new BudgetHandler();
        Budget budget = bh1.createNewBudget("name", "10-10-1002", "10-10-2011", 5.00);
        double expResult = 1.0;
        double result = BudgetHandler.calculateBudgetRemainderPercent(budget);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}