/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;


/**
 *
 * @author bradcaviston
 */
public class MainMenuController implements Initializable {

    
    @FXML private Label label;
    @FXML private TableView<Transaction> table;
    @FXML private TableColumn<Transaction, String> locationColumn;
    @FXML private TableColumn<Transaction, String> timeColumn;
    @FXML private TableColumn<Transaction, String> amountColumn;
    @FXML private Button newBudgetButton;
    
    private TransactionHandler theTransactionHandler = new TransactionHandler();
    
    @FXML
    private void handleNewBudgetAction(ActionEvent event)
    {
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("NewBudgetView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            /*
            Internal error caused by missing FXML file.
            Should probably quit the program. 
            */
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        label.setText("Work in progress...");
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("NewTransactionView.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        locationColumn.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().getTimeStampProperty());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().getAmountProperty());
        
        table.getItems().setAll(parseTransactionList());
    }
    public String getinitialized()
    {
        return "made the table";
    }
    
    private List<Transaction> parseTransactionList() {
        
        List<Transaction> returnedList = theTransactionHandler.getTransactionHistory();
        
        //Test Data
        returnedList.add(new Transaction(7.0, LocalDate.now(), "McDonald's"));
        returnedList.add(new Transaction(40.0, LocalDate.now(), "Target"));
        returnedList.add(new Transaction(15.0, LocalDate.now(), "iTunes"));
        
        return returnedList;
    }
    
    public TransactionHandler getTransactionHandler() {
        return theTransactionHandler;
    }

}
