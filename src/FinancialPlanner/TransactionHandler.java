/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.util.ArrayList;

/**
 *
 * @author stevenburns
 */
public class TransactionHandler {
    
    private ArrayList<Transaction> transactionHistory = new ArrayList();
    
    public TransactionHandler() {
        
    }
    
    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    
    public String getresult()
    {
        return "working";
    }
    
}
