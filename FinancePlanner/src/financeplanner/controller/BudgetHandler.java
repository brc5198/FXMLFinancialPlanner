/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Budget;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * BudgetHandler is responsible for create and temporarily storing new budgets
 */
final public class BudgetHandler
{
    private static ArrayList<Budget> budgets;
    
    private Connector theConnector;
    
    public BudgetHandler() throws SQLException
    {
        budgets = new ArrayList();
        
        try
        {
            theConnector = new Connector();
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        
        budgets.addAll(theConnector.populateBudgetArrayList(1));
        
        /**
        Something like this would be how to start this

        * try{
            System.out.println("TRY");
            Connector db = new Connector();
            db.addNewBudget();
        } catch(SQLException sql1){
            sql1.printStackTrace();
        }
        **/
        
        /**
        try {
            budgets = theConnector.populateBudgetArrayList();
            
        } catch (SQLException ex) {
            Logger.getLogger(BudgetHandler.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        */
    }
    
    /**
     * Creates a new budget and automatically adds it to the Budgets ArrayList
     * @param name
     * @param startTime
     * @param endTime
     * @param amount
     * @return 
     */
    public Budget createNewBudget(String name, String startTime, String endTime, double amount) throws SQLException
    {
        Budget newBudget = new Budget();
        
        if(name == null)
        {
            newBudget.setName("New Budget");
        }
        else
        {
            newBudget.setName(name);
        }
        
        if(startTime == null)
        {
            newBudget.setStartTime(getCurrentTime());
        }
        else
        {
            newBudget.setStartTime(startTime);
        }
        
        if(endTime == null)
        {
            newBudget.setEndTime(getCurrentTime());
        }
        else
        {
            newBudget.setEndTime(startTime);
        }
        
        newBudget.setAmount(amount);
        
        budgets.add(newBudget);
        theConnector.addNewBudget(newBudget);
        return newBudget;
    }
    /*
    Given a list of budgets, calculates the sum of all the budget limits
    */
    public double calculateBudgetsSum()
    {
        double sum = 0.00;
        
        for(int i = 0; i < budgets.size(); i++)
        {
            sum = sum + budgets.get(i).getAmount();
        }
        
        return sum;
    }
    
    public static double calculateBudgetRemainder(Budget budget)
    {
        double remainder = budget.getAmount();
        
        for(int i = 0; i < budget.getTransactions().size(); i++)
        {
            remainder = remainder - budget.getTransactions().get(i).getAmount();
        }
        
        return remainder;
    }
    
    public static double calculateBudgetRemainderPercent(Budget budget)
    {
        double percent = 0;
        double amount = budget.getAmount();
        double remainder = calculateBudgetRemainder(budget);
        percent = (remainder / amount);
        
        if(percent < 0)
        {
            percent = 0;
        }
        
        return percent;
    }
    
    /*
    Returns current time
    */
    private String getCurrentTime()
    {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        return currentTime;
    }
    
    public void setBudgets(ArrayList<Budget> budgets){this.budgets = budgets;}
    
    public ArrayList<Budget> getBudgets(){return budgets;}
}
