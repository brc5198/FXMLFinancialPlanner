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
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Controller for TransactionView
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
     * @param app
     */
    public void initialize(FinancePlanner app)
    {
        this.app = app;
        transactionHandler = app.getTransactionHandler();
    }
    
    /*
    Handles save button
    */
    @FXML
    private void handleSaveButton()
    {
        System.out.println("Save called");
        app.removeWindows();
    }
    
    /*
    Handles cancel button
    */
    @FXML
    private void handleCancelButton()
    {
        System.out.println("Cancel called");
        app.removeWindows();
    }
    
    /*
    From TransactionHandler, creates new transaction
    */
    public Transaction requestNewTransaction()
    {
        Transaction newTransaction = null;
        double amount = 0;
        if(checkInput())
        {
            try
            {
                amount = Double.parseDouble(amountInput.getText());
            }
            catch(NumberFormatException nfe)
            {
                amount = 0;
            }
            
            newTransaction = app.getTransactionHandler().requestNewTransaction(amount, dateInput.getValue().toString(), locationInput.getText());
        }
        
        return newTransaction;
    }

    private boolean checkInput()
    {
        boolean complete = true;
        
        if(amountInput.getText() == null){complete = false;}
        if(locationInput.getText() == null){complete = false;}
        if(dateInput.getValue() == null){complete = false;}
        if(descriptionInput.getText() == null){complete = false;}
        
        return complete;
    }   
}
