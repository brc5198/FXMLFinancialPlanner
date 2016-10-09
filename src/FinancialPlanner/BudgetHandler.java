package FinancialPlanner;

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
    
    public double calculateBudgetsSum()
    {
        double sum = 0.00;
        
        for(int i = 0; i < budgets.size(); i++)
        {
            sum = sum + budgets.get(i).getBudgetAmount();
        }
        
        return sum;
    }
    
    public void setBudgets(ArrayList<Budget> budgets){this.budgets = budgets;}
    
    public ArrayList<Budget> getBudgets(){return budgets;}
}
