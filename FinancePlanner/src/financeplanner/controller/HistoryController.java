/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
import financeplanner.model.Transaction;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller class
 *
 * @author bradcaviston
 */
public class HistoryController {

    @FXML private GridPane display;
    @FXML private Button okButton;
    
    private FinancePlanner app;
    private ArrayList<Transaction> transactions;
  
    /**
     * Initializes the controller class.
     * @param app
     */
    public void initialize(FinancePlanner app)
    {
        this.app = app;
        transactions = app.getTransactionHandler().getTransactions();
        refresh();
    }
    
    /*
    Handles transaction button
    */
    @FXML
    private void handleOkButton()
    {
        app.removeWindows();
        app.showDashWindow();
    }
    
    public void refresh()
    {
        //Todo
        wrapTransactions();
    }
    
    private void wrapTransactions()
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
        Label location = new Label("Location");
        Label amount = new Label("Amount");
        Label time = new Label("Time");
        display.add(location, 0, 0);
        display.add(amount, 1, 0);
        display.add(time, 2, 0);
        
        for(int i = 0; i < transactions.size(); i++)
        {
            //Create a row
            RowConstraints row = new RowConstraints();
            row.setMinHeight(50);
            display.getRowConstraints().add(row);
            //Wrap the budget information Nodes
            Label locationLabel = new Label(transactions.get(i).getLocation());
            Label amountLabel = new Label(String.valueOf(transactions.get(i).getAmount()));
            Label timeLabel = new Label(transactions.get(i).getTimeStamp());
            //Add the nodes to the grid
            display.add(locationLabel, 0, i + 1);
            display.add(amountLabel, 1, i + 1);
            display.add(timeLabel, 2, i + 1);
        }
        
    }
    
}
