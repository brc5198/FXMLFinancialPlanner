/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ardjen
 */
public class TransactionViewController
{
    @FXML TextField amountInput;
    @FXML TextField locationInput;
    @FXML DatePicker dateInput;
    @FXML TextArea descriptionInput;
    @FXML Button saveButton;
    @FXML Button cancelButton;
    
    private FinancePlanner app;
    
    private TransactionHandler transactionHandler;

    /**
     * Initializes the controller class.
     */
    public void initialize()
    {
        
    }
    
    @FXML
    public void handleSaveButton()
    {
        System.out.println("Save called");
        app.removeWindow();
    }
    
    @FXML
    public void handleCancelButton()
    {
        System.out.println("Cancel called");
        app.removeWindow();
    }
    
    public Transaction requestNewTransaction()
    {
        Transaction newTransaction = null;
        
        return newTransaction;
    }

    public void setApp(FinancePlanner app)
    {
        this.app = app;
    }
    
}
