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
    
    public User(int newUserID, String newFirstName, String newLastName) {
        userID = newUserID;
        firstName = newFirstName;
        lastName = newLastName;
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
