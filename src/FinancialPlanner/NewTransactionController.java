/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bradcaviston
 */
public class NewTransactionController implements Initializable {
    
    @FXML private TextField locationField;
    @FXML private TextField amountField;
    @FXML private CheckBox nowBox;
    @FXML private CheckBox otherTimeBox;
    @FXML private DatePicker datePicker;
    public String testinginitialized ="working";
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

      public String getinitialized() {
        return testinginitialized;
    }
    @FXML
    private void handleOtherTimeBoxAction(ActionEvent event) {
        nowBox.setSelected(false);
        
        if (datePicker.isVisible()) {
            datePicker.setVisible(false);
        }
        else {
            datePicker.setVisible(true);
        }
    }
    
    @FXML
    private void handleNowBoxAction(ActionEvent event) {
        otherTimeBox.setSelected(false);
        
        if (datePicker.isVisible()) {
            datePicker.setVisible(false);
            
        }
    }
    
    @FXML
    private void handleCancelButtonAction(ActionEvent event) throws IOException {
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) throws IOException {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));/* Exception */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        
        MainMenuController controller = loader.getController();
        //TransactionHandler theTransactionHandler = controller.getTransactionHandler();
        TransactionHandler theTransactionHandler = new TransactionHandler();
        
        if(locationField.getText() != null && amountField.getText() != null) {
            LocalDate theDate;
            
            if(otherTimeBox.isSelected()) {
                
                theDate = datePicker.getValue();
            }
            else {
                theDate = LocalDate.now();
            }
            
            theTransactionHandler.getTransactionHistory().add(new Transaction(
                Double.parseDouble(amountField.getText()),
                theDate, 
                locationField.getText()
            ));
            
        }
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

  
    
}
