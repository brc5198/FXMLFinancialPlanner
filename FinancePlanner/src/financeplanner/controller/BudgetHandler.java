/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Budget;
import java.util.ArrayList;

/**
 *
 * @author Ardjen
 */
public class BudgetHandler
{
    private ArrayList<Budget> budgets;
    
    public BudgetHandler()
    {
        budgets = new ArrayList<Budget>();
    }
    
    public double calculatBudgetsSum()
    {
        double sum = 0.00;
        
        for(int i = 0; i < budgets.size(); i++)
        {
            sum = sum + budgets.get(i).getAmount();
        }
        
        return sum;
    }
    
    public void setBudgets(ArrayList<Budget> budgets){this.budgets = budgets;}
    
    public ArrayList<Budget> getBudgets(){return budgets;}
}
