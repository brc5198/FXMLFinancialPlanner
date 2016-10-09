/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.time.LocalDate;
import javafx.beans.property.StringProperty;
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
public class TransactionTest {
    
    public TransactionTest() {
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
     * Test of getAmount method, of class Transaction.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Transaction instance = null;
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountProperty method, of class Transaction.
     */
    @Test
    public void testGetAmountProperty() {
        System.out.println("getAmountProperty");
        Transaction instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.getAmountProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeStamp method, of class Transaction.
     */
    @Test
    public void testGetTimeStamp() {
        System.out.println("getTimeStamp");
        Transaction instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getTimeStamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeStampProperty method, of class Transaction.
     */
    @Test
    public void testGetTimeStampProperty() {
        System.out.println("getTimeStampProperty");
        Transaction instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.getTimeStampProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Transaction.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocationProperty method, of class Transaction.
     */
    @Test
    public void testGetLocationProperty() {
        System.out.println("getLocationProperty");
        Transaction instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.getLocationProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
