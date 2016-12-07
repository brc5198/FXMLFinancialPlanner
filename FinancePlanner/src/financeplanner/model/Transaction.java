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
    private int transactionID;
    
    public Transaction()
    {
        
    }
    
    public Transaction(int newTransactionID, double newAmount, String newTimeStamp, String newLocation, int newBudgetID) {
        this.setTransactionID(newTransactionID);
        this.setAmount(newAmount);
        this.setTimeStamp(newTimeStamp);
        this.setLocation(newLocation);
        this.setBudgetID(newBudgetID);
    }
    
    public void setTransactionID(int transactionID){this.transactionID = transactionID;}
    public void setAmount(double amount){this.amount = amount;}
    public void setTimeStamp(String timeStamp){this.timeStamp = timeStamp;}
    public void setLocation(String location){this.location = location;}
    public void setBudgetID(int budgetID){this.budgetID = budgetID;}
    
    public int getTransactionID(){return transactionID;}
    public double getAmount(){return amount;}
    public String getTimeStamp(){return timeStamp;}
    public String getLocation(){return location;}
    public int getBudgetID(){return budgetID;}
}
