package financeplanner.model;

/**
 *
 * @author Ardjen
 */
public class User 
{
    private int userID;
    private String firstName;
    private String lastName;
    
    public User()
    {
        
    }
    
    //Setters
    public void setUserID(int userID){this.userID = userID;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    
    //Getters
    public int getUsesrID(){return userID;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
}
