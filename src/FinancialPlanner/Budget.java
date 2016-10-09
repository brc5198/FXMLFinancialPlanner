<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.util.ArrayList;

/**
 *
 * @author Marchetti
 */
public class Budget {
    
    private String name;
    
    // TODO -- should make dates into proper Date formats...to do later.
    private String startDate;
    private String endDate;
    
    private double amount;
    private ArrayList<Transaction> transactions;
        
    
    public Budget(String name, String startDate, String endDate, double amount) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        
        // initialize ArrayList
        this.transactions = new ArrayList<>();
    
        //Budget b = new Budget("Dining", "March 1", "March 31", 125.00);
    }
    
    
    public String getBudgetName(){
        return this.name;
    }
    
    public String getBudgetStartDate(){
        return this.startDate;
    }
    
    public String getBudgetEndDate(){
        return this.endDate;
    }
    
    public double getBudgetAmount(){
        return this.amount;
    }
    
    public ArrayList<Transaction> getBudgetTransactions(){
        return transactions;
    }
    
    public void setBudgetName(String newName){
        this.name = newName;
    }
    
    
    public void setBudgetStartDate(String newStartDate){
        this.startDate = newStartDate;
    }    
    
    public void setBudgetEndDate(String newEndDate){
        this.endDate = newEndDate;
    }
    
    public void setBudgetAmount(double newAmount){
        this.amount = newAmount;
    }
    
    /** 
     *  Adds new Transaction objects to the arraylist within budget
     * @param t 
     */
    public void addToTransactions(Transaction t){
        this.transactions.add(t);        
    }
}
=======
package FinancialPlanner;

import java.util.ArrayList;

public class Budget
{
    private String name;
    private String startTime;
    private String endTime;
    private double amount;
    private ArrayList<Transaction> transactions;
    
    public Budget()
    {
        transactions = new ArrayList<Transaction>();
    }
    
    public void setName(String name){this.name = name;}
    public void setStartTime(String startTime){this.startTime = startTime;}
    public void setEndTime(String endTime){this.endTime = endTime;}
    public void setAmount(double amount){this.amount = amount;}
    public void setTransactions(ArrayList<Transaction> transactions){this.transactions = transactions;}
    
    public String getName(){return name;}
    public String getStartTime(){return startTime;}
    public String getEndTime(){return endTime;}
    public double getAmount(){return amount;}
    public ArrayList<Transaction> getTransactions(){return transactions;}
}
>>>>>>> 9c6c5337a66c9b432732fb674d4ed15303f4f576
