package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Controller for BudgetView Window
 */
public class BudgetViewController
{

    @FXML TextField categoryInput;
    @FXML TextField amountInput;
    @FXML DatePicker startInput;
    @FXML DatePicker endInput;
    @FXML Button saveButton;
    @FXML Button cancelButton;
    
    private FinancePlanner app;
    
    private BudgetHandler budgetHandler;
    
    /**
     * Initializes the controller class.
     * @param app
     */
    public void initialize(FinancePlanner app)
    {
        this.app = app;
        budgetHandler = app.getBudgetHandler();
    }
    
    /*
    Handles save button
    */
    @FXML
    private void handleSaveButton() throws SQLException
    {
        if(requestNewBudget() != null)
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
    From BudgetHandler, creates a new budget
    */
    public Budget requestNewBudget() throws SQLException
    {
        Budget newBudget = null;
        double amount = 0.0;
        
        if(checkInput())
        {
            try
            {
                amount = Double.parseDouble(amountInput.getText());
                newBudget = app.getBudgetHandler().createNewBudget(categoryInput.getText(), startInput.getValue().toString(), endInput.getValue().toString(), amount);
            }
            catch(NumberFormatException nfe)
            {
                app.showMessageWindow("Please enter a numeric value for a budget");
                newBudget = null;
                amountInput.setStyle("-fx-background-color: red;");
            }   
        } 
        else
        {
            app.showMessageWindow("One or more fields are missing");
        }
                
        return newBudget;
    }
    
    private boolean checkInput()
    {
        boolean complete = true;
        
        if(categoryInput.getText() == null)
        {
            complete = false;
            categoryInput.setStyle("-fx-background-color: red;");
        }
        if(amountInput.getText() == null)
        {
            complete = false;
            amountInput.setStyle("-fx-background-color: red;");
        }
        if(startInput.getValue() == null)
        {
            complete = false;
            startInput.setStyle("-fx-background-color: red;");
        }
        if(endInput.getValue() == null)
        {
            complete = false;
            endInput.setStyle("-fx-background-color: red;");
        }
        
        return complete;
    }
}
