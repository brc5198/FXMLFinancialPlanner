/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
import financeplanner.model.Transaction;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Controller for the Dashboard view
 */
public class DashController
{
    @FXML private Button transactionButton;
    @FXML private Button budgetButton;
    @FXML private Button historyButton;
    @FXML private GridPane display;
    
    private FinancePlanner app;
    private ArrayList<Budget> budgets;
    private ArrayList<Transaction> transactions;
  
    /**
     * Initializes the controller class.
     * @param app
     */
    public void initialize(FinancePlanner app)
    {
        this.app = app;
        budgets = app.getBudgetHandler().getBudgets();
        transactions = app.getTransactionHandler().getTransactions();
        refresh();
    }
    
    /*
    Handles transaction button
    */
    @FXML
    private void handleTransactionButton()
    {
        app.showTransactionWindow();
    }
    
    /*
    Handles budget button
    */
    @FXML 
    private void handleBudgetButton()
    {
        app.showBudgetWindow();
    }
    
    /*
    Handles history button
    */
    @FXML 
    private void handleHistoryButton()
    {
        app.showHistoryWindow();
    }
    
    public void refresh()
    {
        //Todo
        wrapBudgets();
        wrapTransactions();
    }
    
    private void wrapBudgets()
    {   
        //Clear the element from the grid
        //(Retains a node and adds it to remember grid lines)
        Node node = display.getChildren().get(0);
        display.getChildren().clear();
        display.getRowConstraints().clear();
        display.getChildren().add(0, node);
        
        //Create a Row
        RowConstraints header = new RowConstraints();
        header.setMinHeight(50);
        display.getRowConstraints().add(header);
        //Create and add the header to the row
        Label category = new Label("Category");
        Label amount = new Label("Amount");
        Label progress = new Label("Progress");
        display.add(category, 0, 0);
        display.add(amount, 1, 0);
        display.add(progress, 2, 0);
        
        for(int i = 0; i < budgets.size(); i++)
        {
            //Create a row
            RowConstraints row = new RowConstraints();
            row.setMinHeight(50);
            display.getRowConstraints().add(row);
            //Wrap the budget information Nodes
            Budget budget = budgets.get(i);
            Label categoryLabel = new Label(budgets.get(i).getName());
            Label amountLabel = new Label(String.valueOf(budget.getAmount()));
            //Add the nodes to the grid
            display.add(categoryLabel, 0, i + 1);
            display.add(amountLabel, 1, i + 1);
        }
    }
    
    private void wrapTransactions()
    {
        
    }
}
