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
 */
public class Connector {
    
    
    static  String host = "jdbc:derby://localhost:8889/BUDGETING";
    static  String uName = "Budgeting";
    static  String uPassword = "v5h7MWnEFBf7aLna";
    static Connection conn = null;
    static Statement stmt = null;


  

    public static void connecting(){
        try {
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection (host, uName, uPassword);
            
            System.out.println("creating a statement...");
            stmt = conn.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

 
    }

    
    public ArrayList<Budget> populateBudgetArrayList() throws SQLException{
        connecting();
//        Statement stmt = connect.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from BUDGET"); //returns a ResultSet based on the statement query

        ArrayList<Budget> itemList = new ArrayList<Budget>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("Budget_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            String budgetName = rs.getString("BudgetName"); //Same thing...different column
            String startTime = rs.getString("StartTime");
            String endTime = rs.getString("EndTime");
            double amount = rs.getDouble("Amount");
            
            BudgetHandler bh = new BudgetHandler();
            Budget b1 = bh.requestNewBudget(id, budgetName, startTime, endTime, amount);
            

//            InventoryItem i1 = new InventoryItem(id, itemName, itemQuantity, productDescription, unitCost, itemPrice);
//            itemList.add(i1);
        }
        conn.close();
        return itemList;
    }

    
      public ArrayList<Transaction> populateTransactionArrayList() throws SQLException{
        connecting();
//      Statement stmt = connect.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from BUDGET"); //returns a ResultSet based on the statement query

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
      
    public static void addNewTransaction(double amount, String transaction_date, String location, int Budget_ID){
        connecting();
        try{
          
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
          
        } catch (Exception e1){
            System.err.println(e1.getMessage());
        }
    }
      
    public static void addNewBudget(int Budget_ID, String Name,String StartTime, String EndTime , double amount){
        connecting();
            
        try {
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

        } catch (SQLException e2) {
            System.err.println(e2.getMessage());
        }
    }   
   
}
