/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.model;

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
     * Test of setAmount method, of class Transaction.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        double amount = 0.0;
        Transaction instance = new Transaction();
        instance.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getAmount(), amount);
    }

    /**
     * Test of setTimeStamp method, of class Transaction.
     */
    @Test
    public void testSetTimeStamp() {
        System.out.println("setTimeStamp");
        String timeStamp = "testTime";
        Transaction instance = new Transaction();
        instance.setTimeStamp(timeStamp);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getTimeStamp(), timeStamp);
    }

    /**
     * Test of setLocation method, of class Transaction.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "testLocation";
        Transaction instance = new Transaction();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getLocation(), location);
    }

    /**
     * Test of getAmount method, of class Transaction.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Transaction instance = new Transaction();
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTimeStamp method, of class Transaction.
     */
    @Test
    public void testGetTimeStamp() {
        System.out.println("getTimeStamp");
        Transaction instance = new Transaction();
        String expResult = "testTime";
        String result = instance.getTimeStamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLocation method, of class Transaction.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Transaction instance = new Transaction();
        String expResult = "testLocation";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
