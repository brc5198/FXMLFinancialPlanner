/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.model.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Ardjen
 */
public class TransactionHandler
{
    private ArrayList<Transaction> transactions;
    
    public TransactionHandler()
    {
        transactions = new ArrayList<Transaction>();
    }
    
    public void setTransactions(ArrayList<Transaction> transactions){this.transactions = transactions;}
    
    public ArrayList<Transaction> getTransactions(){return transactions;}
}
