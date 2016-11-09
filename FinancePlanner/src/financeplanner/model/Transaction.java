package financeplanner.model;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Responsible for modeling a Transaction
 */
public class Transaction
{
    private double amount;
    private String timeStamp; //This should be formated as YYYY-MM-DDTHH:MM:SS
    private String location;
    private int budgetID;
    
    public Transaction()
    {
        
    }
    
    public void setAmount(double amount){this.amount = amount;}
    public void setTimeStamp(String timeStamp){this.timeStamp = timeStamp;}
    public void setLocation(String location){this.location = location;}
    public void setBudgetID(int budgetID){this.budgetID = budgetID;}
    
    public double getAmount(){return amount;}
    public String getTimeStamp(){return timeStamp;}
    public String getLocation(){return location;}
    public int getBudgetID(){return budgetID;}
}
