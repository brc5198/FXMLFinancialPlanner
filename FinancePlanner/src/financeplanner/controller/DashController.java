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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    
    //Settings
    private double warningThreshold = .5;
    private double dangerThreshold = .1;
  
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
        System.out.println("Hello, "+app.getUser().getFirstName());
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
        progress.setPadding(new Insets(0, 100, 0, 150));                        //TODO: find scalable method for centering label
        display.add(category, 0, 0);
        display.add(amount, 1, 0);
        display.add(progress, 2, 0);
        
        for(int i = 0; i < budgets.size(); i++)
        {
            //Create a row
            RowConstraints row = new RowConstraints();
            row.setMinHeight(50);
            display.getRowConstraints().add(row);
            //Labels
            Budget budget = budgets.get(i);
            Label categoryLabel = new Label(budgets.get(i).getName());
            Label amountLabel = new Label(String.valueOf(BudgetHandler.calculateBudgetRemainder(budget)));
            //Label amountLabel = new Label(String.valueOf(budget.getAmount()));
            
            //Progress Bar
            Rectangle progressBar = new Rectangle();
            double remainder = BudgetHandler.calculateBudgetRemainderPercent(budgets.get(i));
            double rectangleWidth = display.getColumnConstraints().get(2).getPrefWidth() * remainder;
              if(remainder <= dangerThreshold){progressBar.setFill(Color.RED);}
              else if(remainder <= warningThreshold){progressBar.setFill(Color.YELLOW);}
              else{progressBar.setFill(Color.GREEN);}
              progressBar.setWidth(rectangleWidth);
              progressBar.setHeight(46);
              
            //Add the nodes to the grid
            display.add(categoryLabel, 0, i + 1);
            display.add(amountLabel, 1, i + 1);
            display.add(progressBar, 2, i + 1);
        }
    }
    
    private void wrapTransactions()
    {
        
    }
}
