/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner;

import financeplanner.controller.BudgetHandler;
import financeplanner.controller.BudgetViewController;
import financeplanner.controller.DashController;
import financeplanner.controller.TransactionHandler;
import financeplanner.controller.TransactionViewController;
import java.sql.SQLException;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
public class FinancePlannerTest {
    
    public FinancePlannerTest() {
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
     * Test of start method, of class FinancePlanner.
     */
    @Test
    public void testStart() throws SQLException {
        System.out.println("start");
        Stage primaryStage = null;
        FinancePlanner instance = new FinancePlanner();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showDashWindow method, of class FinancePlanner.
     */
    @Test
    public void testShowDashWindow() {
        System.out.println("showDashWindow");
        FinancePlanner instance = new FinancePlanner();
        instance.showDashWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTransactionWindow method, of class FinancePlanner.
     */
    @Test
    public void testShowTransactionWindow() {
        System.out.println("showTransactionWindow");
        FinancePlanner instance = new FinancePlanner();
        instance.showTransactionWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showBudgetWindow method, of class FinancePlanner.
     */
    @Test
    public void testShowBudgetWindow() {
        System.out.println("showBudgetWindow");
        FinancePlanner instance = new FinancePlanner();
        instance.showBudgetWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showHistoryWindow method, of class FinancePlanner.
     */
    @Test
    public void testShowHistoryWindow() {
        System.out.println("showHistoryWindow");
        FinancePlanner instance = new FinancePlanner();
        instance.showHistoryWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeWindows method, of class FinancePlanner.
     */
    @Test
    public void testRemoveWindows() {
        System.out.println("removeWindows");
        FinancePlanner instance = new FinancePlanner();
        instance.removeWindows();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRootLayout method, of class FinancePlanner.
     */
    @Test
    public void testGetRootLayout() {
        System.out.println("getRootLayout");
        FinancePlanner instance = new FinancePlanner();
        BorderPane expResult = null;
        BorderPane result = instance.getRootLayout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactionHandler method, of class FinancePlanner.
     */
    @Test
    public void testGetTransactionHandler() {
        System.out.println("getTransactionHandler");
        FinancePlanner instance = new FinancePlanner();
        TransactionHandler expResult = null;
        TransactionHandler result = instance.getTransactionHandler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetHandler method, of class FinancePlanner.
     */
    @Test
    public void testGetBudgetHandler() {
        System.out.println("getBudgetHandler");
        FinancePlanner instance = new FinancePlanner();
        BudgetHandler expResult = null;
        BudgetHandler result = instance.getBudgetHandler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactionControl method, of class FinancePlanner.
     */
    @Test
    public void testGetTransactionControl() {
        System.out.println("getTransactionControl");
        FinancePlanner instance = new FinancePlanner();
        TransactionViewController expResult = null;
        TransactionViewController result = instance.getTransactionControl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetControl method, of class FinancePlanner.
     */
    @Test
    public void testGetBudgetControl() {
        System.out.println("getBudgetControl");
        FinancePlanner instance = new FinancePlanner();
        BudgetViewController expResult = null;
        BudgetViewController result = instance.getBudgetControl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDashControl method, of class FinancePlanner.
     */
    @Test
    public void testGetDashControl() {
        System.out.println("getDashControl");
        FinancePlanner instance = new FinancePlanner();
        DashController expResult = null;
        DashController result = instance.getDashControl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FinancePlanner.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FinancePlanner.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
