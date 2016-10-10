/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

/**
 *
 * @author steve
 */
public class TransactionTest {
    
    public TransactionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testgetamount() {
        System.out.println("getamount");
       Transaction instance = new Transaction(10.10,"Walmart");
        String expResult = "10.1";
        double result = instance.getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
        @Test
    public void testgetLocation() {
        System.out.println("getamount");
       Transaction instance = new Transaction(10.10,"Walmart");
        String expResult = "Walmart";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
