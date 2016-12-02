/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
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
        if(requestNewTransaction()!= null)
        {
            app.getDashControl().refresh();
            app.getPrimaryStage().setMinWidth(600);
            app.getPrimaryStage().setMaxWidth(600);
            app.resizeWindow(600, 400);
            app.removeWindows();
        }
        
    }
    
    /*
    Handles cancel button
    */
    @FXML
    private void handleCancelButton()
    {
        System.out.println("Cancel called");
        app.getPrimaryStage().setMinWidth(600);
        app.getPrimaryStage().setMaxWidth(600);
        app.resizeWindow(600, 400);
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
                    
                    Budget theSelectedBudget = app.getBudgetHandler().getBudgets().get(0);
                    for(int i = 0; i < app.getBudgetHandler().getBudgets().size(); i++) {
                        if(app.getBudgetHandler().getBudgets().get(i).getName().equals(budgetSelect.getSelectionModel().getSelectedItem().toString())) {
                            theSelectedBudget = app.getBudgetHandler().getBudgets().get(i);
                        }
                    }

                    newTransaction = app.getTransactionHandler().createNewTransaction(theSelectedBudget.getID(), amount, dateInput.getValue().toString(), locationInput.getText());

                    for(int i = 0; i < app.getBudgetHandler().getBudgets().size(); i++)
                    {
                        if(app.getBudgetHandler().getBudgets().get(i).getName().equals(budgetSelect.getSelectionModel().getSelectedItem()))
                        {
                            app.getBudgetHandler().getBudgets().get(i).getTransactions().add(newTransaction);
                        }
                    }
                }
                catch(NumberFormatException nfe)
                {
                    amountInput.setStyle("-fx-background-color: red;");
                    app.showMessageWindow("Please enter a numeric value for the amount");
                    newTransaction = null;
                }
            }
            else
            {
                app.showMessageWindow("A budget must first be created");
            }
        }
        else
        {
            app.showMessageWindow("One or more fields are missing");   
        }
        
        return newTransaction;
    }

    private boolean checkInput()
    {
        boolean complete = true;
        
        if(amountInput.getText() == null)
        {
            complete = false;
            amountInput.setStyle("-fx-background-color: red;");
        }
        if(locationInput.getText() == null)
        {
            complete = false;
            locationInput.setStyle("-fx-background-color: red;");
        }
        if(dateInput.getValue() == null)
        {
            complete = false;
            dateInput.setStyle("-fx-background-color: red;");
        }
        if(descriptionInput.getText() == null)
        {
            complete = false;
            descriptionInput.setStyle("-fx-background-color: red;");
        }
        
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
