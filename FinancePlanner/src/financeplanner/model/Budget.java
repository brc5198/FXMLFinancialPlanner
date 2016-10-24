package financeplanner.model;

import java.util.ArrayList;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Responsible for modeling a budget 
 */
public class Budget
{
    
    private int budget_ID;
    private String name;
    private String startTime;
    private String endTime;
    private double amount;
    private ArrayList<Transaction> transactions;
    
    public Budget()
    {
        transactions = new ArrayList<Transaction>();
    }
    
    public void setBudgetID(int budget_ID){this.budget_ID = budget_ID;}
    public void setName(String name){this.name = name;}
    public void setStartTime(String startTime){this.startTime = startTime;}
    public void setEndTime(String endTime){this.endTime = endTime;}
    public void setAmount(double amount){this.amount = amount;}
    public void setTransactions(ArrayList<Transaction> transactions){this.transactions = transactions;}
    
    public int getID(){return budget_ID;}
    public String getName(){return name;}
    public String getStartTime(){return startTime;}
    public String getEndTime(){return endTime;}
    public double getAmount(){return amount;}
    public ArrayList<Transaction> getTransactions(){return transactions;}
}
