/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
import financeplanner.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Ardjen
 */
public class DashController
{
    @FXML private Button transactionButton;
    @FXML private Button budgetButton;
    @FXML private Button historyButton;
    @FXML private GridPane display;
    
    private FinancePlanner app;
    /**
     * Initializes the controller class.
     */
    public void initialize()
    {
        // TODO
    }    
    
    @FXML
    private Transaction handleTransactionButton()
    {
        System.out.println("handleTransaction Called");
        app.showTransactionWindow();
        
        Transaction newTransaction = null;
        
        return newTransaction;
    }
    
    @FXML 
    private Budget handleBudgetButton()
    {
        System.out.println("handleBudget Called");
        app.showBudgetWindow();
        
        Budget newBudget = null;
        
        return newBudget;
    }
    
    @FXML 
    private void handleHistoryButton()
    {
        System.out.println("handleHistory Called");
    }

    public void setApp(FinancePlanner app)
    {
        this.app = app;
    }
    
}
