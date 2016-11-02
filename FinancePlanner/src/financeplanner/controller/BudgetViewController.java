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
        requestNewBudget();
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
            }
            catch(NumberFormatException nfe)
            {
                amount = 0;
            }

            newBudget = app.getBudgetHandler().createNewBudget(categoryInput.getText(), startInput.getValue().toString(), endInput.getValue().toString(), amount);    
        } 
        else
        {
            System.out.println("One or more fields are missing");
            /*
            TODO:
            Notify user of incorrect input
            */         
        }
        
         
        return newBudget;
    }
    
    private boolean checkInput()
    {
        boolean complete = true;
        
        if(categoryInput.getText() == null){complete = false;}
        if(amountInput.getText() == null){complete = false;}
        if(startInput.getValue().toString() == null){complete = false;}
        if(endInput.getValue().toString() == null){complete = false;}
        
        return complete;
    }
}
