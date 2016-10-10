package FinancialPlanner;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author stevenburns
 */
public class NewBudgetController
{

    @FXML private TextField categoryInput;
    @FXML private TextField amountInput;
    @FXML private DatePicker startInput;
    @FXML private DatePicker endInput;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
    public void initialize()
    {
        
    }    
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event)
    {
        //todo
        System.out.println("Feature not Supported yet");
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }   
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    @FXML
    private void handleCancelButtonAction(ActionEvent event)
    {
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }   
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    } 
}
