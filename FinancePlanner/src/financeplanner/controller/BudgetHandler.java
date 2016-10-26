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
    
    private Connector theConnector = new Connector();
    
    public BudgetHandler()
    {
        try {
            budgets = theConnector.populateBudgetArrayList();
        } catch (SQLException ex) {
            Logger.getLogger(BudgetHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Budget requestNewBudget(int id, String name, String startTime, String endTime, double amount)
    {
        Budget newBudget = new Budget();
        
        newBudget.setBudgetID(id);
        
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
        return newBudget;
    }
    /*
    Given a list of budgets, calculates the sum of all the budget limits
    */
    public double calculatBudgetsSum()
    {
        double sum = 0.00;
        
        for(int i = 0; i < budgets.size(); i++)
        {
            sum = sum + budgets.get(i).getAmount();
        }
        
        return sum;
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
