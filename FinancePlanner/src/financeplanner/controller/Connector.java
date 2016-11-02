/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeplanner.controller;

import financeplanner.model.Transaction;
import financeplanner.model.Budget;

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

    
    public ArrayList<Budget> populateBudgetArrayList() throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from BUDGET WHERE User_ID = 1"); //returns a ResultSet based on the statement query

        ArrayList<Budget> itemList = new ArrayList<Budget>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("Budget_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            String budgetName = rs.getString("BudgetName"); //Same thing...different column
            String startTime = rs.getString("StartTime");
            String endTime = rs.getString("EndTime");
            double amount = rs.getDouble("amount");
            
            BudgetHandler bh = new BudgetHandler();
            Budget b1 = bh.createNewBudget(budgetName, startTime, endTime, amount);
            

//            InventoryItem i1 = new InventoryItem(id, itemName, itemQuantity, productDescription, unitCost, itemPrice);
//            itemList.add(i1);
        }
        conn.close();
        return itemList;
    }

    
      public ArrayList<Transaction> populateTransactionArrayList() throws SQLException{
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from Transaction"); //returns a ResultSet based on the statement query

        ArrayList<Transaction> transList = new ArrayList<Transaction>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("Transactionn_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            Double amount = rs.getDouble("amount"); //Same thing...different column
            String transDate = rs.getString("transaction_date");
            String location = rs.getString("location");
            int budget_ID = rs.getInt("Budget_ID");
            
           // Transaction t = new Transaction(id, amount, transDate, location, budget_ID);
            
           // System.out.println(id + " " + amount);
            
//            InventoryItem i1 = new InventoryItem(id, itemName, itemQuantity, productDescription, unitCost, itemPrice);
//            itemList.add(i1);
        }
        conn.close();
        return transList;
    }
      
    public void addNewTransaction(double amount, String transaction_date, String location, int Budget_ID) throws SQLException{

        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();
        
        String query = "INSERT into Transaction (amount, transaction_date, location, Budget_ID)" + "values (?, ?, ?, ?)";
            
        //print out for verification
        System.out.println(query);
                
            
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setString(2, transaction_date);
        ps.setString(3, location);
        ps.setInt(4, Budget_ID);
                
        //run prepared statement
        ps.execute();
            
        conn.close();
     
    }
      
    public void addNewBudget(int Budget_ID, String Name,String StartTime, String EndTime , double amount) throws SQLException{

        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();
            
        String query = "INSERT into Budget (Budget_ID,Name,StartTime, EndTime, amount, User_ID)" + "values (?,?,?,?, ?)";
        System.out.println(query);
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, Budget_ID);
        ps.setString(2, Name);
        ps.setString(3,StartTime);
        ps.setString(4,EndTime);
        ps.setDouble(5,amount);
        ps.setInt(6,1);
                
        ps.execute();
        conn.close();

    }   
   
}
