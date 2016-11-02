/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Transaction;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    @FXML ChoiceBox budgetSelect;
    
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
        
        choiceboxSetup();
    }
    
    /*
    Handles save button
    */
    @FXML
    private void handleSaveButton() throws SQLException
    {
        System.out.println("Save called");
        requestNewTransaction();
        app.getDashControl().refresh();
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
    public Transaction requestNewTransaction() throws SQLException
    {
        Transaction newTransaction = null;
        double amount = 0;
        if(checkInput())
        {
            if(!budgetSelect.getSelectionModel().getSelectedItem().equals("No Budgets"))
            {
                try
                {
                    amount = Double.parseDouble(amountInput.getText());
                }
                catch(NumberFormatException nfe)
                {
                    amount = 0;
                }
            
                newTransaction = app.getTransactionHandler().createNewTransaction(amount, dateInput.getValue().toString(), locationInput.getText());
                
                for(int i = 0; i < app.getBudgetHandler().getBudgets().size(); i++)
                {
                    if(app.getBudgetHandler().getBudgets().get(i).getName().equals(budgetSelect.getSelectionModel().getSelectedItem()))
                    {
                        app.getBudgetHandler().getBudgets().get(i).getTransactions().add(newTransaction);
                    }
                }
            }
            else
            {
                System.out.println("A budget must first be created");
                /*
                TODO:
                Notify user to create a budget
                */
            }
        }
        else
        {
            System.out.println("One or more fields are missing");
            /*
            TODO:
            Notify user of incorrect input
            */         
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
    
    private void choiceboxSetup()
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        if(!app.getBudgetHandler().getBudgets().isEmpty())
        {
            for(int i = 0; i < app.getBudgetHandler().getBudgets().size(); i++)
            {
                items.add(app.getBudgetHandler().getBudgets().get(i).getName());
            }
        }
        else
        {
            items.add("No Budgets");
        }
        
        budgetSelect.setItems(items);
        budgetSelect.getSelectionModel().selectFirst();
    }
}
