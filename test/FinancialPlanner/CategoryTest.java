/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

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
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of getName method, of class Category.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Category instance = new Category("testName", "testDescription");
        String expResult = "testName";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDescription method, of class Category.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Category instance = new Category("testName", "testDescription");
        String expResult = "testDescription";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
