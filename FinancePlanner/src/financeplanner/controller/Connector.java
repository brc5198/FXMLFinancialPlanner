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

    
    public static ArrayList<Budget> populateBudgetArrayList() throws SQLException{
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

   
}
