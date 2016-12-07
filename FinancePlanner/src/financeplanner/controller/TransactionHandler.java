/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Transaction;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Responsible for creating and temporarily storing transactions
 */
final public class TransactionHandler
{
    private static ArrayList<Transaction> transactions;
    
    private Connector theConnector;
    
    public TransactionHandler() throws SQLException
    {
        transactions = new ArrayList();
        
        try
        {
            theConnector = new Connector();
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        
        transactions.addAll(theConnector.populateTransactionArrayList());
        /**
        Something like this would be how to start this

        * try{
            System.out.println("TRY");
            Connector db = new Connector();
            db.addNewTransaction();
        } catch(SQLException sql1){
            sql1.printStackTrace();
        }
        **/
        
        /**
        try {
            //transactions = theConnector.populateTransactionArrayList();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionHandler.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        */
    }
    
    public Transaction createNewTransaction(int budgetId, double amount, String timeStamp, String location) throws SQLException
    {
        Transaction newTransaction = new Transaction();
        
        newTransaction.setAmount(amount);
        newTransaction.setBudgetID(budgetId);
        
        if(timeStamp == null)
        {
            newTransaction.setTimeStamp(getCurrentTime());
        }
        else
        {
            newTransaction.setTimeStamp(timeStamp);
        }
        
        if(location == null)
        {
            newTransaction.setLocation("");
        }
        else
        {
            newTransaction.setLocation(location);
        }
        
        transactions.add(newTransaction);
        theConnector.addNewTransaction(newTransaction);
        return newTransaction;
    }
    
    public Transaction editTransaction(int index, int budgetId, double amount, String timeStamp, String location) throws SQLException
    {
        Transaction newTransaction = transactions.get(index);
        
        newTransaction.setAmount(amount);
        newTransaction.setBudgetID(budgetId);
        
        if(timeStamp == null)
        {
            newTransaction.setTimeStamp(getCurrentTime());
        }
        else
        {
            newTransaction.setTimeStamp(timeStamp);
        }
        
        if(location == null)
        {
            newTransaction.setLocation("");
        }
        else
        {
            newTransaction.setLocation(location);
        }
        
        theConnector.updateTransaction(newTransaction);
        return newTransaction;
    }
    
    /*
    Returns current time
    */
    private String getCurrentTime()
    {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        return currentTime;
    }
    
    public void setTransactions(ArrayList<Transaction> transactions){this.transactions = transactions;}
    
    public ArrayList<Transaction> getTransactions(){return transactions;}
}
