/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeplanner.controller;

import financeplanner.model.Transaction;
import financeplanner.model.Budget;
import financeplanner.model.User;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author sab5964
 * @author marchetti
 */
public class Connector {
    
    private Connection conn;
    private Statement statement;

    public Connector() throws SQLException{
        this.conn = ConnectionToMySql();
        this.statement = conn.createStatement();
    }

    public static void connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e1){
            System.out.println("Connection error.");
            e1.printStackTrace();
        }
    }

    //Connect to database
    public static Connection ConnectionToMySql(){
        connection();
        String host = "jdbc:mysql://updb1.up.ist.psu.edu/bvm5284";
        String username = "bvm5284";
        String password = "ENAJrPDT";

        try {
            Connection connect = DriverManager.getConnection(host, username, password);
            
            // TEST PRINT OUT
            System.out.println("Connection Successful");
            return connect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
//    static  String host = "jdbc:derby://updb1.up.ist.psu.edu/bvm5284";
//    static  String uName = "bvm5284";
//    static  String uPassword = "ENAJrPDT";
//    static Connection conn = null;
//    static Statement stmt = null;

//    public static void connecting(){
//        try {
//            System.out.println("Connecting to the database...");
//            conn = DriverManager.getConnection (host, uName, uPassword);
//            
//            System.out.println("creating a statement...");
//            stmt = conn.createStatement();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    
    public ArrayList<Budget> populateBudgetArrayList(int user_ID) throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT B.Budget_ID, B.name, B.StartTime, B.EndTime, B.amount FROM BUDGET AS B WHERE User_ID = " + user_ID + ";"); //returns a ResultSet based on the statement query

        ArrayList<Budget> budgetList = new ArrayList<Budget>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("Budget_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            String budgetName = rs.getString("Name");
            String startTime = rs.getString("StartTime");
            String endTime = rs.getString("EndTime");
            double amount = rs.getDouble("amount");

            Budget i1 = new Budget(id, budgetName, startTime, endTime, amount);
            budgetList.add(i1);
        }
        conn.close();
        return budgetList;
    }

    
      public ArrayList<Transaction> populateBudgetTransactionArrayList(int budgetID) throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from Transaction WHERE Budget_ID = " + budgetID + ";"); //returns a ResultSet based on the statement query

        ArrayList<Transaction> transList = new ArrayList<Transaction>();

        //Reads column by column extracting data
        while(rs.next()){
            
            int id = rs.getInt("Transaction_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            Double amount = rs.getDouble("amount"); //Same thing...different column
            String transDate = rs.getString("transaction_date");
            String location = rs.getString("location");
            int budget_ID = rs.getInt("Budget_ID");
            
            Transaction t = new Transaction(id, amount, transDate, location, budget_ID);
            transList.add(t);
        }
        conn.close();
        return transList;
    }
      
    public ArrayList<Transaction> populateTransactionArrayList() throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from Transaction"); //returns a ResultSet based on the statement query

        ArrayList<Transaction> transList = new ArrayList<Transaction>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("Transaction_ID");
            Double amount = rs.getDouble("amount"); //Same thing...different column
            String transDate = rs.getString("transaction_date");
            String location = rs.getString("location");
            int budget_ID = rs.getInt("Budget_ID");
            
            Transaction t = new Transaction(id, amount, transDate, location, budget_ID);
            transList.add(t);
        }
        conn.close();
        return transList;
    }
      
      
    public ArrayList<User> populateUserArrayList() throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from User"); //returns a ResultSet based on the statement query

        ArrayList<User> userList = new ArrayList<User>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("User_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            String firstName = rs.getString("FirstName"); //Same thing...different column
            String lastName = rs.getString("LastName");

            User theUser = new User(id, firstName, lastName);
            userList.add(theUser);
        }
        conn.close();
        return userList;
    }
      
      
    public static void addNewTransaction(Transaction t1) throws SQLException{

        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();
        
        String query = "INSERT into Transaction (amount, transaction_date, location, Budget_ID)" + "values (?, ?, ?, ?)";
            
        //print out for verification
        System.out.println(query);
                
            
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, t1.getAmount());
        ps.setString(2, t1.getTimeStamp());
        ps.setString(3, t1.getLocation());
        ps.setInt(4, t1.getBudgetID());
                
        //run prepared statement
        ps.execute();
            
        conn.close();
     
    }
    
    public void updateTransaction(Transaction t1) throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();

        String updateStatement = "UPDATE Transaction SET amount = ?, transaction_date = ?, location = ?, Budget_ID = ? WHERE Transaction_ID = ?";
        PreparedStatement ps = conn.prepareStatement(updateStatement);

        ps.setDouble(1, t1.getAmount());
        ps.setString(2, t1.getTimeStamp());
        ps.setString(3, t1.getLocation());
        ps.setInt(4, t1.getBudgetID());
        ps.setInt(5, t1.getTransactionID());
        
        ps.execute();
        conn.close();
    }
    
    public void deleteTransaction(Transaction t1) throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();

        String deleteStatement = "DELETE from Transaction WHERE Transaction_ID = ?";
        PreparedStatement ps = conn.prepareStatement(deleteStatement);

        ps.setDouble(1, t1.getTransactionID());
        
        ps.execute();
        conn.close();
        
    }
      
    public static void addNewBudget(Budget b1) throws SQLException{

        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();
            
        String query = "INSERT into Budget (Name,StartTime, EndTime, amount, User_ID)" + "values (?,?,?,?,?)";
        System.out.println(query);
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, b1.getName());
        ps.setString(2, b1.getStartTime());
        ps.setString(3, b1.getEndTime());
        ps.setDouble(4, b1.getAmount());
        ps.setInt(5,1);
                
        ps.execute();
        conn.close();

    }
    
        public void updateBudget(Budget b1) throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();

        String updateStatement = "UPDATE Budget SET name = ?, StartTime = ?, EndTime = ?, amount = ? WHERE Budget_ID = ?";
        PreparedStatement ps = conn.prepareStatement(updateStatement);

        ps.setString(1, b1.getName());
        ps.setString(2, b1.getStartTime());
        ps.setString(3, b1.getEndTime());
        ps.setDouble(4, b1.getAmount());
        ps.setInt(5, b1.getID());
        
        
        ps.execute();
        conn.close();
    }
    
        public static void deleteBudget(Budget b1) throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();

        String deleteStatement = "DELETE from Budget WHERE Budget_ID = ?";
        PreparedStatement ps = conn.prepareStatement(deleteStatement);

        ps.setDouble(1, b1.getID());
        
        ps.execute();
        conn.close();
        
    }    
        
        
    public static void addNewUser(User u1) throws SQLException{


        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();
            
        String query = "INSERT into User (FirstName, LastName)" + "values (?, ?)";
        System.out.println(query);
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, u1.getFirstName());
        ps.setString(2, u1.getLastName());
                
        ps.execute();
        conn.close();

    }
   
}
