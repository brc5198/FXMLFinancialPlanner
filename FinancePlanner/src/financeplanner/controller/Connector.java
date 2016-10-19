/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeplanner.controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

   
}
