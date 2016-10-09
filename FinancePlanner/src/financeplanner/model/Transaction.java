package financeplanner.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction
{
    private double amount;
    private String timeStamp; //This should be formated as YYYY-MM-DDTHH:MM:SS
    private String location;
    
    public Transaction()
    {
        
    }
    
    public Transaction(double amount, String timeStamp, String location)
    {
        this.amount = amount;
        
        if(timeStamp == null)
        {
            this.timeStamp = this.getCurrentTime();
        }
        else
        {
            this.timeStamp = timeStamp;
        }
        
        if(location == null)
        {
            this.location = "";
        }
        else
        {
            this.location = location;
        }
    }
    
    public String getCurrentTime()
    {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        return currentTime;
    }
    
    public void setAmount(double amount){this.amount = amount;}
    public void setTimeStamp(String timeStamp){this.timeStamp = timeStamp;}
    public void setLocation(String location){this.location = location;}
    
    public double getAmount(){return amount;}
    public String getTimeStamp(){return timeStamp;}
    public String getLocation(){return location;}
}
